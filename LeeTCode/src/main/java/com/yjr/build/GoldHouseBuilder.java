package com.yjr.build;

/**
 * @author yangjiuran
 * @Date 2020/7/12
 */
public class GoldHouseBuilder extends  HouseBuild{
    @Override
    public void buildBasic() {
        super.house.setHouseBasic("金色的房子地基100m");
    }

    @Override
    public void buildWall() {
        super.house.setHouseWall("金色的房子墙100cm");
    }

    @Override
    public void buildRoofed() {
        super.house.setRoofed("金色的的屋顶");
    }
}
