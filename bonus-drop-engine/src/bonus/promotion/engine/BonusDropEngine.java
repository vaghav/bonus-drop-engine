package bonus.promotion.engine;

import bonus.promotion.engine.model.BonusPlayResult;
import bonus.promotion.engine.model.PlayerChoice;

public interface BonusDropEngine {
    void setTotalBudget(int dollars);

    /**
     * @param playerChoice the choice being made
     * @return the calculated bonus
     */
    BonusPlayResult calculateBonus(PlayerChoice playerChoice);
}
