package com.def327.project.library.dao.service.impl;

import com.def327.project.library.dao.service.AuthorService;
import com.def327.project.library.dao.entities.Author;
import com.def327.project.library.dao.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created def327 on 1/28/18.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(BigInteger id) {
        return authorRepository.getOne(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public List<Author> search(String... searchString) {
        //TODO add util class for separation
//        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString);
        return null;
    }
}