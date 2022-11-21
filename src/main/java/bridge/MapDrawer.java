package bridge;

import bridge.enums.MapStructure;
import bridge.enums.MovingDirection;

public class MapDrawer {
    private StringBuilder upSide;
    private StringBuilder downSide;

    public String drawMap(BridgeGame bridgeGame, int nowStage) {
        initializeMap();
        for (int stage = 1; stage <= nowStage; stage++) {
            MovingDirection direction = MovingDirection.find(bridgeGame.getBridge().get(stage));

            if (!bridgeGame.isNowStage(stage)) {
                makePassMap(direction, upSide, downSide);
                addVerticalBar(upSide, downSide);
                continue;
            }
            if (bridgeGame.isNowStageDirectionMatched()) {
                makePassMap(direction, upSide, downSide);
                continue;
            }
            makeNonPassMap(direction, upSide, downSide);
        }
        return wrapBrace(upSide, downSide);
    }
    private void initializeMap() {
        upSide = new StringBuilder();
        downSide = new StringBuilder();
    }
    private void makePassMap(MovingDirection direction, StringBuilder upSide, StringBuilder downSide) {
        if (direction.isUp()) {
            addCorrectMark(upSide);
            addWhiteSpace(downSide);
        }
        if (direction.isDown()) {
            addWhiteSpace(upSide);
            addCorrectMark(downSide);
        }
    }
    private void makeNonPassMap(MovingDirection direction, StringBuilder upSide, StringBuilder downSide) {
        if (direction.isUp()) {
            addWhiteSpace(upSide);
            addUnCorrectMark(downSide);
        }
        if (direction.isDown()) {
            addUnCorrectMark(upSide);
            addWhiteSpace(downSide);
        }
    }

    private String wrapBrace(StringBuilder upSide, StringBuilder downSide) {
        openMap(upSide, downSide);
        closeMap(upSide, downSide);
        return upSide.append("\n").append(downSide).toString();
    }

    private void openMap(StringBuilder upSide, StringBuilder downSide) {
        addOpenBrace(upSide);
        addOpenBrace(downSide);
    }
    private void closeMap(StringBuilder upSide, StringBuilder downSide) {
        addCloseBrace(upSide);
        addCloseBrace(downSide);
    }
    private void addOpenBrace(StringBuilder map) {
        map.insert(0, MapStructure.OPEN_BRACE.getPart());
    }
    private void addCloseBrace(StringBuilder map) {
        map.append(MapStructure.CLOSE_BRACE.getPart());
    }
    private void addVerticalBar(StringBuilder upSide, StringBuilder downSide) {
        upSide.append(MapStructure.VERTICAL_BAR.getPart());
        downSide.append(MapStructure.VERTICAL_BAR.getPart());
    }
    private void addCorrectMark(StringBuilder map) {
        map.append(MapStructure.CORRECT.getPart());
    }
    private void addUnCorrectMark(StringBuilder map) {
        map.append(MapStructure.INCORRECT.getPart());
    }
    private void addWhiteSpace(StringBuilder map) {
        map.append(MapStructure.WHITE_SPACE.getPart());
    }
}

