package comm.vlad.system.domain;

import comm.vlad.system.configs.DataBaseConnectivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String name;
    private String surname;
    private List<Card> cards;

    public void save(Client client) {
        try (Connection connection = DataBaseConnectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients (client_id, name, surname) VALUES (?,?,?)")) {
            preparedStatement.setInt(1, getNextId(connection));
            preparedStatement.setString(2, client.name);
            preparedStatement.setString(3, client.surname);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int getNextId(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT max(client_id) + 1 FROM clients");
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
