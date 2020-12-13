package subway.console;

import static subway.console.Output.printLine;

import java.util.List;
import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Input {
    private static final String REGEX = "\\p{Z}";
    private static final String REPLACEMENT = "";

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextButton(List<String> buttons) {
        String button = toUpper(nextLine());
        while (!buttons.contains(button)) {
            printLine(Message.ERROR_NOT_BUTTON);
            printLine(Message.INPUT_SELECT_BUTTON);
            button = toUpper(nextLine());
        }
        return button;
    }

    private String toUpper(String input) {
        return input.toUpperCase();
    }

    public String nextLine() {
        return scanner.nextLine().replaceAll(REGEX, REPLACEMENT);
    }
}
