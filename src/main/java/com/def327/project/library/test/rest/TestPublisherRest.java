package com.def327.project.library.test.rest;

import com.def327.project.library.dao.entities.AbstractBase;
import com.def327.project.library.dao.entities.Publisher;
import com.def327.project.library.dao.repository.PublisherRepository;
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
public class TestPublisherRest implements RestTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/publishers/name/{name}")
    @Deprecated
    public ResponseEntity<String> getSearchPublisher(@PathVariable(required = false) String name) {
        List<Publisher> publishers = publisherRepository.findByNameContainingIgnoreCaseOrderByName(name);

        String searchAnswer = publishers.stream()
                .map(AbstractBase::toString)
                .collect(Collectors.toList())
                .toString();
        return ResponseEntity.status(HttpStatus.OK).body(searchAnswer);
    }
}