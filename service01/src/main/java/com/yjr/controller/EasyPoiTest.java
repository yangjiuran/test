package com.yjr.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.yjr.config.MyIExcelExportStyler;
import com.yjr.entity.CourseEntity;
import com.yjr.entity.StudentEntity;
import com.yjr.entity.TeacherEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author yangjiuran
 * @Date 2020/5/12
 */
@RestController
public class EasyPoiTest {
    @RequestMapping("/t1")
    public void t1(HttpServletResponse response) throws IOException {
        OutputStream outputStream = null;
        List<CourseEntity> courseEntities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName("course"+i);
            ArrayList<StudentEntity> studentEntities = new ArrayList<>();
            StudentEntity s1 = new StudentEntity();
            StudentEntity s2 = new StudentEntity();
            s1.setName("KKK"+i).setId(i+"").setSex(1);
            s2.setName("yyy"+i).setId(i+"").setSex(2);
            studentEntities.add(s1);
            studentEntities.add(s2);
            courseEntity.setStudents(studentEntities);
            TeacherEntity teacherMajor = new TeacherEntity();
            teacherMajor.setId(i+"");
            teacherMajor.setName("teacherMajor"+i);
            TeacherEntity teacherAbset = new TeacherEntity();
            teacherAbset.setId(i+"");
            teacherAbset.setName("teacherAbset"+i);
            courseEntity.setMajorTeacher(teacherAbset);
            courseEntity.setMathTeacher(teacherAbset);
            courseEntities.add(courseEntity);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                CourseEntity.class, courseEntities);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("t1.xls", "UTF-8"));
        outputStream = response.getOutputStream();

        workbook.write(outputStream);
    }
    @RequestMapping("/t2")
    public void t2(HttpServletResponse response) throws Exception {
        OutputStream outputStream = null;
        String absolutePath = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "t2_model.xls").getAbsolutePath();
        System.out.println(absolutePath);
        TemplateExportParams params = new TemplateExportParams(absolutePath);
        Map<Integer, List<Map<String, Object>>> realMap = new HashMap<>();
        List<Map<String, Object>> listmap_one = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> listmap_two = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> data_list_one = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> data_list_two = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> data1 = new HashMap<>();
        HashMap<String, Object> data2 = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> dateMap = new HashMap<>();
            dateMap.put("l1","yjr"+i);
            dateMap.put("id",i+1+"");
            dateMap.put("l2","kkk"+i);

            Map<String, Object> obj = new HashMap<>();
            obj.put("l1","sheet2"+i);
            obj.put("id",i+1+"");
            obj.put("l2","sheet2"+i);

            listmap_one.add(dateMap);
            listmap_two.add(obj);
        }
        data1.put("list",listmap_one);
        data1.put(ExcelExportUtil.SHEET_NAME,"map1");
        data2.put("list",listmap_two);
        data2.put(ExcelExportUtil.SHEET_NAME,"map2");
        data_list_one.add(data1);
        data_list_two.add(data2);

        realMap.put(0,data_list_one);
        realMap.put(1,data_list_two);

        Workbook workbook = ExcelExportUtil.exportExcelClone(realMap,params);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("t1.xls", "UTF-8"));
        outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }
    @RequestMapping("/t3")
    public void t3(HttpServletResponse response) throws Exception {
        OutputStream outputStream = null;
        TemplateExportParams params = new TemplateExportParams("D:/itcast/test/service01/src/main/resources/"+ "t3_model.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date",new Date());
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("t1.xls", "UTF-8"));
        outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }

}
