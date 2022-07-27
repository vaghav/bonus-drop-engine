package bonus.promotion.engine.model;

import java.util.HashMap;
import java.util.Map;

import static bonus.promotion.engine.model.BoardZone.*;

public final class BonusTable {
    private static final Map<ButtonSide, Map<BoardZone, String>> bonusTable = new HashMap<>();

    static {
        bonusTable.put(ButtonSide.LEFT, Map.of(BONUS_FIRST, "22%",
                NO_BONUS, "35%", REPLAY, "12%", BONUS_SECOND, "12%", NO_BONUS_SECOND, "5%",
                BONUS_THIRD, "3%", BONUS_FORTH, "1%"));
        bonusTable.put(ButtonSide.MIDDLE, Map.of(BONUS_FIRST, "5%",
                NO_BONUS, "10%", REPLAY, "20%", BONUS_SECOND, "30%", NO_BONUS_SECOND, "20%",
                BONUS_THIRD, "10%", BONUS_FORTH, "5%"));
        bonusTable.put(ButtonSide.RIGHT, Map.of(BONUS_FIRST, "1%",
                NO_BONUS, "3%", REPLAY, "5%", BONUS_SECOND, "12%", NO_BONUS_SECOND, "22%",
                BONUS_THIRD, "35%", BONUS_FORTH, "22%"));
    }

    private BonusTable() {
    }

    public static Map<BoardZone, String> getBorerZoneBonusMap(ButtonSide side) {
        return bonusTable.get(side);
    }

}

