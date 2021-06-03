package com.yjr.config;/**
 * @author yangjiuran
 * @Date 2021/5/8
 */

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @ClassName RestClientConfig
 * @Description
 * @Author Administrator
 * @Date 2021/5/8 10:31
 * @Version 1.0
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("192.168.174.22:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
