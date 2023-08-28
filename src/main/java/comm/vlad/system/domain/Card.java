package comm.vlad.system.domain;

import comm.vlad.system.services.Banks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String verNumber;
    private int money;
    private Banks banks;

}
