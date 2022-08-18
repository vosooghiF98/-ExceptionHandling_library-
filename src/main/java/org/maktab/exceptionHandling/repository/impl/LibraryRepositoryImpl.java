package org.maktab.exceptionHandling.repository.impl;

import org.maktab.exceptionHandling.config.DBConfig;
import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.entities.Member;
import org.maktab.exceptionHandling.repository.LibraryRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryRepositoryImpl implements LibraryRepository {
    @Override
    public void save(Library library) throws SQLException {
        String query = "insert into library (name, capacity) values (?,?)";
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, library.getName());
            preparedStatement.setInt(2, library.getCapacity());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public Library load(Library library) throws SQLException {

        String query = "select * from library where name = ? and capacity = ?";
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, library.getName());
            preparedStatement.setInt(2, library.getCapacity());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Library(resultSet.getString("name"), resultSet.getInt("capacity"));
            } else {
                return null;
            }
        }
    }

    @Override
    public void edit(Library library, String name, int capacity) throws SQLException {
        String query = "update library set name = ? , capacity= ? where name = ? and capacity = ?";
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, capacity);
            preparedStatement.setString(3, library.getName());
            preparedStatement.setInt(4, library.getCapacity());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Library library) throws SQLException {
        String query = "delete from library where name = ? and capacity = ?";
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, library.getName());
            preparedStatement.setInt(2, library.getCapacity());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public int memberCount(Member member) throws SQLException {
        String query = """
                select count(*) from member where library_id = ?
                                """;
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, member.getLibraryId());
            ResultSet resultSet = preparedStatement.executeQuery();
            int counter;
            if (resultSet.next()) {
                counter = resultSet.getInt(1);
                return counter;
            } else {
                return 0;
            }
        }
    }
}
