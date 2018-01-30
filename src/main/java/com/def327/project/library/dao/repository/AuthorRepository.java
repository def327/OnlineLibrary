package com.def327.project.library.dao.repository;

import com.def327.project.library.dao.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created def327 on 1/28/18.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, BigInteger> {

    List<Author> findByFioContainingIgnoreCaseOrderByFio(String fio);
}
