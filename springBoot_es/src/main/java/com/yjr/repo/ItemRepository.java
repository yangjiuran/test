package com.yjr.repo;/**
 * @author yangjiuran
 * @Date 2021/5/7
 */

import com.yjr.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName ItemRepository
 * @Description
 * @Author Administrator
 * @Date 2021/5/7 16:57
 * @Version 1.0
 */
public interface ItemRepository extends ElasticsearchRepository<User,Long> {
}
