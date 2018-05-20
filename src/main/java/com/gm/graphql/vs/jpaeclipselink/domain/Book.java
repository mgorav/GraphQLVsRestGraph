package com.gm.graphql.vs.jpaeclipselink.domain;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 3846860290787219870L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Basic
    private String title;
    @Basic
    private String isbn;
    @Basic
    private int pageCount;
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String title, String isbn, int pageCount, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
}
