package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(Money money) {
        makeRandomLottos(money);
    }

    private void makeRandomLottos(Money money) {
        for (int i = 0; i < money.toNumberOfPurchaseLotto(); i++) {
            lottos.add(Lotto.ofRandomLotto());
        }
    }

    public List<Lotto> toList() {

        return Collections.unmodifiableList(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
