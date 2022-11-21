package bridge;

import bridge.enums.Announcement;
import bridge.enums.GameCommand;
import bridge.enums.MovingDirection;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameMachine {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public void launch() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void setUpGame() {
        outputView.printSpaceLineAndMessage(Announcement.INPUT_BRIDGE_SIZE.getMessage());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge, bridgeMaker);
    }

    public void gameStart() {
        outputView.printMessage(Announcement.GAME_START.getMessage());
        while (bridgeGame.isRunning()) {
            playStage();
            if (bridgeGame.isCleared()) {
                break;
            }
            askRetryOrQuit();
        }
    }

    private void playStage() {
        while (bridgeGame.canMoving()) {
            outputView.printSpaceLineAndMessageAddGuide(
                    Announcement.INPUT_MOVING_DIRECTION.getMessage(),
                    MovingDirection.getGuide()
            );
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
        }
    }
    private void askRetryOrQuit() {
        outputView.printSpaceLineAndMessageAddGuide(
                Announcement.INPUT_RETRY_OR_QUIT.getMessage(),
                GameCommand.getGuide()
        );
        GameCommand command = inputView.readGameCommand();
        if (command.isRetry()) {
            bridgeGame.retry();
            return;
        }
        bridgeGame.quit();
    }

    public void gameFinish() {
        if (bridgeGame.isCleared() || !bridgeGame.isRunning()) {
            outputView.printResult(bridgeGame);
        }
    }
}
