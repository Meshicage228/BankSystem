package comm.vlad.system.services.impl;

import comm.vlad.system.configs.DataBaseConnectivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
public enum Banks {
    SBERBANK(0.03f),
    ALPHABANK(0.02f),
    BELARUSBANK(0.05f),
    IDEABANK(0.08f);

    Banks(float coef) {
        this.coef = coef;
    }
    private float coef;

    public static int getIdBank(Banks banks){
        try (ResultSet resultSet = DataBaseConnectivity.getStatement().executeQuery("SELECT bank_id FROM banks WHERE title LIKE '" + banks + "'")){
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
