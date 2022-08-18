package org.maktab.exceptionHandling.repository.impl;

import org.maktab.exceptionHandling.config.DBConfig;
import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.entities.Member;
import org.maktab.exceptionHandling.repository.MemberRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepositoryImpl implements MemberRepository {
    @Override
    public void save(Member member) throws SQLException {
        String query = """
                insert into member (first_name, last_name, library_id) 
                values (?,?,?)
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.setInt(3,member.getLibraryId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Member load(Member member) throws SQLException {
        String query = """
                select * from member where first_name = ? and last_name = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Member(resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getInt("library_id"));
            }else {
                return null;
            }
        }
    }

    @Override
    public void edit(Member member, String newFirstName, String newLastName) throws SQLException {
        String query = """
                update member set first_name = ? , last_name = ? where first_name = ? and last_name = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1,newFirstName);
            preparedStatement.setString(2,newLastName);
            preparedStatement.setString(3, member.getFirstName());
            preparedStatement.setString(4, member.getLastName());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void remove(Member member) throws SQLException {
        String query = """
                delete from member where first_name = ? and last_name = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.executeUpdate();
        }
    }
}
