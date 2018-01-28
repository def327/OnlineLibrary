package com.def327.project.library.dao.impl;

import com.def327.project.library.dao.AuthorDao;
import com.def327.project.library.domain.Author;
import com.def327.project.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created def327 on 1/28/18.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

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
        return null;
    }
}