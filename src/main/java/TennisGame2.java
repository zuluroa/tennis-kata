
public class TennisGame2 implements TennisGame
{
    private int player1Point = 0;
    private int player2Point = 0;

    private String player1Score = "";
    private String player2Score = "";
    private final String[] words = {"Fifteen","Thirty","Forty","Love"};
    private String score = "";
    final String player1Name;
    final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        equalsAndLessFour(isEqualsNumbers(player1Point, player2Point), isLessNumber(player1Point, 4), validateEqualsScore(score));
        equalsAndLessFour(isEqualsNumbers(player1Point, player2Point), isGreaterThanNumber(player1Point,3), "Deuce");
        responseValidate();
        validateP1AndP2Point();
        equalsAndLessFour(isGreaterNumber(player1Point, player2Point), isGreaterThanNumber(player2Point,3), "Advantage player1");
        equalsAndLessFour(isGreaterNumber(player2Point, player1Point), isGreaterThanNumber(player1Point,3), "Advantage player2");
        winPlayer();
        return score;
    }

    private void winPlayer() {
        if (isGreaterThanNumber(player1Point,4) && isGreaterThanNumber(player2Point,0) && isGreaterThanNumber (player1Point - player2Point,2))
        {
            score = "Win for player1";
        }
        if (isGreaterThanNumber(player2Point,4) && isGreaterThanNumber(player1Point,0)  && isGreaterThanNumber(player2Point - player1Point,2))
        {
            score = "Win for player2";
        }
    }

    private void validateP1AndP2Point() {
        if (isGreaterNumber(player1Point, player2Point) && isLessNumber(player1Point,4))
        {
            validatePointsFour();
        }
        if (isGreaterNumber(player2Point, player1Point)&& isLessNumber(player2Point,4))
        {
            validatePointsFourP2();
        }
    }

    private void responseValidate() {
        if (isGreaterNumber(player1Point,0) && isEqualsNumbers(player2Point,0))
        {
            player1Score = validatePoints(player1Point);
            player2Score = words[3];
            score = player1Score + "-" + player2Score;
        }
        if ( isGreaterNumber(player2Point,0) && isEqualsNumbers(player1Point,0))
        {
            player2Score = validatePoints(player2Point);
            player1Score = words[3];
            score = player1Score + "-" + player2Score;
        }
    }

    private void equalsAndLessFour(boolean equalsNumbers, boolean lessNumber, String message) {
        if (equalsNumbers && lessNumber) {
            score = message;
        }
    }

    private void validatePointsFourP2() {
        if (isEqualsNumbers(player2Point,2))
            player2Score = words[1];
        if (isEqualsNumbers(player2Point,3))
            player2Score = words[2];
        if (isEqualsNumbers(player1Point,1))
            player1Score = words[0];
        if (isEqualsNumbers(player1Point,2))
            player1Score = words[1];
        score = player1Score + "-" + player2Score;
    }

    private void validatePointsFour() {
        if (isEqualsNumbers(player1Point,2))
            player1Score = words[1];
        if (isEqualsNumbers(player1Point,3))
            player1Score = words[2];
        if (isEqualsNumbers(player2Point,1))
            player2Score = words[0];
        if (isEqualsNumbers(player2Point,2))
            player2Score = words[1];
        score = player1Score + "-" + player2Score;
    }

    private String validatePoints(int number) {
        if(isGreaterThanNumber(number,0) && isLessNumber(number,4)){
            return words[number-1];
        }
        return "";
    }

    private String validateEqualsScore(String score) {
        if (isEqualsNumbers(player1Point,0))
            score = words[3];
        if (isEqualsNumbers(player1Point,1))
            score = words[0];
        if (isEqualsNumbers(player1Point,2))
            score = words[1];
        score += "-All";
        return score;
    }

    private boolean isGreaterThanNumber(int number1, int number2) {
        return number1 >=number2;
    }

    private boolean isGreaterNumber(int number1, int number2) {
        return number1 >number2;
    }

    private boolean isLessNumber(int number1, int number2) {
        return number1 <number2;
    }

    private boolean isEqualsNumbers(int number1, int number2) {
        return number1 ==number2;
    }

    public int incrementValue(int value ){
        return  value+1;
    }


    public void wonPoint(String player) {
        if (player.equalsIgnoreCase("player1"))
            player1Point = incrementValue(player1Point);
        else
            player2Point = incrementValue(player2Point);
    }
}