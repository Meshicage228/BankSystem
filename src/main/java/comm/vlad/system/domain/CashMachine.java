package comm.vlad.system.domain;

import comm.vlad.system.configs.DataBaseConnectivity;
import comm.vlad.system.services.CardService;
import comm.vlad.system.services.ClientService;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

@Data
@RequiredArgsConstructor()
public class CashMachine {
    private int allCash = 12_000;
    @NonNull
    private Client client;
    private int IDcard;

    private void saveInfo(){
        System.out.println("Choose card :");
        for (int i = 0; i < client.getCards().size(); i++) {
            System.out.println(i + " " + client.getCards().get(i).getBanks());
        }
        IDcard = new Scanner(System.in).nextInt();
        ClientService.save(client);
        CardService.save(client, client.getCards().get(IDcard));
    }
    private int menu(){
        saveInfo();
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
                System.out.println(CardService.sumOnCard(client.getCards().get(IDcard)));
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {
                showHistory();
            }
            default -> {
                System.out.println("Wrong operator");
            }
        }
    }

    public void showHistory() {
        List<String> arr = new ArrayList<>();
        try (Statement statement = DataBaseConnectivity.getStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT name, surname, verNumber, title " +
                             "FROM card " +
                             "JOIN clients c on c.client_id = card.to_client " +
                             "JOIN banks b on b.bank_id = card.id_bank;")) {
            while(resultSet.next()){
               StringJoiner stringBuilder = new StringJoiner(" ");
               stringBuilder.add(resultSet.getString(1));
               stringBuilder.add(resultSet.getString(2));
               stringBuilder.add(resultSet.getString(3));
               stringBuilder.add(resultSet.getString(4));
               arr.add(String.valueOf(stringBuilder));
            }
            arr.forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
