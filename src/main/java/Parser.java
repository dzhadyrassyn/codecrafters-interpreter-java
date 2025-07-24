import java.util.ArrayList;
import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int current = 0;

    public Parser() {
        this.tokens = new ArrayList<>();
    }
}
