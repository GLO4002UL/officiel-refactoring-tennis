
package ca.ulaval.glo4002.tennis.score;

import java.util.TreeMap;

import ca.ulaval.glo4002.tennis.Player;

public class NormalScore extends Score {

    private static final TreeMap<Integer, String> scoreNames = new TreeMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    public NormalScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public Boolean isApplicable() {
        return player1.hasNormalScoreAgainst(player2);
    }

    public String toRepresentation() {
        return String.format("%s-%s",
                mapScoreToRepresentation(player1.getScore()),
                mapScoreToRepresentation(player2.getScore()));
    }

    private String mapScoreToRepresentation(Integer score) {
        return scoreNames.getOrDefault(
                scoreNames.floorKey(score),
                scoreNames.firstEntry().getValue());
    }
}
