package org.maktab.exceptionHandling.entities;

public class Library {
	private int id;
	private String name;
	private int capacity;
	private int countMember;

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

	public int getCountMember() {
		return countMember;
	}

	public void setCountMember(int countMember) {
		this.countMember = countMember;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
