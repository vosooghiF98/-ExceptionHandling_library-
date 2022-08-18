package org.maktab.exceptionHandling.entities;

import org.maktab.exceptionHandling.IdGenerator;
import org.maktab.exceptionHandling.exceptions.LibraryFullException;

public class Library {

	private Member[] members;
	private final int capacity;
	private IdGenerator idGenerator;

	public Library(int capacity, IdGenerator idGenerator) {
		this.capacity = capacity;
		this.members = new Member[capacity];
		this.idGenerator = idGenerator;
	}

	public void register(Member member) throws LibraryFullException {
		// TODO implement
	}
	
	public Member unregister(int id) {
		// TODO implement
		return null;
	}

	public int getMemberCount() {
		// TODO implement
		return 0;
	}
	
	public boolean isFull() {
		// TODO implement
		return false;
	}
	
	public Member[] getMembers() {
		return members;
	}

	public int getCapacity() {
		return capacity;
	}

}
