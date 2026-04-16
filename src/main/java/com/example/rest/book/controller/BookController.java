package com.example.rest.book.controller;
import com.example.rest.book.entitybook.Book;
import com.example.rest.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookservice;

     @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
          return  ResponseEntity.ok(bookservice.getAllBooks());
     }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
      return ResponseEntity.ok(bookservice.getBookById(id));
    }

    @GetMapping("/author/{author_Id}")
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable int author_Id){
         return ResponseEntity.ok(bookservice.getBookByAuthorId(author_Id));
    }

    @PostMapping("/{author_id}")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book, @PathVariable int author_id){
                     Book books= this.bookservice.addBook(book,author_id);
             return ResponseEntity.status(HttpStatus.CREATED).body(books);
     }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable ("id") int id){
             this.bookservice.deleteBook(id);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book books,@PathVariable("id") int id) {
         Book updateBooks=bookservice.updateBook(books,id);
         return ResponseEntity.ok(updateBooks);
    }
}