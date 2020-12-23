package com.yjr.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2019/12/9
 */
public class XiaoMei {
    List<Person> list=new ArrayList<Person>();
    public XiaoMei(){}
    public void addList(Person person){
        list.add(person);
    }
    public void notifyPerson(){
        list.forEach(s->{
            s.getMessage("你们谁来陪我打游戏");
        });
    }
}
