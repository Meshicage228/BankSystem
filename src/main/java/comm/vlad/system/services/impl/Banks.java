package comm.vlad.system.services.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Banks {
    SBERBANK(0.03f),
    ALPHABANK(0.02f),
    BELARUSBANK(0.05f),
    IDEABANK(0.08f);

    private float coef;

}
