package com.example.rest.book.repo;
import com.example.rest.book.entitybook.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
