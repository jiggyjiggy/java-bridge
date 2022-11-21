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
    OutputView outputView;
    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input;
        while (true) {
            try {
                input = inputBridgeSize();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    private String inputBridgeSize() {
        outputView.printSpaceLineAndMessage(Announcement.INPUT_BRIDGE_SIZE.getMessage());
        String input = Console.readLine();
        validateInteger(input);
        validateBridgeRange(input);
        return input;
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new BridgeSizeException(numberFormatException.getMessage());
        }
    }
    private void validateBridgeRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 3 || 20 < inputNumber) {
            throw new BridgeSizeException(input);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        String input;
        while (true) {
            try {
                input = inputMoving();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return Direction.find(input);
    }

    private String inputMoving() {
        outputView.printSpaceLineAndMessage(Announcement.INPUT_MOVING_DIRECTION.getMessage(), Direction.getGuide());
        String input = Console.readLine();
        validateMoving(input);
        return input;
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
    public GameCommand readGameCommand() throws GameCommandException {
        String input;
        while (true) {
            try {
                input = inputGameCommand();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printMessage(illegalArgumentException.getMessage());
            }
        }
        return GameCommand.find(input);
    }
    private String inputGameCommand() {
        outputView.printSpaceLineAndMessage(Announcement.INPUT_RETRY_OR_QUIT.getMessage(), GameCommand.getGuide());
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }
    private void validateGameCommand(String input) {
        if (!GameCommand.contains(input)) {
            throw new GameCommandException(
                    new IllegalArgumentException().getMessage(),
                    GameCommand.getGuide());
        }
    }

}
