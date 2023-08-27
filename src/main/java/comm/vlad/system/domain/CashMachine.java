package comm.vlad.system.domain;

import comm.vlad.system.configs.DataBaseConnectivity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class CashMachine {
    /*private int allCash = 12_000;*/
    private Client client;

    public void saveInfo(){
        System.out.println("Choose card :");
        for (int i = 0; i < client.getCards().size(); i++) {
            System.out.println(i + " " + client.getCards().get(i).getBanks());
        }
        new Client().save(client);
    }
    private int menu(){
        String contextMenu = """
                1. Sum on card
                2. Transaction to another card
                3. Get money
                4. Show Info Card
                """;
        System.out.println(contextMenu);
        return new Scanner(System.in).nextInt();
    };
    public void machineLogic(){
        switch (menu()){
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            default -> {
                System.out.println("Wrong operator");
            }
        }
    }
}
