package ca.ulaval.glo4002.tennis.score;

import ca.ulaval.glo4002.tennis.Player;

public class AdvantageScore extends Score {

    public AdvantageScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public Boolean isApplicable() {
        return player1.hasAdvantageAgainst(player2) || player2.hasAdvantageAgainst(player1);
    }

    @Override
    public String toRepresentation() {
        return player1.hasAdvantageAgainst(player2) ? "Advantage player1" : "Advantage player2";
    }
}
