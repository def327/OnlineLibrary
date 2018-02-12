package com.def327.project.library.dao.repository;

import com.def327.project.library.dao.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created def327 on 2/11/18.
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, BigInteger> {

    List<Publisher> findByNameContainingIgnoreCaseOrderByName(String fio);
}