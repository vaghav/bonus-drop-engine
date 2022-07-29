package bonus.promotion.engine;

import bonus.promotion.engine.model.BoardZone;
import bonus.promotion.engine.model.BonusPlayResult;
import bonus.promotion.engine.model.PlayerChoice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bonus.promotion.engine.model.BonusTable.getBorerZoneBonusMap;

public class BonusDropEngineImpl implements BonusDropEngine {

    private int totalBudget;

    private BoardZone boardZone;

    @Override
    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }

    @Override
    public void setBoardZone(BoardZone boardZone) {
        this.boardZone = boardZone;
    }

    @Override
    public BonusPlayResult calculateBonus(PlayerChoice playerChoice) {
        if (boardZone == null) {
            throw new IllegalStateException("Border zone should be set first!");
        }
        return new BonusPlayResult(parseBonusValue(getBorerZoneBonusMap(playerChoice.getButtonSide()).get(boardZone)));
    }


    public int parseBonusValue(String bonusInPercentage) {
        Pattern pattern = Pattern.compile("([0-9]+)%");
        Matcher matcher = pattern.matcher(bonusInPercentage);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1)) * totalBudget / 100;
        } else {
            throw new IllegalArgumentException("Invalid bonus value was provided");
        }
    }
}
