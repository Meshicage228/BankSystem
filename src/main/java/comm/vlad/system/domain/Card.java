package comm.vlad.system.domain;

import comm.vlad.system.services.impl.Banks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private int verNumber;
    private int money;
    private Banks banks;
}
