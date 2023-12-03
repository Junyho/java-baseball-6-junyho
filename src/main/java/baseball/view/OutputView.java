package baseball.view;

import baseball.model.Strike_And_Ball_Count;

public class OutputView {

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printStrikeAndBall(Strike_And_Ball_Count count) {
        if (count.getStrike() == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (count.getBall() > 0 && count.getStrike() > 0)
            System.out.println(count.getBall() + "볼 " + count.getStrike() + "스트라이크");
        else if (count.getBall() > 0)
            System.out.println(count.getBall() + "볼");
        else if (count.getStrike() > 0)
            System.out.println(count.getStrike() + "스트라이크");
        else
            System.out.println("낫싱");
    }
}
