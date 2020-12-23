package com.yjr.dataStructure.tree.HuffmanCode;

import com.yjr.briage.LEDPhone;

import java.io.*;
import java.util.*;

/**
 * @author yangjiuran
 * @Date 2020/12/7
 */
public class HuffmanCode {
    public static void main(String[] args) {
/*        String str ="i like like like java do you like a java";
        List list = getList(str.getBytes());
        Node tree = getTree(list);
//        preOrder(tree);
        getCode(tree,"",stringBuffer);
        byte[] zip = zip(str.getBytes());
//        System.out.println(Arrays.toString(zip));
        byte a=-1;
        byte[] bytes = reversHuffmanCode(zip);
        System.out.println(new String(bytes));*/
/*        zipFile("D:\\image\\2.bmp","D:\\image\\2.zip");
        System.out.println("压缩成功");*/
        unZipFile("D:\\image\\2.zip","D:\\image\\2bac.bmp");
        System.out.println("解压缩成功");
    }

    static StringBuffer stringBuffer=new StringBuffer();
    static Map<Byte,String> codeMap=new HashMap();

    /**
     * 解压文件
     * @param src 源文件路径
     * @param dst 目标文件路径
     */
    public static void unZipFile(String src,String dst){
        File file = new File(src);
        FileInputStream fileInputStream =null;
        ObjectInputStream ois = null;
        FileOutputStream os =null;
        try {
            fileInputStream = new FileInputStream(file);
            ois = new ObjectInputStream(fileInputStream);
            byte[]  b= (byte[]) ois.readObject();
            codeMap= (Map<Byte, String>) ois.readObject();
            byte[] bytes = reversHuffmanCode(b);
            os = new FileOutputStream(dst);
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                ois.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 压缩文件
     * @param src 源文件路径
     * @param dst 目标文件路径
     */
    private static void zipFile(String src,String dst){
        //创建输入输出流
        FileInputStream inputStream =null;
        FileOutputStream os=null;
        ObjectOutputStream oos=null;
        try {
            File file = new File(src);
            inputStream=new FileInputStream(file);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            byte[] zipBytes = huffmanZip(b);
            os = new FileOutputStream(dst);
            oos = new ObjectOutputStream(os);
            oos.writeObject(zipBytes);
            oos.writeObject(codeMap);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static byte[] huffmanZip(byte[] bytes){
        List list = getList(bytes);
        Node tree = getTree(list);
//        preOrder(tree);
        getCode(tree,"",stringBuffer);
        byte[] zip = zip(bytes);
        return zip;
    }
    /**
     * 将哈夫曼字节数组解压成哈夫曼编码
     * @param codes
     * @return
     */
    private static byte[] reversHuffmanCode(byte[] codes){
        Map<String, Byte> map = new HashMap<>();
        for (Byte key : codeMap.keySet()) {
            map.put(codeMap.get(key),key);
        }
        StringBuffer s=new StringBuffer();
        for (int i = 0; i < codes.length; i++) {
            boolean flag=(i==codes.length-1);
            s.append(byteToHuffmanCode(!flag, codes[i])) ;
        }
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            boolean flag=true;
            int count=1;
            while (flag){
                if(map.containsKey(s.substring(i,i+count)) ){
                    Byte b = map.get(s.substring(i, i + count));
                    list.add(b);
                    flag=false;
                }else {
                    count++;
                }
            }
            i=i+count;
        }
        byte[] bytes=new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i]=list.get(i);
        }
        return bytes;
    }

    /**
     * 将字节解压成哈夫曼编码
     * @param flag
     * @param b
     * @return
     */
    public static String byteToHuffmanCode(boolean flag,byte b){
        int temp=b;
        if(flag){
             temp |=256;
        }
        String s = Integer.toBinaryString(temp);
        if(flag){
            s=s.substring(s.length()-8);
            return s;
        }else {
            return s;
        }
    }

    /**
     * 将传入的字符数组按照哈夫曼编码转换成字节数组
     * @param str
     */
    public static byte[] zip(byte[] str){
        if(str.length==0){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : str) {
            stringBuffer.append(codeMap.get(b));
        }
        String huffmanCodeStr = stringBuffer.toString();
        int len=(huffmanCodeStr.length()+7)/8;
        byte[] bytes = new byte[len];
        int index=0;
        for (int i = 0; i < huffmanCodeStr.length(); i+=8) {
            if((i+8)<huffmanCodeStr.length()){
                byte b=(byte) Integer.parseInt(huffmanCodeStr.substring(i,i+8),2);
                bytes[index]=b;
            }else {
                byte b=(byte) Integer.parseInt(huffmanCodeStr.substring(i,huffmanCodeStr.length()),2);
                bytes[index]=b;
            }
            index++;
        }
        return bytes;
    }
    /**
     * 生成赫夫曼编码表
     * @param node
     * @param code
     * @param stringBuffer
     */
    public static void getCode(Node node,String code,StringBuffer stringBuffer){
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer);
        stringBuffer2.append(code);
        if(node!=null){
            if(node.c==null){
                getCode(node.left,"0",stringBuffer2);
                getCode(node.right,"1",stringBuffer2);
            }else {
                codeMap.put(node.c,stringBuffer2.toString());
            }
        }
    }
    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(Node root){
        if(root!=null){
         root.preOrder();
        }
    }

    /**
     * 将node的集合按照weight为权重形成哈夫曼树
     * @param list
     * @return
     */
    public static Node getTree(List<Node> list){
        while (list.size()>1){
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(left.weight + right.weight, null);
            parent.left=left;
            parent.right=right;

            list.add(parent);
            list.remove(left);
            list.remove(right);
        }
        return list.get(0);
    }

    /**
     * 将字符串对应的字节数组，按照字节分组统计数量，并形成Node
     * @param str
     * @return
     */
    public static List<Node> getList(byte[] str){
        List<Node> list=new ArrayList();
        Map<Byte, Integer> map = new HashMap<>();
        for (Byte b : str) {
            Integer counts = map.get(b);
            if(counts==null){
                map.put(b,1);
            }else {
                map.put(b,counts+1);
            }
        }
        for (Byte key : map.keySet()) {
            list.add(new Node(map.get(key), key));
        }
        return list;
    }
}

class Node implements Comparable<Node> {
    int weight;
    Byte c;
    Node left;
    Node right;

    public Node(int weight, Byte c) {
        this.weight = weight;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Node{" + "weight=" + weight + ", char=" + c + '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();

        }
    }
}
