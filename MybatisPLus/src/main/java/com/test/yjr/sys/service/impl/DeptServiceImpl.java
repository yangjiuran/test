package com.test.yjr.sys.service.impl;

import com.test.yjr.sys.entity.Dept;
import com.test.yjr.sys.mapper.DeptMapper;
import com.test.yjr.sys.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yjr
 * @since 2019-10-20
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Autowired
    private  DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.selectList(null);
    }
}
