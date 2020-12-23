package com.yjr.responseChain;

/**
 * @author yangjiuran
 * @Date 2020/9/2
 */
public class Client {
    public static void main(String[] args) {
        MyRequest myRequest = new MyRequest(1, 500);
        Manager one = new OneManager("一号");
        Manager two = new TwoManager("二号");
        Manager three = new ThreeManager("三号");

        one.setNextManager(two);
        two.setNextManager(three);

        one.process(myRequest);
    }
}
