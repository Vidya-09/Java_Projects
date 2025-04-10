package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.exception.BookNotFoundException;
import com.library.model.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book book = getBook(id);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());
        book.setAvailable(updatedBook.isAvailable());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> filterByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> filterByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> filterByAvailability(boolean available) {
        return bookRepository.findByAvailable(available);
    }
}
