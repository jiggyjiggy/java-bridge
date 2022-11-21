package bridge.enums;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R", "재시도"),
    QUIT("Q", "종료");
    private final String shortcut;
    private final String description;
    GameCommand(String shortcut, String description) {
        this.shortcut = shortcut;
        this.description = description;
    }
    public static String getGuide() {
        StringBuilder guides = new StringBuilder();
        int count = 0;
        int totalCommandCount = GameCommand.values().length;

        guides.append("(");
        for (GameCommand gameCommand:
                GameCommand.values()) {
            count++;
            guides.append(gameCommand.description).append(": ").append(gameCommand.shortcut);
            if (count != totalCommandCount) {
                guides.append(", ");
            }
        }
        guides.append(")");
        return guides.toString();
    }
    public static boolean contains(String input) {
        return Arrays.stream(GameCommand.values())
                .map(element -> element.shortcut)
                .anyMatch(command -> command.equals(input));
    }

    public static GameCommand find(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(element -> element.shortcut.equals(command))
                .findFirst().get();
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }

}
