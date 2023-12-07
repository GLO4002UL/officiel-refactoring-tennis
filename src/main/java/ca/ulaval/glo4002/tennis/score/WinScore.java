package ca.ulaval.glo4002.tennis.score;

import ca.ulaval.glo4002.tennis.Player;

public class WinScore extends Score {

    public WinScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isApplicable() {
        return player1.hasWonAgainst(player2) || player2.hasWonAgainst(player1);
    }

    @Override
    public String toRepresentation() {
        return player1.hasWonAgainst(player2) ? "Win for player1" : "Win for player2";
    }
}
