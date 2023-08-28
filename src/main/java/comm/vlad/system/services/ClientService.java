package comm.vlad.system.services;

import comm.vlad.system.configs.DataBaseConnectivity;
import comm.vlad.system.domain.Client;

import java.sql.*;

public class ClientService {
    public static void save(Client client) {
        try (Connection connection = DataBaseConnectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients (client_id, name, surname) VALUES (?,?,?)")) {
            preparedStatement.setInt(1, getNextId(connection));
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getSurname());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getNextId(Connection connection) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT max(client_id) + 1 FROM clients")) {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getClientId(String name, String surname) {
        try (Statement statement = DataBaseConnectivity.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT client_id FROM clients WHERE name = '" + name + "' AND surname = '" + surname + "'")) {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
