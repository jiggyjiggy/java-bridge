package bridge.view;

import bridge.enums.Announcement;
import bridge.enums.GameCommand;
import bridge.enums.Direction;
import bridge.exception.BridgeSizeException;
import bridge.exception.GameCommandException;
import bridge.exception.DirectionException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            outputView.printSpaceLineAndMessage(Announcement.INPUT_BRIDGE_SIZE.getMessage());
            String input = Console.readLine();
            validateBridgeSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printMessage(illegalArgumentException.getMessage());
            return readBridgeSize();
        }
    }
    private void validateBridgeSize(String input) {
        validateInteger(input);
        validateRange(input);
    }
    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new BridgeSizeException(numberFormatException.getMessage());
        }
    }
    private void validateRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 3 || 20 < inputNumber) {
            throw new BridgeSizeException(input);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        try {
            outputView.printSpaceLineAndMessage(Announcement.INPUT_MOVING_DIRECTION.getMessage(), Direction.getGuide());
            String input = Console.readLine();
            validateMoving(input);
            return Direction.find(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printMessage(illegalArgumentException.getMessage());
            return readMoving();
        }
    }

    private void validateMoving(String input) {
        if (!Direction.contains(input)) {
            throw new DirectionException(
                    new IllegalArgumentException().getMessage(),
                    Direction.getGuide());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        try {
            outputView.printSpaceLineAndMessage(Announcement.INPUT_RETRY_OR_QUIT.getMessage(), GameCommand.getGuide());
            String input = Console.readLine();
            validateGameCommand(input);
            return GameCommand.find(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printMessage(illegalArgumentException.getMessage());
            return readGameCommand();
        }
    }
    private void validateGameCommand(String input) {
        if (!GameCommand.contains(input)) {
            throw new GameCommandException(
                    new IllegalArgumentException().getMessage(),
                    GameCommand.getGuide());
        }
    }

}
