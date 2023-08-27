package comm.vlad.system.domain;

import comm.vlad.system.configs.DataBaseConnectivity;
import comm.vlad.system.services.impl.Banks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String verNumber;
    private int money;
    private Banks banks;

    public void showAllInfoCard() {

    }

    public void save() {
        Connection connection = DataBaseConnectivity.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO card (card_id, to_client,  verNumber, money, id_bank)" +
                            " values (?,?,?,?,?)");
            preparedStatement.setInt(1, 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
