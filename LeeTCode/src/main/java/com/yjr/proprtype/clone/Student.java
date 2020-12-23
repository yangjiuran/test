package com.yjr.proprtype.clone;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/7/10
 */
public class Student implements Serializable,Cloneable{
    public String name;
    public String age;
    public Course course;

    public Student(){
        super();
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student copy =null;
        ByteOutputStream bos =null;
        ObjectOutputStream oos =null;
        ByteInputStream bis=null;
        ObjectInputStream ois=null;
        try {
            bos = new ByteOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteInputStream(bos.toByteArray(),bos.toByteArray().length);
            ois = new ObjectInputStream(bis);
            copy= (Student) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return copy;
    }
}
