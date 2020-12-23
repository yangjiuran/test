package com.yjr.state;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public class DispendPrizaState extends AbstractState{
    public DispendPrizaState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduceMoney() {
        System.out.println("已中奖，开始发放奖品");
    }

    @Override
    public Boolean raffle() {
        return null;
    }

    @Override
    public void presentPrize() {
        System.out.println("奖品发放~~~");
        if(super.getPrizeCount()<=0){
            System.out.println("奖品已经发完~~~");
            super.setRaffle(false);
        }else {
            super.getActivity().setState(super.getActivity().getDispendOutState());
        }

    }
}
