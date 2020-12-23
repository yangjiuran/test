package com.yjr.flyweight;


import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2020/7/30
 */
public class WebSiteFactory {
    static Map<String,WebSite> map=new HashMap();

    public static WebSite getInstance(String type){
        if(!map.containsKey(type)){
            map.put(type, new ConcreteWebSite(type));
        }
        return map.get(type);
    }
}
