package comm.vlad.system.services;

import comm.vlad.system.configs.DataBaseConnectivity;
import comm.vlad.system.domain.Card;
import comm.vlad.system.domain.Client;

import java.sql.*;

public class CardService {

    public static void save(Client client, Card card) {
        try (Connection connection = DataBaseConnectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO card (card_id, to_client,  verNumber, money, id_bank)" +
                             " values (?,?,?,?,?)")) {
            preparedStatement.setInt(1, getNextId(connection));
            preparedStatement.setInt(2, ClientService.getClientId(client.getName(), client.getSurname()));
            preparedStatement.setString(3, card.getVerNumber());
            preparedStatement.setInt(4, card.getMoney());
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
    private static int getCardId(String title) {
        try (Statement statement = DataBaseConnectivity.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT card_id FROM card WHERE vernumber = '" + title + "'")) {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int sumOnCard(Card card){
        int id = getCardId(card.getVerNumber());
        try (Statement statement = DataBaseConnectivity.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT money FROM card WHERE card_id = " + id)) {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
