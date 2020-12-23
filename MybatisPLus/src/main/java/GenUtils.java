

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2019/10/20
 */
public class GenUtils {

    private static String author = "xfb"; //作者名称
    private static String outputDir = "D:\\itcast\\test\\MybatisPLus\\src"; // 文件生成的位置
    private static String driver = "oracle.jdbc.driver.OracleDriver"; //驱动 注意版本
    private static String url = "jdbc:oracle:thin:@192.168.80.7:1521:orcl"; //数据库连接路径 ,
    private static String username = "scott"; // 数据库用户名
    private static String password = "tiger"; //数据库密码
    private static String tablePrefix = ""; //数据库表的前缀
    private static String[] tables = {"DEPT"}; //生成哪些表
    private static String parentPackage = "com.d2ssoft.www.pbocbasic.modules.sys"; //顶级包的结构
    private static String dao = "mapper"; //数据访问层包名称
    private static String service = "service"; //业务逻辑层包名称
    private static String entity = "entity"; //实体层包名称
    private static String controller = "controller"; //控制层包名称
    private static String mapperxml = "mapper"; //mapper映射文件包名称

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir(outputDir); //生成文件的输出目录
        gc.setAuthor(author); //开发人员
        gc.setFileOverride(true); //是否覆盖已有文件
        gc.setOpen(true); //是否打开输出目录
        gc.setIdType(IdType.AUTO) //主键生成策略
                .setServiceName("%sService") //设置生成的service接口的名称, %s为占位符, 例如User -> UserService
                .setBaseResultMap(true) // 映射文件中是否生成ResultMap 配置
                .setBaseColumnList(true); // 生成通用sql字段
//        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driver);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);


        // 数据库表策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel) //数据库表映射到实体类的命名策略
                .setTablePrefix(tablePrefix) // 表前缀
                .setEntityLombokModel(true) //是否为lombok模型
                .setEntityTableFieldAnnotationEnable(true) //生成实体类时是否生成注解
                .setRestControllerStyle(true) //生成@RestController 控制器
                .setControllerMappingHyphenStyle(true) //驼峰转连字符

                //继承公共父类 需要自己定义, mybatisPlus 并没有提供
//                .setSuperEntityClass("com.baomidou.ant.common.BaseEntity")
//                .setSuperControllerClass("com.baomidou.ant.common.BaseController")
                // 写于父类中的公共字段
//                .setSuperEntityColumns("id")


//                .setExclude();
                .setInclude(tables); //生成的表
        mpg.setStrategy(sc);


        // 包名策略配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage)
                .setMapper(dao)
                .setService(service)
                .setController(controller)
                .setEntity(entity);
//                .setXml(mapperxml);
        mpg.setPackageInfo(pc);


        //执行
        mpg.execute();


    }
}
