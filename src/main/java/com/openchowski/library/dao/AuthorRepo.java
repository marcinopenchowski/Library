package com.openchowski.library.dao;

import com.openchowski.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
