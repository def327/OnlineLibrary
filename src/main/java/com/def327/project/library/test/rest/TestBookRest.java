package com.def327.project.library.test.rest;

import com.def327.project.library.dao.entities.AbstractBase;
import com.def327.project.library.dao.entities.Book;
import com.def327.project.library.dao.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created def327 on 2/11/18.
 */
@Deprecated
@Controller
public class TestBookRest implements RestTest {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books/name/{name}")
    @Deprecated
    public ResponseEntity<String> getSearchBooks(@PathVariable(required = false) String name) {
        List<Book> books = bookRepository
                .findByNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCaseOrderByName(name, name);

        String searchAnswer = books.stream()
                .map(AbstractBase::toString)
                .collect(Collectors.toList())
                .toString();
        return ResponseEntity.status(HttpStatus.OK).body(searchAnswer);
    }
}