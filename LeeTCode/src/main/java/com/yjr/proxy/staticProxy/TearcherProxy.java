package com.yjr.proxy.staticProxy;

/**
 * @author yangjiuran
 * @Date 2020/7/31
 */
public class TearcherProxy implements ITearcherDao {
    private ITearcherDao iTearcherDao;

    public TearcherProxy(ITearcherDao iTearcherDao) {
        this.iTearcherDao = iTearcherDao;
    }

    @Override
    public void teach() {
        System.out.println("代理方法执行了~~~");
        iTearcherDao.teach();
        System.out.println("代理方法结束了~~~");
    }
}
