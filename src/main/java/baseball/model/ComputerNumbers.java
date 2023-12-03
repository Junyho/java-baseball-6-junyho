package baseball.model;

import java.util.ArrayList;
import java.util.List;

public record ComputerNumbers(List<Integer> computer) {
    public ComputerNumbers(List<Integer> computer) {
        this.computer = new ArrayList<>(computer);
    }

    @Override
    public List<Integer> computer() {
        return new ArrayList<>(this.computer);
    }
}
