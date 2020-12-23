package com.yjr.service;

import com.yjr.dao.TestDaoA;
import com.yjr.entity.Dept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangjiuran
 * @Date 2019/10/30
 */
@Service

public class TestServceA {
    private TestDaoA testDaoA;
    public List<Dept> selectAll(){
        return testDaoA.selectAll();
    }
}
