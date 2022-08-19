package org.maktab.exceptionHandling;

import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.service.LibraryService;
import org.maktab.exceptionHandling.service.impl.LibraryServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        Library library =  new Library("baghketab" , 2);
        libraryServiceImpl.isFull(library);
    }
}