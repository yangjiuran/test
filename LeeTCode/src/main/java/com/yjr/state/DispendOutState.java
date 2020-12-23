package com.yjr.state;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public class DispendOutState extends AbstractState{
    public DispendOutState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduceMoney() {
        System.out.println("抽奖获得已经结束~~~");
    }

    @Override
    public Boolean raffle() {
        return null;
    }

    @Override
    public void presentPrize() {

    }
}
