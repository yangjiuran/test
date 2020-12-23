package com.yjr.state;

/**
 * @author yangjiuran
 * @Date 2020/8/28
 */
public interface State {
    void deduceMoney();
    Boolean raffle();
    void presentPrize();
}
