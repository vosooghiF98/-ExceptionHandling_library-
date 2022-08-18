package org.maktab.exceptionHandling.service;

import org.maktab.exceptionHandling.entities.Library;

import java.sql.SQLException;

public interface LibraryService {

    void save(Library library) throws SQLException;

    Library load(Library library)throws SQLException;

    Library loadById(int id) throws SQLException;

    void edit(Library library , String name , int capacity)throws SQLException;

    void delete(Library library)throws SQLException;

    int getMemberCount(String firstName, String lastName) throws SQLException;

    boolean isFull(Library library)throws SQLException;

}
