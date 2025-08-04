package rave.code.camel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rave.code.camel.entity.Book;
import rave.code.camel.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
