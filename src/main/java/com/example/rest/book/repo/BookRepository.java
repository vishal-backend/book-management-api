package com.example.rest.book.repo;
import com.example.rest.book.entitybook.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByAuthor_AuthorId(int authorId);

}
