package comm.vlad.system.services.impl;

import comm.vlad.system.domain.Card;

import java.util.List;

public interface CardService {

    List<Card> getAll();
    void addMoney();
    void reduceMoney();

}
