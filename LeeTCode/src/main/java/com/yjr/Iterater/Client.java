package com.yjr.Iterater;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class Client {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<>();
        ComputerCollege computerCollege = new ComputerCollege();
        computerCollege.addDepartMent("家电维修专业","家电维修");

        colleges.add(computerCollege);
        colleges.add(new InfoCollege());

        OutPutImpl outPut = new OutPutImpl(colleges);
        outPut.print();
    }
}
