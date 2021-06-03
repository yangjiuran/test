/**
 * @author yangjiuran
 * @Date 2021/3/30
 */

import com.yjr.service.MyWebService;
import com.yjr.service.impl.MyWebserviceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @ClassName IssueService
 * @Description
 * @Author Administrator
 * @Date 2021/3/30 14:31
 * @Version 1.0
 */
public class IssueService {
    public static void main(String[] args) {
        // 服务工厂
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        // 设置服务地址
        factory.setAddress("http://localhost:8000/user");
        // 设置服务类
        factory.setServiceBean(new MyWebserviceImpl());
        // 发布服务
        factory.create();
        // 提示
        System.out.println("服务端启动");
    }
}
