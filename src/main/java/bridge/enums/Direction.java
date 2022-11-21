package bridge.enums;

import java.util.Arrays;

public enum Direction {
    UP("U", "위", 1),
    DOWN("D", "아래", 0);

    private final String shortcut;
    private final String description;
    private final int directionNumber;

    Direction(String shortcut, String description, int directionNumber) {
        this.shortcut = shortcut;
        this.description = description;
        this.directionNumber = directionNumber;
    }

    // 이넘 목적에 맞지 않음
    public static String getGuide() {
        StringBuilder guides = new StringBuilder();
        int count = 0;
        int totalDirectionCount = Direction.values().length;

        guides.append("(");
        for (Direction directions :
                Direction.values()) {
            count++;
            guides.append(directions.description).append(": ").append(directions.shortcut);
            if (count != totalDirectionCount) {
                guides.append(", ");
            }
        }
        guides.append(")");
        return guides.toString();
    }

    public static boolean contains(String input) {
        return Arrays.stream(Direction.values())
                .map(element -> element.shortcut)
                .anyMatch(direction -> direction.equals(input));
    }

    public static String findDirection(int number) {
        return Arrays.stream(Direction.values())
                .filter(element -> element.directionNumber == number)
                .findFirst().get().shortcut;
    }
    public static Direction find(String direction) {
        return Arrays.stream(Direction.values())
                .filter(element -> element.shortcut.equals(direction))
                .findFirst().get();
    }

    public boolean isUp() {
        return this.equals(UP);
    }
    public boolean isDown() {
        return this.equals(DOWN);

    }
}
