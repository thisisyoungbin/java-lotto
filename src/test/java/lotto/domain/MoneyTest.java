package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @DisplayName("금액이 들어오면 구매할 수 있는 로또의 개수를 반환하는 테스트")
    @Test
    void testCountLotto() {
        Money money = Money.of("1000");
        assertThat(money.toNumberOfPurchaseLotto()).isEqualTo(1);
    }

    @Test
    @DisplayName("Money 예외사항들 테스트")
    void testValidateMoney() {
        String wrongMoney1 = "";
        String wrongMoney2 = null;
        String wrongMoney3 = "숫자";
        String wrongMoney4 = "999";

        assertThatNullPointerException()
                .isThrownBy(() -> Money.of(wrongMoney1));
        assertThatNullPointerException()
                .isThrownBy(() -> Money.of(wrongMoney2));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.of(wrongMoney3));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.of(wrongMoney4));
    }
}
