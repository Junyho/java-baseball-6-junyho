package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class PlayButton {
    private final int playButton;
    private static final int RESTART = 1;
    private static final int QUIT_GAME = 2;

    public PlayButton() {
        this.playButton = Integer.parseInt(Console.readLine());
        if (this.playButton != RESTART && this.playButton != QUIT_GAME)
            throw new IllegalArgumentException("재시작 버튼 입력은 1 또는 2만 가능합니다.");
    }

    public boolean getPlayButton() {
        return playButton == RESTART;
    }
}