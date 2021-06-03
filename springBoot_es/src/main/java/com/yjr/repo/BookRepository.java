package com.yjr.repo;/**
 * @author yangjiuran
 * @Date 2021/5/8
 */

import com.yjr.pojo.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * @ClassName BookRepository
 * @Description
 * @Author Administrator
 * @Date 2021/5/8 14:07
 * @Version 1.0
 */
public interface BookRepository extends ElasticsearchRepository<Book,Long> {
    List<Book> findByBriefLike(String name);
}
