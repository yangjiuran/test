package com.yjr.config;/**
 * @author yangjiuran
 * @Date 2021/5/8
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.config.AbstractReactiveElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

/**
 * @ClassName RepoConfig
 * @Description
 * @Author Administrator
 * @Date 2021/5/8 10:25
 * @Version 1.0
 */
//@Configuration
//@EnableReactiveElasticsearchRepositories
public class  RepoConfig extends AbstractReactiveElasticsearchConfiguration {
    @Override
    public ReactiveElasticsearchClient reactiveElasticsearchClient() {
        return ReactiveRestClients.create(ClientConfiguration.create("192.168.174.22:9300"));
    }
}
