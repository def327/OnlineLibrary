package com.def327.project.library.test.rest;

import com.def327.project.library.api.service.data.AuthorService;
import com.def327.project.library.dao.entities.AbstractBase;
import com.def327.project.library.dao.entities.Author;
import com.def327.project.library.dao.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created def327 on 1/28/18.
 */
@Controller
@Deprecated
public class TestAuthorRest implements RestTest {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors/{id}")
    @Deprecated
    public ResponseEntity<String> getAuthor(@PathVariable(required = false) BigInteger id) {
        Author author = authorService.get(id);
        String authorName = author.getName();
        Date birthday = author.getBirthday();
        List<Book> books = author.getBooks();
        return ResponseEntity.status(HttpStatus.OK).body(authorName);
    }

    @GetMapping("/authors/fio/{fio}")
    @Deprecated
    public ResponseEntity<String> getSearchAuthor(@PathVariable(required = false) String fio) {
        String[] array = new String[]{fio};
        List<Author> authors = authorService.search(array);
        String searchAnswer = authors.stream()
                .map(AbstractBase::toString)
                .collect(Collectors.toList())
                .toString();
        return ResponseEntity.status(HttpStatus.OK).body(searchAnswer);
    }
}