package bridge.view;

import bridge.MapDrawer;
import bridge.enums.Announcement;
import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }
    public void printSpaceLineAndMessage(String message) {
        System.out.println();
        System.out.println(message);
    }
    public void printSpaceLineAndMessageAddGuide(String message, String guide) {
        System.out.println();
        System.out.println(message + " " + guide);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        MapDrawer mapDrawer = new MapDrawer();
        int nowStage = bridgeGame.getBridge().getDirectionsByStage(bridgeGame.getStage()).size();
        System.out.println(mapDrawer.drawMap(bridgeGame, nowStage));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        printSpaceLineAndMessage(Announcement.GAME_FINISH.getMessage());
        printMap(bridgeGame);
        System.out.println();
        StringBuilder clearOrNotMessage = new StringBuilder();
        clearOrNotMessage.append(Announcement.GAME_CLEAR_OR_NOT.getMessage());
        addSuccessOrFail(bridgeGame, clearOrNotMessage);
        printMessage(clearOrNotMessage.toString());
        printMessage(Announcement.TOTAL_TRY_COUNT.getMessage() + bridgeGame.getTotalTryCount());
    }
    private void addSuccessOrFail(BridgeGame bridgeGame, StringBuilder message) {
        if (bridgeGame.isCleared()) {
            message.append(Announcement.SUCCESS.getMessage());
            return;
        }
        message.append(Announcement.FAIL.getMessage());
    }

//    public static String makeGuide(EnumMap enums) {
//        StringBuilder guides = new StringBuilder();
//        int count = 0;
//        int totalCommandCount = GameCommand.values().length;
//
//        guides.append("(");
//        for (Enum element:
//                EnumMap.values()) {
//            count++;
//            guides.append(gameCommand.description).append(": ").append(gameCommand.shortcut);
//            if (count != totalCommandCount) {
//                guides.append(", ");
//            }
//        }
//        guides.append(")");
//        return guides.toString();
//    }
}