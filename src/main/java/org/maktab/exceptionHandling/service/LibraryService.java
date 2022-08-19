package org.maktab.exceptionHandling.service;

import org.maktab.exceptionHandling.base.BaseService;
import org.maktab.exceptionHandling.entities.Library;

import java.sql.SQLException;

public abstract class LibraryService extends BaseService<Library> {

    protected abstract Library loadById(int id) throws SQLException;

    protected abstract void isFull(Library library) throws SQLException;

}
