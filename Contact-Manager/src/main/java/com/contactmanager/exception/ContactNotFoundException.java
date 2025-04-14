package com.contactmanager.exception;

@SuppressWarnings("serial")
public class ContactNotFoundException extends RuntimeException{
	public ContactNotFoundException(Long id) {
        super("Contact with ID " + id + " not found.");
    }
}
