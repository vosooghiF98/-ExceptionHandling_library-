package org.maktab.exceptionHandling.entities;

import org.maktab.exceptionHandling.IdGenerator;
import org.maktab.exceptionHandling.exceptions.LibraryFullException;

public class Library {

	private String name;
	private final int capacity;


	public Library(String name ,int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getCapacity() {
		return capacity;
	}

}
