package org.maktab.exceptionHandling.repository;

import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.entities.Member;

import java.sql.SQLException;

public interface LibraryRepository {

    void save(Library library) throws SQLException;

    Library load(Library library)throws SQLException;

    Library loadById(int id) throws SQLException;

    void edit(Library library , String name , int capacity)throws SQLException;

    void delete(Library library)throws SQLException;

    int memberCount(Library library) throws SQLException;
}
