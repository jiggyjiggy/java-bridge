package bridge.exception;

public class GameCommandException extends BridgeGameRuleException {
    public GameCommandException(String message, String guide) {
        super(message, ExceptionType.INPUT_IN_SERVING_SHORTCUT, guide);
    }
}
