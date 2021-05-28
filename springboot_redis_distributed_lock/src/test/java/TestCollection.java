/**
 * @author yangjiuran
 * @Date 2021/5/27
 */

import com.yjr.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;

/**
 * @ClassName TestCollection
 * @Description
 * @Author Administrator
 * @Date 2021/5/27 16:14
 * @Version 1.0
 */
@SpringBootTest(classes = Application.class )
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCollection {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void t1(){
        redisTemplate.opsForValue().set("name","yjr");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    class User implements Serializable{
        private static final long serialVersionUID = 5237730257103305078L;
        String name;
        Integer age;

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
}
