package bridge.enums;

import java.util.Arrays;

public enum MovingDirection {
    UP("U", "위", 1),
    DOWN("D", "아래", 0);

    private final String shortcut;
    private final String description;
    private final int directionNumber;

    MovingDirection(String shortcut, String description, int directionNumber) {
        this.shortcut = shortcut;
        this.description = description;
        this.directionNumber = directionNumber;
    }

    // 이넘 목적에 맞지 않음
    public static String getGuide() {
        StringBuilder guides = new StringBuilder();
        int count = 0;
        int totalDirectionCount = MovingDirection.values().length;

        guides.append("(");
        for (MovingDirection directions :
                MovingDirection.values()) {
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
        return Arrays.stream(MovingDirection.values())
                .map(element -> element.shortcut)
                .anyMatch(direction -> direction.equals(input));
    }

    public static String findDirection(int number) {
        return Arrays.stream(MovingDirection.values())
                .filter(element -> element.directionNumber == number)
                .findFirst().get().shortcut;
    }
    public static MovingDirection find(String direction) {
        return Arrays.stream(MovingDirection.values())
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
