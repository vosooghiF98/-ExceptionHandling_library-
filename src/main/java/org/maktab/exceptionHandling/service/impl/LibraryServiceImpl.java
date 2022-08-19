package org.maktab.exceptionHandling.service.impl;

import org.maktab.exceptionHandling.base.BaseService;
import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.exceptions.LibraryFullException;
import org.maktab.exceptionHandling.repository.LibraryRepository;
import org.maktab.exceptionHandling.repository.impl.LibraryRepositoryImpl;
import org.maktab.exceptionHandling.service.LibraryService;

import java.sql.SQLException;

public class LibraryServiceImpl extends LibraryService {


    public LibraryServiceImpl(){
        setBaseRepository(new LibraryRepositoryImpl());
    }

    public LibraryRepositoryImpl getLibraryRepositoryImpl(){
        return (LibraryRepositoryImpl) super.getBaseRepository();
    }

    @Override
    protected Library loadById(int id) throws SQLException {
        return null;
    }

    private int getMemberCount(Library library) throws SQLException {
      return getLibraryRepositoryImpl().memberCount(library);
    }

    @Override
    public void isFull(Library library) throws SQLException {
        if(getMemberCount(library) == library.getCapacity()){
            throw new LibraryFullException(library.getName() + " is full");
        }
    }
}
