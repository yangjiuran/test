/**
 * @author yangjiuran
 * @Date 2021/5/7
 */

import cn.hutool.core.util.ZipUtil;
import com.yjr.Application;
import com.yjr.pojo.Book;
import com.yjr.pojo.User;
import com.yjr.repo.BookRepository;
import com.yjr.repo.ItemRepository;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName TestCollect
 * @Description
 * @Author Administrator
 * @Date 2021/5/7 16:07
 * @Version 1.0
 */
@SpringBootTest(classes = Application.class )
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCollect {
    /*@Autowired
     private ElasticsearchTemplate template;*/

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    RestHighLevelClient highLevelClient;
    @Test
    public void test() throws IOException {
        SearchRequest request = new SearchRequest("my_index");

        SearchResponse search = highLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        for (int i = 0; i < hits.length; i++) {
            System.out.println(hits[i].getFields());
        }
        System.out.println();
    }
    @Test
    public void test2() throws IOException {
        Iterable<User> all = itemRepository.findAll();
        Iterator<User> iterator = all.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test3() throws IOException {
        Book book = new Book();
        book.setName("冰与火之歌");
        book.setWriter("乔治·R·R·马丁");
        book.setBrief("主要描述了在一片虚构的中世纪世界里所发生的一系列宫廷斗争、疆场厮杀、游历冒险和魔法抗衡的故事。在内容及风格上，《冰与火之歌》是现实生活的一面镜子，人性真实的写照。写作手法上马丁运用了POV（Point-of-View，即“视点人物写作手法”），以轮流交换人物第三人称视点的叙事方式进行描写，从而推动故事的进展。");
        book.setPrice(420.5);
        book.setProduceDate(new Date());
        bookRepository.save(book);
    }
    @Test
    public void test4() throws IOException {
        List<Book> list = bookRepository.findByBriefLike("中世纪");
        System.out.println(list.size());
    }
    @Test
    public void test5() throws IOException {
        String date = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
        System.out.println(date);
    }  @Test
    public void test7() throws IOException {
        String fileName="202104/RADAR_202104302048_0.real.png";
        if(StringUtils.isEmpty(fileName)){
            return ;
        }
        String[] split = fileName.split("/");
        String png_name="";
        if(split.length>1){
            png_name=split[1];
        }else {
            png_name=split[0];
        }
        String[] txt_names = png_name.split("\\.");
        String txt_name ="";
        if(txt_names.length==3){
               txt_name=txt_names[0];
        }
        txt_name=txt_name+".txt";

        System.out.println(txt_name);
    }

    @Test
    public void t8() {
        String[] s = "RADAR_202103312224_0".split("_");
        String[] img = "202104/RADAR_202103150748_0".split("_");
        String dicPath="D:\\leidatu\\tmp\\txt";
        String picPath="D:\\leidatu\\tmp\\pic";
        if(s.length==3){
            for (int i = 0; i <= 10; i++) {
                String file1=s[0]+"_"+s[1]+"_"+i+".txt";

                try {
                    FileUtils.copyFileToDirectory(new File("D:\\FTP\\leida\\"+file1),new File(dicPath),true);
                } catch (IOException e) {
                    System.out.println("文件找不到");
                    continue;
                }
            }
        }
        if(img.length==3){
            for (int i = 0; i <= 10; i++) {
                String file1=s[0]+"_"+s[1]+"_"+i+".real.png";
                try {
                    FileUtils.copyFileToDirectory(new File("D:\\leidatu\\images\\"+file1),new File(picPath),true);
                } catch (IOException e) {
                    System.out.println("文件找不到");
                    continue;
                }
            }
        }
        File zip = ZipUtil.zip("D:\\leidatu\\tmp","D:\\FTP\\tmp.zip",true);
    }
    @Test
    public void test6() throws IOException {
        List<Person> list = new ArrayList<Person>();
        Person user = new Person();
        user.setAge(12);
        user.setName("张三");
        list.add(user);
        Person user1 = new Person();
        user1.setAge(14);
        user1.setName("李四");
        list.add(user1);
        Person user2 = new Person();
        user2.setAge(16);
        user2.setName("王五");
        list.add(user2);
        Map<Integer, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(collect);
    }
    class Person{
        Integer age;
        String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

    }


