package bridge.view;

import bridge.enums.GameCommand;
import bridge.enums.MovingDirection;
import bridge.exception.BridgeSizeException;
import bridge.exception.GameCommandException;
import bridge.exception.MovingDirectionException;
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
            String input = Console.readLine();
            validateInteger(input);
            validateRange(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printMessage(illegalArgumentException.getMessage());
            return readBridgeSize();
        }
    }
    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BridgeSizeException(e.getMessage());
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
    public MovingDirection readMoving() {
        try {
            String input = Console.readLine();
            validateMoving(input);
            return MovingDirection.find(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printMessage(illegalArgumentException.getMessage());
            return readMoving();
        }
    }

    private void validateMoving(String input) {
        if (!MovingDirection.contains(input)) {
            throw new MovingDirectionException(
                    new IllegalArgumentException().getMessage(),
                    MovingDirection.getGuide());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        try {
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
