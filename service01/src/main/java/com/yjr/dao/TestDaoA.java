package com.yjr.dao;

import com.yjr.entity.Dept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author yangjiuran
 * @Date 2019/10/30
 */
@Repository
public interface TestDaoA {
    @Select("select * from dept")
    List<Dept> selectAll();
}
