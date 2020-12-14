package subway.console;

import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class Output {

    private Output() {
    }

    public static void printPage(final List<String> page) {
        page.forEach(System.out::println);
    }

    public static void printStations(List<Station> stations) {
        if (!stations.isEmpty()) {
            print(Message.STATIONS);
            stations.forEach(station -> print(combine(station.getName())));
        }
    }

    public static void printLines(List<Line> lines) {
        print(Message.LINES);
        lines.forEach(line -> print(combine(line.getName())));
    }

    private static String combine(String name) {
        return Message.INFO + name;
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printSubwayLine(Map<Line, List<Station>> sections) {
        if (isEmpty(sections)) {
            print(Message.ERROR_EMPTY_LINE);
            return;
        }

        print(Message.SUBWAY_LINE);
        printSubwayInformation(sections);
    }

    private static boolean isEmpty(Map<Line, List<Station>> sections) {
        return sections.isEmpty();
    }

    private static void printSubwayInformation(Map<Line, List<Station>> sections) {
        for (Line line : sections.keySet()) {
            print(combine(line.getName()));
            print(Message.SUBWAY_INFO);

            sections.get(line).forEach(station -> print(combine(station.getName())));
            printBlankLine();
        }
    }
}
