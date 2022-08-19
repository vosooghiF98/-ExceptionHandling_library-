package org.maktab.exceptionHandling.repository;

import org.maktab.exceptionHandling.base.BaseRepository;
import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.entities.Member;

import java.sql.SQLException;

public interface LibraryRepository extends BaseRepository<Library> {

    Library loadById(int id) throws SQLException;
    int memberCount(Library library) throws SQLException;
}
