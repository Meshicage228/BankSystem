import comm.vlad.system.domain.Card;
import comm.vlad.system.domain.CashMachine;
import comm.vlad.system.domain.Client;
import comm.vlad.system.services.Banks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Vlad", "Zherko", List.of(
                new Card("777777777", 1200, Banks.ALPHABANK),
                new Card("123123123", 155, Banks.IDEABANK),
                new Card("521546624", 674, Banks.ALPHABANK)
        ));
        Client client2 = new Client("Olga", "Turchuk", List.of(
                new Card("874963489", 5000, Banks.BELARUSBANK),
                new Card("347864348", 23, Banks.IDEABANK),
                new Card("505709335", 654, Banks.SBERBANK)
        ));
        CashMachine cashMachine = new CashMachine(client2);
        cashMachine.machineLogic();
        cashMachine.showHistory();


    }
}
