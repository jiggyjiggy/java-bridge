package bridge.exception;

public class MovingDirectionException extends BridgeGameRuleException {
    public MovingDirectionException(String message, String guide) {
        super(message, ExceptionType.INPUT_IN_SERVING_SHORTCUT, guide);
    }
}
