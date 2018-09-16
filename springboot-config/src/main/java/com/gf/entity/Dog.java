package com.gf.entity;


public class Dog {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "{\"Dog\":{" );
        sb.append( "\"name\":\"" )
                .append( name ).append( '\"' );
        sb.append( ",\"age\":" )
                .append( age );
        sb.append( "}}" );
        return sb.toString();
    }
}

