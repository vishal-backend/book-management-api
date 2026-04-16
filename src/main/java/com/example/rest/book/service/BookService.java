package com.example.rest.book.service;
import com.example.rest.book.repo.AuthorRepository;
import com.example.rest.book.entitybook.Author;
import com.example.rest.book.entitybook.Book;
import com.example.rest.book.repo.BookRepository;
import com.example.rest.book.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
       return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(()->new ResourceNotFound("Book not found: "+id));
    }


    public Book addBook(Book book,int author_id) {
        Author author = authorRepository.findById(author_id).orElseThrow(()->new ResourceNotFound("Author not found: "+author_id));
            book.setAuthor(author);
        return bookRepository.save(book);
    }

    public void deleteBook ( int bid){
        Book book=bookRepository.findById(bid).orElseThrow(()->new ResourceNotFound("Book not found: "+bid));
            bookRepository.delete(book);
    }

    public Book updateBook (Book book,int bid) {
            Book existing = bookRepository.findById(bid).orElseThrow(()->new ResourceNotFound("Book not found:" +bid));
            existing.setTitle(book.getTitle());
            existing.setDescription(book.getDescription());
            existing.setPrice(book.getPrice());
            existing.setPublishedDate(book.getPublishedDate());
            existing.setIsbn(book.getIsbn());

            if (book.getAuthor() != null) {
                Author author = authorRepository.findById(book.getAuthor().getAuthorId()).
                        orElseThrow(() -> new ResourceNotFound("Author not found"));
                existing.setAuthor(author);
            }
                return bookRepository.save(existing);
    }

    public List<Book> getBookByAuthorId(int authorId){
        authorRepository.findById(authorId)
                .orElseThrow(()->new ResourceNotFound("Author not found: "+authorId));
        return bookRepository.findByAuthor_AuthorId(authorId);
    }


}

