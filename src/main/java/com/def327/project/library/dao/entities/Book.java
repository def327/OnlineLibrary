package com.def327.project.library.dao.entities;

import lombok.Getter;
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
public class Book extends AbstractBase{

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