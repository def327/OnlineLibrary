package com.def327.project.library.dao.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "fio"))
})
@Table(catalog = "library")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
public class Author extends AbstractBase {

    private Date birthday;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}