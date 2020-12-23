package com.test.yjr.sys.mapper;

import com.test.yjr.sys.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yjr
 * @since 2019-10-20
 */
@Mapper
@Repository
public interface DeptMapper extends BaseMapper<Dept> {

}
