package com.gf.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中的配置，映射到这个组件中
 * @ConfigurationProperties: 告诉SpringBoot将本类所有属性和配置文件中相关的配置进行绑定
 *      prefix = "person" : 配置文件中那个下面的所有属性进行一一映射
 * 只有这个这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties的功能
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String , Object> map;
    private List<Object> list;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "{\"Person\":{" );
        sb.append( "\"lastName\":\"" )
                .append( lastName ).append( '\"' );
        sb.append( ",\"age\":" )
                .append( age );
        sb.append( ",\"boss\":" )
                .append( boss );
        sb.append( ",\"birth\":\"" )
                .append( birth ).append( '\"' );
        sb.append( ",\"map\":" )
                .append( map );
        sb.append( ",\"list\":" )
                .append( list );
        sb.append( ",\"dog\":" )
                .append( dog );
        sb.append( "}}" );
        return sb.toString();
    }
}
