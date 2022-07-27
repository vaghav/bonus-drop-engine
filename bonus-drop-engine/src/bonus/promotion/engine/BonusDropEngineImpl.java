package bonus.promotion.engine;

import bonus.promotion.engine.model.BonusPlayResult;
import bonus.promotion.engine.model.PlayerChoice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bonus.promotion.engine.model.BonusTable.getBorerZoneBonusMap;
import static bonus.promotion.engine.model.ButtonSide.*;

public class BonusDropEngineImpl implements BonusDropEngine {

    private int totalBudget;

    @Override
    public void setTotalBudget(int money) {
        totalBudget = money;
    }

    @Override
    public BonusPlayResult calculateBonus(PlayerChoice playerChoice) {
        BonusPlayResult result = new BonusPlayResult();
        switch (playerChoice.getButtonSide()) {
            case LEFT:
                result.setEarnedResult(parseBonusValue(getBorerZoneBonusMap(LEFT).get(playerChoice.getBoardZone())));
                break;
            case MIDDLE:
                result.setEarnedResult(parseBonusValue(getBorerZoneBonusMap(MIDDLE).get(playerChoice.getBoardZone())));
                break;
            case RIGHT:
                result.setEarnedResult(parseBonusValue(getBorerZoneBonusMap(RIGHT).get(playerChoice.getBoardZone())));
                break;
            default:
                throw new IllegalStateException("Unknown button sie=de");
        }
        return result;
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
