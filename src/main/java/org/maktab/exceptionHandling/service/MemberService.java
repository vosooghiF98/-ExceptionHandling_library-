package org.maktab.exceptionHandling.service;

import org.maktab.exceptionHandling.entities.Member;

import java.sql.SQLException;

public interface MemberService {

    void register(String firstName, String lastName, int libraryId) throws SQLException;
    void unRegister(String firstName, String lastName) throws SQLException;
    Member load(String firstName, String lastName) throws SQLException;
    void edit(Member member, String newFirstName, String newLastName) throws SQLException;





}
