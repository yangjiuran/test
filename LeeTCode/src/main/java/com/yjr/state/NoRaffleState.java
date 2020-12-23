package com.yjr.state;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public class NoRaffleState extends AbstractState{
    public NoRaffleState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduceMoney() {
        System.out.println("积分减少五十");
        super.setRaffle(true);
    }

    @Override
    public Boolean raffle() {
        super.getActivity().setState(super.getActivity().getCanRaffleState());
        return super.getRaffle();
    }

    @Override
    public void presentPrize() {

    }
}
