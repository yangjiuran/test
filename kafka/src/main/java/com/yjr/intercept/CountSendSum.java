package com.yjr.intercept;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author yangjiuran
 * @Date 2020/6/18
 */
public class CountSendSum implements ProducerInterceptor<String,String > {
    private Long successSum=0L;
    private Long failSum=0L;
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if(e!=null){
            failSum=failSum+1;
        }else {
            successSum=successSum+1;
        }
    }

    @Override
    public void close() {
        System.out.println(failSum);
        System.out.println(successSum);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
