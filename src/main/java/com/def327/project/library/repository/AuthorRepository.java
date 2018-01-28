package com.def327.project.library.repository;

import com.def327.project.library.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created def327 on 1/28/18.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, BigInteger> {
}
