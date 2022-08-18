package org.maktab.exceptionHandling.repository;

import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.entities.Member;

import java.sql.SQLException;

public interface MemberRepository {
    void save(Member member) throws SQLException;
    Member load(Member member) throws SQLException;
    void edit(Member member, String newFirstName, String newLastName) throws SQLException;
    void remove(Member member) throws SQLException;
}
