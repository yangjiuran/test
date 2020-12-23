package com.yjr.state;

import java.util.Random;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public class CanRaffleState extends AbstractState{
    public CanRaffleState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduceMoney() {
        System.out.println("已扣除积分，开始抽奖~~~");

    }

    @Override
    public Boolean raffle() {
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println(i);
        if(i==1){
            System.out.println("恭喜你中奖");
            super.getActivity().setState(super.getActivity().getDispendPrizaState());
        }else {
            System.out.println("很遗憾，未中奖~~~");
            super.getActivity().setState(super.getActivity().getNoRaffleState());

        }
        super.setRaffle(false);
        return super.getRaffle();
    }

    @Override
    public void presentPrize() {

    }
}
