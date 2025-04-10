package com.library.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException{
	public BookNotFoundException(Long id){
        super("Book with ID " + id + " not found.");
    }

}
