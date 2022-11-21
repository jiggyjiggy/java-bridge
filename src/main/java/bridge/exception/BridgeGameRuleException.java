package bridge.exception;

public class BridgeGameRuleException extends RuntimeException {
    public BridgeGameRuleException(String message, ExceptionType exceptionType) {
        super(message);
        throw new IllegalArgumentException(
                exceptionType.getMessage()
        );
    }
    public BridgeGameRuleException(String message, ExceptionType exceptionType, String guide) {
        super(message);
        throw new IllegalArgumentException(
                exceptionType.getMessage(guide)
        );
    }

}
