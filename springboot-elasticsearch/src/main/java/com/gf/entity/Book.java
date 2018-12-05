package com.gf.entity;

import org.springframework.data.elasticsearch.annotations.Document;

@Document( indexName = "gf" , type = "book")
public class Book {
    private Integer id;
    private String bookName;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "{\"Book\":{" );
        sb.append( "\"id\":" )
                .append( id );
        sb.append( ",\"bookName\":\"" )
                .append( bookName ).append( '\"' );
        sb.append( ",\"author\":\"" )
                .append( author ).append( '\"' );
        sb.append( "}}" );
        return sb.toString();
    }

}
