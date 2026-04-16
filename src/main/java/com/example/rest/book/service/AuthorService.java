package com.example.rest.book.service;
import com.example.rest.book.repo.AuthorRepository;
import com.example.rest.book.entitybook.Author;
import com.example.rest.book.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id){
        return authorRepository.findById(id).orElseThrow(()->new ResourceNotFound("Author not found: "+id));
    }

    public Author addAuthor(Author author){
       Author result=authorRepository.save(author);
       return result;
    }

    public void deleteById(int id){
       Author author= authorRepository.findById(id).orElseThrow(()->new ResourceNotFound("Author not found: "+id));
       authorRepository.delete(author);
    }

    public Author updateAuthor(Author author,int id){
          Author existing=authorRepository.findById(id).orElseThrow(()->new ResourceNotFound("Author not found:"+id));

          existing.setFirstName(author.getFirstName());
          existing.setLastName(author.getLastName());
          existing.setBio(author.getBio());
          existing.setEmail(author.getEmail());
          return authorRepository.save(existing);
      }
}
