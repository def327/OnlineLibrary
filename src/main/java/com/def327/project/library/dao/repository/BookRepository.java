package com.def327.project.library.dao.repository;

import com.def327.project.library.dao.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    List<Book> findByBookNameOrAuthorNameOrderByName(@Param("bookName") String bookName);

    //Show only id and image for top books
    @Query("SELECT NEW com.def327.project.library.dao.entities.Book(book.id, book.image) FROM Book book")
    List<Book> findTopBooks(Pageable pageable);

    //Show only book's content
    @Query("SELECT book.content FROM Book book WHERE book.id = :id")
    byte[] findBookContentById(@Param("id") BigInteger id);

//  -- With Pagination

    @Query("SELECT NEW com.def327.project.library.dao.entities.Book(book.id," +
            " book.name," +
            " book.pageCount," +
            " book.isbn," +
            " book.genre," +
            " book.author, " +
            " book.publisher," +
            " book.publishYear," +
            " book.image, " +
            " book.descr, " +
            " book.viewCount," +
            " book.totalRating," +
            " book.totalVoteCount," +
            " book.avgRating) " +
            "from Book book WHERE book.genre.id = :genreId")
    Page<Book> findBooksByGenreId(@Param("genreId") BigInteger genreId, Pageable pageable);

    //Show books without content
    @Query("SELECT NEW com.def327.project.library.dao.entities.Book(book.id," +
            " book.name," +
            " book.pageCount," +
            " book.isbn," +
            " book.genre," +
            " book.author, " +
            " book.publisher," +
            " book.publishYear," +
            " book.image, " +
            " book.descr, " +
            " book.viewCount," +
            " book.totalRating," +
            " book.totalVoteCount," +
            " book.avgRating) " +
            "from Book book")
    Page<Book> findAllWithoutContent(Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Book book SET book.content=:content WHERE book.id =:id")
    void updateContent(@Param("id") BigInteger id, @Param("content") byte[] content);
}