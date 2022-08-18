package org.maktab.exceptionHandling.entities;

public class Member {

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer libraryId;
	
	public Member() {
	}

	public Member(String firstName, String lastName, Integer libraryId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.libraryId = libraryId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getLibraryId() {
		return libraryId;
	}
}
