package ca.ulaval.glo4002.tennis.score;

import java.util.TreeMap;

import ca.ulaval.glo4002.tennis.Player;

public class TieScore extends Score {

    private static final TreeMap<Integer, String> scoreNames = new TreeMap<Integer, String>() {{
        put(0, "Love-All");
        put(1, "Fifteen-All");
        put(2, "Thirty-All");
        put(3, "Deuce");
    }};

    public TieScore(Player player1, Player player2) {
        super(player1, player2);
    }

    public Boolean isApplicable() {
        return player1.isInATieWith(player2);
    }

    public String toRepresentation() {
        return scoreNames.getOrDefault(
                scoreNames.floorKey(player1.getScore()),
                scoreNames.firstEntry().getValue());
    }
}
