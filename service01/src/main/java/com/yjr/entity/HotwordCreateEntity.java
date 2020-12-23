package com.yjr.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yangjiuran
 * @Date 2020/6/18
 */
@Accessors(chain = true)
@Data
public class HotwordCreateEntity {
    @Excel(name = "字段名")
    private String name;
    @Excel(name = "字段名称")
    private String code;
    @Excel(name = "字段类型")
    private String type;
    @Excel(name = "项目用途")
    private String comment;
    @Excel(name = "表名")
    private String tableName;
    @Excel(name = "表编码")
    private String tableCode;

}
