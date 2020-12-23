package com.yjr.responseChain;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public class ThreeManager extends Manager{

    public ThreeManager(String name) {
        super(name);
    }

    @Override
    public void process(MyRequest request) {
        if(request.getPrice()>50000&&request.getPrice()<=500000){
            System.out.println(this.getName()+"审核人处理了请求");
        }else {
            throw new RuntimeException("超出审批金额！！没这么多钱");
        }
    }
}
