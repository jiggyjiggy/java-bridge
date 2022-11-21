package bridge.exception;

public class BridgeSizeException extends BridgeGameRuleException {
    public BridgeSizeException(String message) {
        super(message, ExceptionType.BRIDGE_SIZE_RANGE);
    }
}
