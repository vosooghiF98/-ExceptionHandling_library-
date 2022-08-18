package org.maktab.exceptionHandling.service.impl;

import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.repository.LibraryRepository;
import org.maktab.exceptionHandling.repository.impl.LibraryRepositoryImpl;
import org.maktab.exceptionHandling.service.LibraryService;

import java.sql.SQLException;

public class LibraryServiceImpl implements LibraryService {
    LibraryRepository libraryRepository = new LibraryRepositoryImpl();
    @Override
    public void save(Library library) throws SQLException {

    }

    @Override
    public Library load(Library library) throws SQLException {
        return null;
    }
    @Override
    public Library loadById(int id) throws SQLException {
        return null;
    }

    @Override
    public void edit(Library library, String name, int capacity) throws SQLException {

    }

    @Override
    public void delete(Library library) throws SQLException {

    }

    @Override
    public int getMemberCount(String firstName, String lastName) throws SQLException {
        return 0;
    }

    @Override
    public boolean isFull(Library library) throws SQLException {
        return libraryRepository.memberCount(library) == library.getCapacity();
    }
}
