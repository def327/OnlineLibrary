package com.def327.project.library.dao.repository;

import com.def327.project.library.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created def327 on 2/11/18.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, BigInteger> {

    List<Book> findByNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCaseOrderByName(String bookName, String authorName);


    @Query("SELECT book FROM Book book WHERE UPPER(book.name) LIKE UPPER(concat('%', :bookName , '%')) " +
            "OR UPPER(book.author.name) LIKE UPPER(concat('%', :bookName , '%'))")
    List<Book> findByBookNameOrAuthorNameContainingIgnoreCaseOrderByName(@Param("bookName") String bookName);
}