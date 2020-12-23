package com.yjr.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yangjiuran
 * @Date 2020/5/12
 */
@ExcelTarget("teacherEntity")
@Data
@Accessors(chain = true)
public class TeacherEntity {
    private String id;
    /** name */
    @Excel(name = "主讲老师_major,代课老师_absent", orderNum = "1", isImportField = "true_major,true_absent" ,needMerge = true)
    private String name;
}

