package org.maktab.exceptionHandling.repository.impl;

import org.maktab.exceptionHandling.config.DBConfig;
import org.maktab.exceptionHandling.entities.Library;
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
                Library library1 = new Library(resultSet.getString("name"), resultSet.getInt("capacity"));
                library1.setId(resultSet.getInt("id"));
                return library1;
            } else {
                return null;
            }
        }
    }



    @Override
    public Library loadById(int id) throws SQLException {
        String query = "select * from library where id = ?";
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Library library = new Library(resultSet.getString("name"), resultSet.getInt("capacity"));
                library.setId(resultSet.getInt("id"));
                return library;
            } else {
                return null;
            }
        }
    }

    @Override
    public void edit(Library library) throws SQLException {
        String query = "update library set name = ? , capacity= ? where id = ?";
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, library.getName());
            preparedStatement.setInt(2, library.getCapacity());
            preparedStatement.setInt(3, library.getId());
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
    public int memberCount(Library library) throws SQLException {
        String query = """
                select count(*) from member m inner join library l on l.id = m.library_id where l.id = ?
                                """;
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, library.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return resultSet.getInt(1);
            } else {
                return 0;
            }
        }
    }


}
