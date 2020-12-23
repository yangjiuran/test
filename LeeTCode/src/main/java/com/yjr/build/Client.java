package com.yjr.build;

/**
 * @author yangjiuran
 * @Date 2020/7/12
 *
 * 个人理解：
 *      当需要建造一个东西的时候，可以将这个物品的建造拆分成若干个步骤，这些步骤通过一定的组合即可成为一个物品，
 *      这些步骤可以通过接口定义，让实现类自己实现，在通过一个指挥干活的人去定义按何种顺序去调用这些步骤即可
 */
public class Client {
    public static void main(String[] args) {
        HouseDericter commonDericter = new HouseDericter(new CommonHouseBuilder());
        House commonHouse = commonDericter.build();
        System.out.println(commonHouse);
        commonDericter.setHouseBuild(new GoldHouseBuilder());

        House goldHouse = commonDericter.build();
        System.out.println(goldHouse);

    }
}
