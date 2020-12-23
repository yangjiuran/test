package com.yjr.state;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public class Client {
    public static void main(String[] args) {
        Activity activity = new Activity();
        NoRaffleState noRaffleState = new NoRaffleState(activity);
        CanRaffleState canRaffleState = new CanRaffleState(activity);
        DispendOutState dispendOutState = new DispendOutState(activity);
        DispendPrizaState dispendPrizaState = new DispendPrizaState(activity);

        activity.setNoRaffleState(noRaffleState);
        activity.setCanRaffleState(canRaffleState);
        activity.setDispendPrizaState(dispendPrizaState);
        activity.setDispendOutState(dispendOutState);

        activity.setState(noRaffleState);
        for (int i = 0; i < 30; i++) {
            System.out.println("--------------");
            State state = activity.getState();
            state.deduceMoney();
            state.raffle();
            state.presentPrize();
        }
    }
}
