package ca.ulaval.glo4002.tennis;


import java.util.Arrays;
import java.util.List;

import ca.ulaval.glo4002.tennis.score.AdvantageScore;
import ca.ulaval.glo4002.tennis.score.NormalScore;
import ca.ulaval.glo4002.tennis.score.Score;
import ca.ulaval.glo4002.tennis.score.TieScore;
import ca.ulaval.glo4002.tennis.score.WinScore;

public class RefactoredTennisGame implements TennisGame {

    private final Player player1;
    private final Player player2;
    private final List<Score> allPossibleScores;

    public RefactoredTennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.allPossibleScores = Arrays.asList(
                new TieScore(player1, player2),
                new NormalScore(player1, player2),
                new AdvantageScore(player1, player2),
                new WinScore(player1, player2)
        );
    }

    public void wonPoint(String playerName) {
        Player player = getPlayerByName(playerName);
        player.wonPoint();
    }

    private Player getPlayerByName(String playerName) {
        return player1.isCalled(playerName) ? player1 : player2;
    }

    public String getScore() {
        return allPossibleScores.stream()
                .filter(Score::isApplicable)
                .map(Score::toRepresentation)
                .reduce(String::concat)
                .orElse("");
    }
}
