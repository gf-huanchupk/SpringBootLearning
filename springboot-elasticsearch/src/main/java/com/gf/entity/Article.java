package com.gf.entity;


import io.searchbox.annotations.JestId;

public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "{\"Article\":{" );
        sb.append( "\"id\":" )
                .append( id );
        sb.append( ",\"author\":\"" )
                .append( author ).append( '\"' );
        sb.append( ",\"title\":\"" )
                .append( title ).append( '\"' );
        sb.append( ",\"content\":\"" )
                .append( content ).append( '\"' );
        sb.append( "}}" );
        return sb.toString();
    }


}
