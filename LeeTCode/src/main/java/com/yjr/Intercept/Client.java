package com.yjr.Intercept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2020/8/25
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        Map value = getValue(expStr);
        Calculate calculate = new Calculate(expStr);
        int run = calculate.run(value);
        System.out.println(run);

    }
    public static String getExpStr() throws IOException {
        System.out.println("请输入表示：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static Map getValue(String expStr) throws IOException {
        HashMap<Object, Object> map = new HashMap<>();
        for (char c : expStr.toCharArray()) {
            if(c!='+'&&c!='-'){
                System.out.println("请输入"+c+"的值：");
                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
                map.put(String.valueOf(c),s);
            }
        }
        return map;
    }
}
