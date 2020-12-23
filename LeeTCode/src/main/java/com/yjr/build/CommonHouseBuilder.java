package com.yjr.build;

/**
 * @author yangjiuran
 * @Date 2020/7/12
 */
public class CommonHouseBuilder extends  HouseBuild{
    @Override
    public void buildBasic() {
        super.house.setHouseBasic("普通的房子地基10m");
    }

    @Override
    public void buildWall() {
        super.house.setHouseWall("普通的房子墙10cm");
    }

    @Override
    public void buildRoofed() {
        super.house.setRoofed("普通的的屋顶");
    }
}
