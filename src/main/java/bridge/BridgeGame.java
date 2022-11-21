package bridge;

import bridge.enums.Direction;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int stage;
    private boolean directionMatchState;
    private int retryCount;
    private boolean runningState;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.stage = 0;
        this.directionMatchState = true;
        this.retryCount = 0;
        this.runningState = true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        stage++;
        directionMatchState = bridge.isDirectionMatched(stage, direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        stage = 0;
        retryCount++;
        runningState = true;
    }

    public void quit() {
        runningState = false;
    }
    public boolean canMoving() {
        return directionMatchState && !bridge.isLastStage(stage);
    }
    public boolean isCleared() {
        return directionMatchState && bridge.isLastStage(stage);
    }
    public boolean isRunning() {
        return runningState;
    }
    public int getTotalTryCount() {
        return 1 + retryCount;
    }
    public Bridge getBridge() {
        return bridge;
    }
    public int getStage() {
        return stage;
    }
    public boolean isNowStage(int stage) {
        return this.stage == stage;
    }
    public boolean isNowStageDirectionMatched() {
        return this.directionMatchState;
    }

}
