package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {

    private final List<Integer> user;

    public UserNumbers(List<Integer> user) {

        this.user = new ArrayList<>(user);
        if (user.size() != 3)
            throw new IllegalArgumentException("3자리 수만 입력해주세요.");


        boolean hasDuplicates = user.stream().distinct().count() < user.size();
        if (hasDuplicates)
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
    }

    public List<Integer> getUserNumber() {
        return new ArrayList<>(this.user);
    }

}
