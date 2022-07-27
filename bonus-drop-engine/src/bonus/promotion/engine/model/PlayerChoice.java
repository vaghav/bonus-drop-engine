package bonus.promotion.engine.model;

import java.util.Map;

public class PlayerChoice {

    private ButtonSide buttonSide;

    private BoardZone boardZone;

    public PlayerChoice(ButtonSide buttonSide, BoardZone boardZone) {
        this.buttonSide = buttonSide;
        this.boardZone = boardZone;
    }

    public ButtonSide getButtonSide() {
        return buttonSide;
    }

    public BoardZone getBoardZone() {
        return boardZone;
    }
}

