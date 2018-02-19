package com.library.demo.repository;

import com.library.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
