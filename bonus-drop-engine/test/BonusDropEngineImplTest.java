import bonus.promotion.engine.BonusDropEngine;
import bonus.promotion.engine.BonusDropEngineImpl;
import bonus.promotion.engine.model.BonusPlayResult;
import bonus.promotion.engine.model.PlayerChoice;
import org.junit.jupiter.api.Assertions;

import static bonus.promotion.engine.model.BoardZone.BONUS_FIRST;
import static bonus.promotion.engine.model.ButtonSide.LEFT;

class BonusDropEngineImplTest {

    @org.junit.jupiter.api.Test
    void setTotalBudget() {
    }

    @org.junit.jupiter.api.Test
    void shouldParseBonusValue() {
        BonusDropEngineImpl bonusDropEngine = new BonusDropEngineImpl();
        Assertions.assertEquals(45, bonusDropEngine.parseBonusValue("45%"));
    }

    @org.junit.jupiter.api.Test
    void shouldThrowIllegalArgumentException() {
        BonusDropEngineImpl bonusDropEngine = new BonusDropEngineImpl();
        Assertions.assertThrows(IllegalArgumentException.class, () -> bonusDropEngine.parseBonusValue("45gg%"));
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateBonusResult() {
        BonusDropEngine bonusDropEngine = new BonusDropEngineImpl();
        bonusDropEngine.setTotalBudget(500);
        BonusPlayResult actualResult = bonusDropEngine.calculateBonus(new PlayerChoice(LEFT, BONUS_FIRST));
        Assertions.assertEquals(110, actualResult.getEarnedResult());
    }
}