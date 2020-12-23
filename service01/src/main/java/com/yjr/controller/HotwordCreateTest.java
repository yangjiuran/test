package com.yjr.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.yjr.entity.HotwordCreateEntity;

import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户将xlsx转换成sql语句
 * @author yangjiuran
 * @Date 2020/6/18
 */
public class HotwordCreateTest {
    public static void main(String[] args) {
        try {
            ImportParams params = new ImportParams();
            ExcelImportResult<HotwordCreateEntity> result = ExcelImportUtil.importExcelMore(
                    new File("G:\\work\\data\\sql\\hotword.xlsx"),
                    HotwordCreateEntity.class, params);
            List<HotwordCreateEntity> list = result.getList();
            Map<String, List<HotwordCreateEntity>> map = new HashMap<>();
            for (HotwordCreateEntity po : list) {
                if(map.containsKey(po.getTableCode())){
                    List<HotwordCreateEntity> poList = map.get(po.getTableCode());
                    poList.add(po);
                    map.replace(po.getTableCode(),poList);
                }else {
                   List<HotwordCreateEntity> poList= new ArrayList<HotwordCreateEntity>();
                    poList.add(po);
                    map.put(po.getTableCode(),poList);
                }
            }
            for (String s : map.keySet()) {
                foramtToSql(s,map.get(s));
            }
            System.out.println(map.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String CREATE_HEAD="CREATE TABLE ";
    private static String COMMENT="COMMENT ON COLUMN ";
    private static String foramtToSql(String tableCode, List<HotwordCreateEntity> list){
        String reStr = "";
        List<String> commentList=new ArrayList<>();
        reStr=CREATE_HEAD+tableCode+ "( ";
        for (int i = 0;i < list.size(); i++) {
            String type = list.get(i).getType();
            if("VARCHAR2".equals(type)){
                type="VARCHAR2(256)";
            }
            if((i+1)==list.size()){
                reStr=reStr+"\""+list.get(i).getCode()+"\" "+type;
            }else {
                reStr=reStr+"\""+list.get(i).getCode()+"\" "+type+",";
            }
            if(!StringUtils.isEmpty(list.get(i).getName())){
                String comStr=COMMENT+ tableCode+"."+list.get(i).getCode()+" IS "+"\'"+list.get(i).getName()+"\' ;";
                commentList.add(comStr);
            }

        }
        reStr=reStr+");";
        System.out.println(reStr);
        for (String s : commentList) {
            System.out.println(s);
        }
        return reStr;
    }
}
