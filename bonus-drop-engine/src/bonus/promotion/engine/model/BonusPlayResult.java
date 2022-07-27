package bonus.promotion.engine.model;

public class BonusPlayResult {
    private int earnedResult;

    public BonusPlayResult() {
    }

    public BonusPlayResult(int earnedResult) {
        this.earnedResult = earnedResult;
    }

    public void setEarnedResult(int earnedResult) {
        this.earnedResult = earnedResult;
    }

    public int getEarnedResult() {
        return earnedResult;
    }
}
