package com.yjr.pojo;/**
 * @author yangjiuran
 * @Date 2021/5/7
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName MyIndex
 * @Description
 * @Author Administrator
 * @Date 2021/5/7 16:15
 * @Version 1.0
 */
@Document(indexName = "my_index")
public class User {
    private String name;
    private String age;
    private String tags;
    private String org;

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", tags='" + tags + '\'' + ", org='" + org + '\'' + ", id='" + id + '\'' + ", properties='" + properties + '\'' + '}';
    }

    @Id
    private String id;
    private String properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

}
