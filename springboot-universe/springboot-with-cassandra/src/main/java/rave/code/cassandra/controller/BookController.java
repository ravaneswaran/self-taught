package rave.code.cassandra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rave.code.cassandra.repository.BookRepository;
import rave.code.cassandra.request.BookRequest;
import rave.code.cassandra.table.Book;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> bookList = bookRepository.findAll();
        return ResponseEntity.status(200).body(bookList);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {

        Book book = new Book();
        book.setId(bookRequest.getId());
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setAuthor(bookRequest.getAuthor());
        book.setYear(bookRequest.getYear());
        book.setDateCreated(bookRequest.getDateCreated());

        book = bookRepository.save(book);
        return ResponseEntity.status(201).body(book);
    }
}
