package bridge;

import bridge.UI.output.MapDrawer;
import bridge.enums.Direction;
import bridge.enums.GameProgressState;
import bridge.enums.StageState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    MapDrawer mapDrawer = new MapDrawer();
    BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "U")), mapDrawer);

    @Nested
    @DisplayName("입력한 방향으로 한 칸 이동한다.")
    class move {
        @Test
        @DisplayName("1개의 stage를 이동한다")
        void move1() {
            int beforeStage = bridgeGame.getStage();
            bridgeGame.move(Direction.UP);
            int afterStage = bridgeGame.getStage();

            assertEquals(1, afterStage - beforeStage);
        }

        @Nested
        @DisplayName("입력한 방향과 해당 칸의 위치를 비교하여")
        class aa {
            @Test
            @DisplayName("일치한다면 해당 stage를 pass상태로 업데이트한다.")
            void move2() {
                bridgeGame.move(Direction.UP);
                assertTrue(bridgeGame.canMoving());
            }

            @Test
            @DisplayName("일치하지 않는다면 해당 stage를 non-pass상태로 업데이트한다.")
            void move3() {
                bridgeGame.move(Direction.DOWN);
                assertFalse(bridgeGame.canMoving());
            }
        }

        @Test
        @DisplayName("다리의 길이만큼 방향을 모두 맞추면 game을 clear상태로 업데이트한다.")
        void move4() {
            bridgeGame.move(Direction.UP);
            bridgeGame.move(Direction.DOWN);
            bridgeGame.move(Direction.UP);
            bridgeGame.move(Direction.UP);

            assertTrue(bridgeGame.isCleared());
        }
    }

    @Nested
    @DisplayName("게임을 재시도한다.")
    class retry {
        @Test
        @DisplayName("게임의 이동된 칸의 위치를 처음 칸으로 업데이트한다.")
        void retry1() {
            bridgeGame.move(Direction.UP);
            bridgeGame.move(Direction.DOWN);
            bridgeGame.move(Direction.UP);

            bridgeGame.retry();

            assertEquals(0, bridgeGame.getStage());
        }

        @Test
        @DisplayName("게임 시도 횟수를 1 증가시킨다.")
        void retry2() {
            int beforeTryCount = bridgeGame.getTotalTryCount();
            bridgeGame.retry();
            int afterTryCount = bridgeGame.getTotalTryCount();

            assertEquals(1, afterTryCount - beforeTryCount);
        }

        @Test
        @DisplayName("게임의 진행 상태를 running 상태로 업데이트한다.")
        void retry3() {
            bridgeGame.retry();
            assertTrue(bridgeGame.isRunning());
        }
    }

    @Test
    @DisplayName("게임을 끝낸다.")
    void quit() {
        bridgeGame.quit();
        assertFalse(bridgeGame.isRunning());
    }

}