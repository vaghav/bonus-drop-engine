package bonus.promotion.engine;

import bonus.promotion.engine.model.BoardZone;
import bonus.promotion.engine.model.BonusPlayResult;
import bonus.promotion.engine.model.PlayerChoice;

public interface BonusDropEngine {
    /**
     *
     * @param money the total bonus budget.
     */
    void setTotalBudget(int money);

    /**
     *
     * @param boardZone the board zone where ball dropped.
     */
    void setBoardZone(BoardZone boardZone);

    /**
     * @param playerChoice the choice being made
     * @return the calculated bonus
     */
    BonusPlayResult calculateBonus(PlayerChoice playerChoice);
}
