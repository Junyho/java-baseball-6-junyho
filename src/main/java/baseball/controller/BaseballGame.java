package baseball.controller;

import baseball.model.ComputerNumbers;
import baseball.model.PlayButton;
import baseball.model.Strike_And_Ball_Count;
import baseball.model.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private static final int THREE_STRIKE_COUNT = 3;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        do {
            outputView.gameStart();
            play();
        } while (playButton());
    }

    public void play() {

        List<Integer> computer = generateRandomNumbers();
        ComputerNumbers computerNumbers = new ComputerNumbers(computer);

        while (true) {
            inputView.enterNumbers();
            List<Integer> user = enterNumbers();
            UserNumbers userNumbers = new UserNumbers(user);
            Strike_And_Ball_Count strikeAndBallCount = new Strike_And_Ball_Count();
            getCount(computerNumbers, userNumbers, strikeAndBallCount);
            outputView.printStrikeAndBall(strikeAndBallCount);
            if (strikeAndBallCount.getStrike() == THREE_STRIKE_COUNT)
                break;
        }
    }
    public List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> enterNumbers() {
        List<Integer> user = new ArrayList<>();
        String input = readLine();
        for (String number : input.split("")) {
            user.add(Integer.parseInt(number));
        }
        return user;
    }

    public void getCount(ComputerNumbers computer, UserNumbers userNumber, Strike_And_Ball_Count strikeAndBallCount) {
        List<Integer> answer = computer.computer();
        List<Integer> user = userNumber.getUserNumber();

        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals(answer.get(i)))
                strikeAndBallCount.plusStrikeCount();
            else {
                for (int j = 0; j < user.size(); j++) {
                    if (user.get(i).equals(answer.get(j)))
                        strikeAndBallCount.plusBallCount();
                }
            }
        }
    }

    public boolean playButton() {
        inputView.replayOrQuit();
        PlayButton playButton = new PlayButton();
        return playButton.getPlayButton();
    }

}
