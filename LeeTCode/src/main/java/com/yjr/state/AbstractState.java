package com.yjr.state;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public abstract class AbstractState implements State {
    private int PrizeCount=1;
    private Boolean raffle=false;
    private Activity activity;

    public AbstractState(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getPrizeCount() {
        return PrizeCount;
    }

    public void setPrizeCount(int prizeCount) {
        PrizeCount = prizeCount;
    }

    public Boolean getRaffle() {
        return raffle;
    }

    public void setRaffle(Boolean raffle) {
        this.raffle = raffle;
    }
}
