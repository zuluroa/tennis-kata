
public class TennisGame3 implements TennisGame {

    private int player2Point;
    private int player1Point;
    private String player1Name;
    private String player2Name;
    private final String[] words = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String p1N, String p2N) {
        this.player1Name = p1N;
        this.player2Name = p2N;
    }

    public String getScore() {
        String score = "";
        if (islessNumbers(player1Point, 4) && islessNumbers(player2Point, 4) && !isEqualsNumbers(add(player1Point, player2Point), 6)){
            score = words[player1Point];
            return playerScore(score);
        }

        if (isEqualsNumbers(player1Point, player2Point)){
            return "Deuce";
        }

        score = isGreaterNumber(player1Point,player2Point) ? player1Name : player2Name;

        return advantageAndWin(score);
    }

    private String playerScore(String score) {
        String All = (isEqualsNumbers(player1Point, player2Point)) ? score + "-All" : score + "-" + words[player2Point];
        return All;

    }

    private String advantageAndWin(String score) {
        String winner = isEqualsNumbers(multiplication(player1Point - player2Point, player1Point - player2Point), 1) ? "Advantage " + score : "Win for " + score;
        return winner;
    }

    private int multiplication(int number1, int number2) {
        return number1 * number2;
    }

    private int add(int number1, int number2) {
        return number1 + number2;
    }

    private boolean isEqualsNumbers(int number1, int number2) {
        return number1 == number2;
    }

    private boolean isGreaterNumber(int number1, int number2) {
        return number1 >= number2;
    }

    private boolean islessNumbers(int number1, int number2) {
        return number1 < number2;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Point += 1;
        else
            player2Point += 1;

    }

}
