package com.yjr.build;

/**
 * @author yangjiuran
 * @Date 2020/7/12
 */
public abstract class HouseBuild {
    protected House house =new House();

    public abstract void buildBasic();
    public abstract void buildWall();
    public abstract void buildRoofed();


}
