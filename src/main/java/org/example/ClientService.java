package org.example;

import org.example.config.Database;
import org.example.dto.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private Database database;

    public ClientService(Database database) {
        this.database = database;
    }

    public long create(String name) {
        if (name == null || name.isEmpty() || name.length() <= 2 || name.length() >= 1000) {
            throw new IllegalArgumentException("Invalid name");
        }
        Connection connection = database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO client (name) VALUES (?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating client failed");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public String getById(long id) {
        Connection connection = database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("SELECT name FROM client WHERE id = ?")) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                } else {
                    throw new IllegalArgumentException("Client with id " + id + " not found");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setName(long id, String name) {
        Connection connection = database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?")) {
            statement.setString(1, name);
            statement.setLong(2, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0){
                throw new IllegalArgumentException("Client with id " + id + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) {
        Connection connection = database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM client WHERE id = ?")) {
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0){
                throw new IllegalArgumentException("Client with id " + id + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Client> listAll(){
        List<Client> clients = new ArrayList<>();
        Connection connection = database.getConnection();
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM client");
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                clients.add(new Client(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }
}
