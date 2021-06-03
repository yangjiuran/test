package com.yjr.other;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author yangjiuran
 * @Date 2021/1/25
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode187 {
    public static void main(String[] args) {
        List<String> res = findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(res.toString());
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        /*int length = s.length();
        int index = 0;
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            if (index > length - 10) {
                break;
            }
            String str = s.substring(index, index + 10);
            if(map.containsKey(str)){
                Integer count = map.get(str);
                count+=1;
                map.replace(str,count);
            }else {
                map.put(str, 0);
            }
            for (int i = index+1; i < length - 10; i++) {
                int start = i;
                int end = i + 10;
                String substring = s.substring(start, end);
                if (str.equals(substring)) {
                    Integer count = map.get(str);
                    count+=1;
                    map.replace(str,count);
                }
            }
            index++;
        }
        for (String s1 : map.keySet()) {
            if(map.get(s1)>0){
                res.add(s1);
            }
        }
        return res;*/
        int length = s.length();
        ArrayList<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= length - 10;i++ ) {
            start = i;
            end = i + 10;
            String substring = s.substring(start, end);
            if (map.containsKey(substring)) {
                Integer count = map.get(substring);
                count += 1;
                map.replace(substring, count);
            } else {
                map.put(substring, 0);
            }

            System.out.println(i);
        }
        for (String s1 : map.keySet()) {
            if (map.get(s1) > 0) {
                res.add(s1);
            }
        }
        return res;
    }
}
