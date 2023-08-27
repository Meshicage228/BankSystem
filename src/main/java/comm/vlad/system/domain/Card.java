package comm.vlad.system.domain;

import comm.vlad.system.configs.DataBaseConnectivity;
import comm.vlad.system.services.impl.Banks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String verNumber;
    private int money;
    private Banks banks;

    public static void save(Client client, Card card) {
        try (Connection connection = DataBaseConnectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO card (card_id, to_client,  verNumber, money, id_bank)" +
                             " values (?,?,?,?,?)")) {
            preparedStatement.setInt(1, getNextId(connection));
            preparedStatement.setInt(2, Client.getClientId(client.getName(), client.getSurname()));
            preparedStatement.setString(3, card.verNumber);
            preparedStatement.setInt(4, card.money);
            preparedStatement.setInt(5, Banks.getIdBank(card.getBanks()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getNextId(Connection connection) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT max(card_id) + 1 FROM card")) {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
