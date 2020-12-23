package com.yjr.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class ObjdecStructure {
    private static List<Person> list=new ArrayList<>();

    public static void setList(Person person){
        list.add(person);
    }

    public static void removeList(Person person){
        list.remove(person);
    }

    public void dispaly(){
        for (Person person : list) {
            person.accept();
        }
    }
}
