package pwo;

public class LucasGenerator {

    private int lastIndex = 0;
    private int current = 2;
    private int l_1 = 1;
    private int l_2 = 2;

    public void reset() {
        lastIndex = 0;
        current = 2;
        l_1 = 1;
        l_2 = 2;
    }

    public int nextTerm() {
        if (lastIndex > 1) {
            current = l_1 + l_2;
            l_1 = l_2;
            l_2 = current;
        } else if (lastIndex == 1) {
            current = 1;
        } else {
            current = 2;
        }
        lastIndex++;
        return current;
    }

    public int getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}