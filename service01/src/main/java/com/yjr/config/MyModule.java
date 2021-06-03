package com.yjr.config;/**
 * @author yangjiuran
 * @Date 2021/4/6
 */

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.core.Module;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName MyModule
 * @Description
 * @Author Administrator
 * @Date 2021/4/6 17:12
 * @Version 1.0
 */
@DimModule
@Component()
public class MyModule implements SpringModule {


    @Autowired
    private DataSource dataSource = null;

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
    }

}
