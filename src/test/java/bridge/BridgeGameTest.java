//package bridge;
//
//import bridge.enums.Direction;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BridgeGameTest {
////    BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "U")), mapDrawer);
//
//    @Test
//    @DisplayName("현재 game의 stage를 반환한다")
//    void getStage() {
//        // Given
//        // When
//        bridgeGame.move(Direction.UP);
//        bridgeGame.move(Direction.DOWN);
//
//        // Then
//        int nowStage = bridgeGame.getStage();
//        assertEquals(2, nowStage);
//    }
//
//    @Test
//    @DisplayName("1개의 stage를 이동한다")
//    void move() {
//        // Given
//        // When
//        int beforeStage = bridgeGame.getStage();
//        bridgeGame.move(Direction.UP);
//        int afterStage = bridgeGame.getStage();
//
//        // Then
//        assertEquals(1, afterStage - beforeStage);
//    }
//
//    @Test
//    void retry() {
//    }
//
//    @Test
//    void quit() {
//    }
//
//    @Test
//    void canMoving() {
//        // Given
//
//        // When
//        bridgeGame.move(Direction.UP);
//        bridgeGame.move(Direction.UP);
//
//        // Then
//        assertFalse(bridgeGame.canMoving());
//    }
//
//    @Test
//    @DisplayName("game을 성공여부를 반환한다.")
//    void isCleared() {
//        // Given
//
//        // When
//        bridgeGame.move(Direction.UP);
//        bridgeGame.move(Direction.DOWN);
//        bridgeGame.move(Direction.UP);
//        bridgeGame.move(Direction.UP);
//
//        // Then
//        assertTrue(bridgeGame.isCleared());
//    }
//
//    @Test
//    @DisplayName("game의 실행상태를 반환한다.")
//    void isRunning() {
//        // Given
//
//        // When
//        bridgeGame.quit();
//
//        // Then
//        assertFalse(bridgeGame.isRunning());
//    }
//
//    @Test
//    void getTotalTryCount() {
//    }
//
//    @Test
//    void getBridge() {
//    }
//
//    @Test
//    void isNowStage() {
//    }
//
//    @Test
//    void isNowStageDirectionMatched() {
//    }
//}