package com.yjr.obeserver;

/**
 * @author yangjiuran
 * @Date 2020/8/19
 */
public interface Subject {
    void registry(Obeserver obeserver);
    void remove(Obeserver obeserver);
    void notifiedObserver();
}
