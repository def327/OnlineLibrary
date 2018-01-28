package com.def327.project.library.web.rest;

import com.def327.project.library.dao.AuthorDao;
import com.def327.project.library.domain.Author;
import com.def327.project.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created def327 on 1/28/18.
 */
@Controller
public class TestDaoRest {

    @Autowired
    private AuthorDao authorDao;

    @GetMapping("/authors/{id}")
    public ResponseEntity<String> getAuthor(@PathVariable(required = false) BigInteger id) {
        Author author = authorDao.get(id);
        String authorName = author.getName();
        Date birthday = author.getBirthday();
        List<Book> books = author.getBooks();
        return ResponseEntity.status(HttpStatus.OK).body(authorName);
    }
}