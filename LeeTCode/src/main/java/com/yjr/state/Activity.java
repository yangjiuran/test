package com.yjr.state;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public class Activity {

    private CanRaffleState canRaffleState;
    private NoRaffleState noRaffleState;
    private DispendPrizaState dispendPrizaState;
    private DispendOutState dispendOutState;

    public DispendOutState getDispendOutState() {
        return dispendOutState;
    }

    public void setDispendOutState(DispendOutState dispendOutState) {
        this.dispendOutState = dispendOutState;
    }

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public DispendPrizaState getDispendPrizaState() {
        return dispendPrizaState;
    }

    public void setDispendPrizaState(DispendPrizaState dispendPrizaState) {
        this.dispendPrizaState = dispendPrizaState;
    }

    public NoRaffleState getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(NoRaffleState noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public CanRaffleState getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(CanRaffleState canRaffleState) {
        this.canRaffleState = canRaffleState;
    }
}
