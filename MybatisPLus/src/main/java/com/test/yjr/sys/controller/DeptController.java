package com.test.yjr.sys.controller;


import com.test.yjr.sys.entity.Dept;
import com.test.yjr.sys.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yjr
 * @since 2019-10-20
 */
@RestController
@RequestMapping("/sys/dept")
public class DeptController {
    @Autowired
    private DeptMapper deptMapper;

        @RequestMapping("/selectList")
    public List<Dept> selectList(){
        return deptMapper.selectList(null);
    }
}
