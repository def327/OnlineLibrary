package com.def327.project.library.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigInteger;


@Entity
@Table(catalog = "library")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
@NoArgsConstructor
public class Book extends AbstractBase{

    //Without content
    public Book(BigInteger id,
                String name,
                Integer pageCount,
                String isbn,
                Genre genre,
                Author author,
                Publisher publisher,
                Integer publishYear,
                byte[] image,
                String descr,
                BigInteger viewCount,
                BigInteger totalRating,
                BigInteger totalVoteCount,
                int avgRating) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
        this.viewCount = viewCount;
        this.totalRating = totalRating;
        this.totalVoteCount = totalVoteCount;
        this.avgRating = avgRating;
    }

    //Only with image
    public Book(BigInteger id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    @Lob
    @Column(updatable = false)
    private byte[] content;

    @Column(name = "page_count")
    private Integer pageCount;

    private String isbn;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;


    @Column(name = "publish_year")
    private Integer publishYear;

    private byte[] image;

    private String descr;

    @Column(name = "view_count")
    private BigInteger viewCount;

    @Column(name = "total_rating")
    private BigInteger totalRating;

    @Column(name = "total_vote_count")
    private BigInteger totalVoteCount;

    @Column(name = "avg_rating")
    private int avgRating;
}