package com.yjr.responseChain;

/**
 * @author yangjiuran
 * @Date 2020/9/1
 */
public class TwoManager extends Manager{

    public TwoManager(String name) {
        super(name);
    }

    @Override
    public void process(MyRequest request) {
        if(request.getPrice()>=5000&&request.getPrice()<=50000){
            System.out.println(this.getName()+"审核人处理了请求");
        }else {
            this.getNextManager().process(request);
        }
    }
}
