package baseball.model;

public class Strike_And_Ball_Count {
    private int strike;
    private int ball;

    public Strike_And_Ball_Count() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void plusStrikeCount() {
        this.strike++;
    }

    public void plusBallCount() {
        this.ball++;
    }

}
