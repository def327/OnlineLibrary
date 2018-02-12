package com.def327.project.library.dao.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created def327 on 1/28/18.
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(of = "id")
public abstract class AbstractBase implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected BigInteger id;

    protected String name;

    @Override
    public String toString() {
        return name;
    }
}