package com.yjr.Visitor;

/**
 * @author yangjiuran
 * @Date 2020/8/18
 */
public class Client {
    public static void main(String[] args) {
        Action success = new Success();
        Action fail = new Fail();
        Action mid = new Mid();
        Man man = new Man(success);
        Woman woman = new Woman(fail);
        Woman woman2 = new Woman(mid);

        ObjdecStructure structure = new ObjdecStructure();
        ObjdecStructure.setList(man);
        ObjdecStructure.setList(woman);
        ObjdecStructure.setList(woman2);

        structure.dispaly();
    }
}
