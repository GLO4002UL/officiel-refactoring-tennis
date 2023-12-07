package ca.ulaval.glo4002.tennis;

public class Player {

    public static final int ADVANTAGE_DIFFERENCE = 1;
    public static final int WIN_DIFFERENCE = 2;
    public static final int MINIMUM_GAME_SCORE = 4;
    private final String name;
    private Integer score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public boolean isCalled(String name) {
        return this.name.equals(name);
    }

    public void wonPoint() {
        score += 1;
    }

    public boolean isInATieWith(Player otherPlayer) {
        return score.equals(otherPlayer.score);
    }

    public boolean isNotInATieWith(Player otherPlayer) {
        return !isInATieWith(otherPlayer);
    }

    public boolean hasNormalScoreAgainst(Player otherPlayer) {
        return score < MINIMUM_GAME_SCORE &&
                otherPlayer.score < MINIMUM_GAME_SCORE &&
                isNotInATieWith(otherPlayer);
    }

    public boolean hasAdvantageAgainst(Player otherPlayer) {
        return score >= MINIMUM_GAME_SCORE &&
                (score - otherPlayer.score) == ADVANTAGE_DIFFERENCE;
    }

    public boolean hasWonAgainst(Player otherPlayer) {
        return score >= MINIMUM_GAME_SCORE &&
                (score - otherPlayer.score) >= WIN_DIFFERENCE;
    }
}
