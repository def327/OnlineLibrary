package com.def327.project.library.test.rest;

import com.def327.project.library.dao.entities.AbstractBase;
import com.def327.project.library.dao.entities.Genre;
import com.def327.project.library.dao.repository.GenreRepository;
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
@Controller
@Deprecated
public class TestGenreRest implements RestTest {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/genres/name/{name}")
    @Deprecated
    public ResponseEntity<String> getSearchGenre(@PathVariable(required = false) String name) {
        List<Genre> genres = genreRepository.findByNameContainingIgnoreCaseOrderByName(name);

        String searchAnswer = genres.stream()
                .map(AbstractBase::toString)
                .collect(Collectors.toList())
                .toString();

        return ResponseEntity.status(HttpStatus.OK).body(searchAnswer);
    }
}