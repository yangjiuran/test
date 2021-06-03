package com.yjr.pojo;/**
 * @author yangjiuran
 * @Date 2021/5/8
 */

import org.apache.lucene.analysis.Analyzer;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Boot
 * @Description
 * @Author Administrator
 * @Date 2021/5/8 13:50
 * @Version 1.0
 */
@Document(indexName = "books",createIndex = true,replicas =1 ,shards = 3)

public class Book {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String brief;
    @Field(type = FieldType.Double)
    private double price;
    @Field(type = FieldType.Date,format = DateFormat.basic_date)
    private Date produceDate;
    @Field(type = FieldType.Text)
    private String writer;

    @Override
    public String toString() {
        return "Boot{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", brief='" + brief + '\'' + ", price=" + price + ", produceDate=" + produceDate + ", writer='" + writer + '\'' + '}';
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
