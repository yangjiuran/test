# encoding: utf-8
####################### 程序参数配置区 ############################
## 文件下载FTP参数
Host0 = '10.138.6.78'                           # ftp地址
Port0 = 21                          # 端口号
User0 = 'qxleida'                           # 用户名
pwd0 = 'qxld*123'                            # 密码
fileurl = './jysoft/data/radar_txt'                  # ftp txt文件存储路径

## 文件上传FTP参数
Host1 = '10.138.76.18'               # ftp地址
Port1 = 22                           # 端口号
User1 = 'd5000'                           # 用户名
pwd1 = 'AHDL3-proxy01'                            # 密码
imgurl = '/home/d5000/anhui/QXYB'                  # ftp 图片上传路径

## 本地存储参数
#datapath = r'/home/ef/dev/py_script/leidatu/data_new'       # txt文件下载路径
#datapath = r'/home/radar_txt'  #txt文件下载本地路径
#imagespath = r'/home/ef/dev/py_script/leidatu/images' /home/ef/dev/hf_geoserver2.12.2/webapps/hfqdl  # 图片存储路径
#imagespath = r'/home/ef/dev/hf_geoserver2.12.2/webapps/hfqdl'  # 图片存储路径
#shppath = r'/home/ef/dev/py_script/leidatu/shp'         # shp文件存储路径

## 本地存储参数
datapath = r'D:\leidatu\data_new'       # txt文件下载路径
imagespath = r'D:\leidatu\images'   # 图片存储路径
shppath = r'D:\leidatu\shp'         # shp文件存储路径


##################################################################

import re
import os
import sys
import ftplib
import struct
import datetime
import numpy as np
import shapefile as shp
import matplotlib as mpl
import PIL.Image as Image
import matplotlib.pyplot as plt
import io
import traceback
from datetime import datetime

global copTime, colormap
copTime = re.compile(r'\d{4}\d{2}\d{2}\d{2}\d{2}')
# colormap=[[255,255,255],[199,195,255],[122,112,239],[24,36,215],[165,255,173],[0,235,0],[16,147,24],[255,247,98],[207,203,0],[141,143,0],[255,175,173],[255,100,82],[239,0,48],[215,143,255],[173,36,255]]  #15
# colormap=[[255,255,255],[255,255,255],[255,255,255],[255,255,255],[165,255,173],[0,235,0],[16,147,24],[255,247,98],[207,203,0],[141,143,0],[255,175,173],[255,100,82],[239,0,48],[215,143,255],[173,36,255]]  #15
# 新色卡
colormap=[[255,255,255],[255,255,255],[1,160,246],[0,236,236],[0,216,0],[1,144,0],[255,255,0],[231,192,0],[255,144,0],[255,0,0],[214,0,0],[192,0,0],[255,0,240],[150,0,180],[173,144,240]]
colormap=np.array(colormap)/255

global lat, lon, numLat, numLon, on_grid, lat_grid
startLon = 113
startLat = 27.01
endLon = 120.99
endLat = 36
numLon = 800
numLat = 900
lat=np.arange(startLat-0.005,endLat,0.01)
lon=np.arange(startLon-0.005,endLon,0.01)
lon_grid,lat_grid=np.meshgrid(lon,lat)


def readData(filepath):
    """
    读取txt文件数据

    Argv:
        filepath: 文件全路径

    Return:
        data: 气象数据
    """
    with open(filepath, 'r') as text:
        rawData = text.read()
        rawDataList = rawData.split('\n')
    data = []
    for rawdata in rawDataList:
        rawdata = rawdata.split(' ')
        temp = []
        for x in rawdata:
            try:
                temp.append(float(x))
            except:
                pass
        data.extend(temp)
    delta = numLat*numLon-len(data)
    data.extend([0.0]*delta)
    data = np.array(data)
    data = data.reshape((numLat, numLon))
    return data


def txtDrawImage(pintu, name, dpi=1):
    fig = plt.figure()
    cm_light = mpl.colors.ListedColormap(colormap)#设置colormap实例

    plt.axis('off')
    plt.gca().xaxis.set_major_locator(plt.NullLocator())
    plt.gca().yaxis.set_major_locator(plt.NullLocator())
    plt.subplots_adjust(top=1, bottom=0, right=1, left=0, hspace=0, wspace=0)
    plt.margins(0, 0)

    #plt.pcolormesh(lon_grid, lat_grid, pintu,cmap=cm_light)
    plt.pcolormesh(lon_grid, lat_grid, pintu.reshape(lon_grid.shape),shading='auto',cmap=cm_light)
    plt.clim(0,70)
    fig.set_size_inches(numLon, numLat)
    try:
        plt.savefig(name+'.real.png', dpi = dpi, transparent=True)
    except:
        pass
        # plt.show()
    plt.close()
    with Image.open(name+'.real.png') as img:
        img = transparent_back(img)
        # img = img.transpose(Image.FLIP_TOP_BOTTOM)
        img.save(name+'.real.png')
        #图片大小
        imgByteArr = io.BytesIO()
        img.save(imgByteArr, format='PNG')
        imgByteArr = imgByteArr.getvalue()
        size = len(imgByteArr)
        size = "{}kb".format(size / 1e3)
    return size


def transparent_back(img):
    img = img.convert('RGBA')
    L, H = img.size
    color_0 = img.getpixel((0,0))
    for h in range(H):
        for l in range(L):
            dot = (l,h)
            color_1 = img.getpixel(dot)
            if color_1 == color_0:
                color_1 = color_1[:-1] + (0,)
                img.putpixel(dot,color_1)
    return img

def genarateSHPfile(pintu, name):
    cm_light = mpl.colors.ListedColormap(colormap)#设置colormap实例
    Levels = [0,5,10,15,20,25,30,35,40,45,50,55,60,65,70]
    nLevel = len(Levels)
    cs = plt.contour(lon_grid, lat_grid, pintu, Levels, alpha = 1, cmap=cm_light)
    # plt.show()
    levels = []
    for ind in range(0, nLevel+0):
        level = []
        try:
            temp = cs.collections[nLevel-ind].get_paths()
        except:
            continue
        for i in range(len(temp)):
            level.append(temp[i].vertices[::-1].tolist())
        levels.append(level)
    # 生成shp文件
    with shp.Writer(name) as w:
        w.autoBalance = 1
        w.field('Data', 'C')
        ll = []
        for ind in range(len(levels)):
            if 14 - ind >= 10:
                ll.append(14-ind)
                if len(levels[ind]) == 0:
                    pass
                else:
                    ll.append(14-ind)
                    w.poly(levels[ind])
                    w.record(str(14-ind))
    try:
        maxlevel = str(max(ll))
    except:
        maxlevel = None
    return maxlevel

def genarateSHPfile_zs(pintu, name):
    cm_light = mpl.colors.ListedColormap(colormap)#设置colormap实例
    Levels = [0,5,10,15,20,25,30,35,40,45,50,55,60,65,70]
    nLevel = len(Levels)
    cs = plt.contour(lon_grid, lat_grid, pintu, Levels, alpha = 1, cmap=cm_light)
    # plt.show()
    levels = []
    for ind in range(1, nLevel-0):
        level = []
        try:
            temp = cs.collections[nLevel-ind].get_paths()
        except:
            continue
        for i in range(len(temp)):
            level.append(temp[i].vertices[::-1].tolist())
        levels.append(level)
    # 生成shp文件
    with shp.Writer(name) as w:
        w.autoBalance = 1
        w.field('Data', 'C')
        ll = []
        for ind in range(len(levels)):
            if 16 - ind >= 13:
                ll.append(16 - ind)
                if len(levels[ind]) == 0:
                    pass
                else:
                    ll.append(16 - ind)
                    w.poly(levels[ind])
                    w.record(str(16 - ind))
    try:
        maxlevel_zs = str(max(ll))
    except:
        maxlevel_zs = None
    return maxlevel_zs

def ftpConnect(Host, Port, User, pwd):
    """连接FTP"""
    ftp = ftplib.FTP()
    ftp.connect(host=Host, port=Port)
    # print(ftp.getwelcome())
    ftp.login(user=User,passwd=pwd)
    return ftp


def ftpDownloads(startTime):
    """从ftp下载数据"""
    # print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    ftp = ftpConnect(Host0, Port0, User0, pwd0)
    # print("Downloading...")
    file_list = ftp.nlst(fileurl)
    #只提取txt格式的文件
    file_list = [x for x in file_list if x.endswith('.txt')]
    #print(file_list)
    for file in file_list:
        fileTime = int(re.findall(copTime,file)[0])
        name = file.split(r'/')[-1]
        # 时间差在规定时间内则下载该数据文件
        if fileTime > startTime:
            with open(datapath+'/'+name, 'w') as fil:
                # ftp.retrbinary('RETR ' + file, fil.write, buf_size)
                ftp.retrlines('RETR ' + file, fil.write)
            fsize =  os.path.getsize(datapath+'/'+name)
            if int(fsize/1024) == 0:
                os.remove(datapath+'/'+name)
                with open(datapath+'/'+name, 'w') as fil:
                    # ftp.retrbinary('RETR ' + file, fil.write, buf_size)
                    ftp.retrlines('RETR ' + file, fil.write)
    ftp.close()
    ftp.quit()

def ftpUploads(imagesList):
    """给ftp上传数据"""
    buf_size = 1024
    ftp = ftpConnect(Host1, Port1, User1, pwd1)
    # imagesList = os.listdir(imagespath)
    for image in imagesList:
        with open(imagespath+'/'+image, 'rb') as fil:
            ftp.storbinary('STOR ' + imgurl + '/' + image, fil, buf_size)
    ftp.close()
    ftp.quit()


def txtDownloads(startTime):
    """从本地下载数据"""
    filelist = os.listdir(datapath) #从本地读取数据
    file_list = [x for x in filelist if x.endswith('.txt')]
    file_lists = []
    for file in file_list:
        fileTime = int(re.findall(copTime,file)[0])
        name = file.split(r'/')[-1]
        # 时间差在规定时间内则下载该数据文件
        if fileTime > startTime:
            fsize =  os.path.getsize(datapath+'/'+name)
            if int(fsize/1024) == 0:
                os.remove(datapath+'/'+name)
            else:
                file_lists.append(name)
    return file_lists

def mklogpath(logname,logpath):
    logpath=logpath+logname+'_errorlog.txt'
    return logpath

def UserExceptHook(tp, val, tb):
    #tp-异常类型、val-异常值、tb-异常跟踪栈
    fError = open(logpath,mode='a')
    traceList = traceback.format_tb(tb)
    html = repr(tp) + "\n"
    html += (repr(val) + "\n")
    for line in traceList:
        html += (line + "\n")
    #print(html,file=sys.stderr)
    print(datetime.now(),file=fError)
    print(html,file=fError)
    fError.close()


if __name__ == "__main__":

    """
    生成运行日志
    """
    logname='python'
    logpath=imagespath+'/' #日志保存路径为图片保存路径
    logpath=mklogpath(logname,logpath)
    sys.excepthook = UserExceptHook

    """
    绘图，生成shp
    """
    startTime = int(sys.argv[1])
    # startTime = 201907300830
    #ftpDownloads(startTime) #从ftp下载数据
    file_lists = txtDownloads(startTime) #从本地读取数据
    # print("Data analysising...")
    imgNames = []
    shpNames = []
    shpNames_zs = []
    imgSize = []
    maxlevel = None
    maxlevel_zs = None
    for datafile in file_lists:
        filename = datapath+'/'+ datafile
        # print("File("+filename+") is analysising...")
        name, type = os.path.splitext(filename)
        name = name.split('/')[-1]
        imagename = imagespath+'/'+name
        # print("File(" + imagename + ") is analysising...")
        # 绘制png图片
        if type == '.txt':
            pintu = readData(filename)
            size = txtDrawImage(pintu, imagename, dpi = 1)
            imgNames.append(imagename+'.real.png')
            shpname = shppath+'/'+name
            shpname_zs = shppath+'/'+name+"_zs"
            maxlevel = genarateSHPfile(pintu, shpname)
            maxlevel_zs = genarateSHPfile_zs(pintu, shpname_zs)
            shpNames.append(shpname+'.shp')
            shpNames_zs.append(shpname_zs + '.shp')
            imgSize.append(size)
            #os.remove(filename)
    imgNs = ""
    imagesList = []
    for name in imgNames:
        imgNs += name.split('/')[-1] +','
        imagesList.append(name.split('/')[-1])
    shpFilesNs = ""
    shpFilesNs_zs = ""
    for name in shpNames:
        shpFilesNs += name.split('/')[-1] +','
    #print(imgNs[:-1] + "|" + shpFilesNs[:-1])
    for name in shpNames_zs:
        shpFilesNs_zs += name.split('/')[-1] +','
    imgsz = ""
    for s in imgSize:
        imgsz += str(s).split('/')[-1] +','
    #print(imgNs[:-1] + "|" + shpFilesNs[:-1]+ "|"+imgsz[:-1]+ "|"+maxlevel) #返回图片名称和大小
    sclevel = maxlevel_zs
    if maxlevel_zs is None:
        sclevel = maxlevel
    if maxlevel is None:
        sclevel = str(9)
    else:
        sclevel = str(9)
    print(imgNs[:-1] + "|" + shpFilesNs[:-1]+ "|"+ shpFilesNs_zs[:-1]+ "|"+imgsz[:-1]+ "|"+sclevel) #返回图片名称和大小
    #ftpUploads(imagesList)




