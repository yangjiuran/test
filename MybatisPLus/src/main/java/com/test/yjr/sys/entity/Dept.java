package com.test.yjr.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjr
 * @since 2019-10-20
 */
@TableName("DEPT")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("DEPTNO")
    private Integer deptno;

    @TableField("DNAME")
    private String dname;

    @TableField("LOC")
    private String loc;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
            "deptno=" + deptno +
            ", dname=" + dname +
            ", loc=" + loc +
        "}";
    }
}
