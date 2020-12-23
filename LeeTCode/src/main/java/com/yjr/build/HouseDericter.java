package com.yjr.build;

/**
 * @author yangjiuran
 * @Date 2020/7/12
 */
public class HouseDericter {
    HouseBuild houseBuild=null;

    public HouseDericter(HouseBuild houseBuild) {
        this.houseBuild = houseBuild;
    }

    public HouseBuild getHouseBuild() {
        return houseBuild;
    }

    public void setHouseBuild(HouseBuild houseBuild) {
        this.houseBuild = houseBuild;
    }
    public House build(){
        houseBuild.buildBasic();
        houseBuild.buildWall();
        houseBuild.buildRoofed();
        return houseBuild.house;
    }
}
