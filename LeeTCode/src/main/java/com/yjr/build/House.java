package com.yjr.build;

/**
 * @author yangjiuran
 * @Date 2020/7/12
 */
public class House {
    private  String  houseBasic;
    private  String  houseWall;
    private  String  roofed;

    public String getHouseBasic() {
        return houseBasic;
    }

    public void setHouseBasic(String houseBasic) {
        this.houseBasic = houseBasic;
    }

    public String getHouseWall() {
        return houseWall;
    }

    public void setHouseWall(String houseWall) {
        this.houseWall = houseWall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    @Override
    public String toString() {
        return "House{" + "houseBasic='" + houseBasic + '\'' + ", houseWall='" + houseWall + '\'' + ", roofed='" + roofed + '\'' + '}';
    }
}
