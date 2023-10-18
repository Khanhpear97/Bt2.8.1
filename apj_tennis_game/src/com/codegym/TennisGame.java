package apj_tennis_game.src.com.codegym;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore = 0;
        boolean player1ScoreEqualPlayer2Score = player1Score == player2Score;
        boolean onePlayerGet4Point = player1Score >= 4 || player2Score >= 4;

        if (player1ScoreEqualPlayer2Score) {
            score = scoreDeuce(player1Score);
        }
        else if (onePlayerGet4Point) {
                score = checkWin(player1Score, player2Score);
        }
        else {
            score = checkPlayerScore(player1Score, player2Score, score);
        }
        return score;
    }

    private static String checkPlayerScore(int player1Score, int player2Score, String score) {
        int tempScore;
        for (int i = 1; i<3; i++) {
            if (i==1) tempScore = player1Score;
            else {
                score +="-";
                tempScore = player2Score;
            }
            switch(tempScore) {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private static String checkWin(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String scoreDeuce(int player1Score) {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}