package qa.tennis;

public class TennisScorer {
	private Score score;
	private String previousString;
//    Final means its fixed. Static means there is only 1 no matter how many objects you create
    static final String[] scoring = {"0","15","30","40","A"};
    private static final int ADV = 4;
    private static final int FORTY = 3;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int ZERO = 0;


	public TennisScorer() {
		score = new Score();
		previousString = "";
	}
	
	public void winningPoint(char player) {
		winningPoints(String.valueOf(player));
	}
	
	public void winningPoints(String players) {
		previousString += players;
	}

    public void incrementGames(char player) {
        int currentSet = score.getCurrentSet();
        if (player == 'a' || player == 'A'){
            int[] playerAGamesScores = score.getPlayerAgames();
            switch(playerAGamesScores[currentSet]){
                case  0:
                    playerAGamesScores[currentSet] = 1;
                    break;
                case 1:
                    playerAGamesScores[currentSet] = 2;
                    break;
                case 2:
                    playerAGamesScores[currentSet] = 3;
                    break;
                case 3:
                    playerAGamesScores[currentSet] = 4;
                    break;
                case 4:
                    playerAGamesScores[currentSet] = 5;
                    break;
                case 5:
                    playerAGamesScores[currentSet] = 6;
                    break;
                case 6:
                    score.incrementCurrentSet();
            }
            score.setPlayerAgames(playerAGamesScores);
        }
        else {
            int[] playerBGamesScores = score.getPlayerBgames();
            switch (playerBGamesScores[currentSet]) {
                case 0:
                    playerBGamesScores[currentSet] = 1;
                    break;
                case 1:
                    playerBGamesScores[currentSet] = 2;
                    break;
                case 2:
                    playerBGamesScores[currentSet] = 3;
                    break;
                case 3:
                    playerBGamesScores[currentSet] = 4;
                    break;
                case 4:
                    playerBGamesScores[currentSet] = 5;
                    break;
                case 5:
                    playerBGamesScores[currentSet] = 6;
                    break;
                case 6:
                    score.incrementCurrentSet();
            }
            score.setPlayerBgames(playerBGamesScores);
        }
    } ;


	public String currentScore() {
        char[] winningSequence = previousString.toCharArray();
        int countA = 0;
        int countB = 0;

        for (char playerA : winningSequence) {
            if (playerA == 'a' || playerA == 'A') {
                if (countA == 0) {
                    countA++;
                } else if (countA == FIFTEEN) {
                    countA++;
                } else if (countA == THIRTY) {
                    countA++;
                } else if (countA == FORTY) {
                    if (countB < FORTY) {
                        //PLAYER A WINS
                        incrementGames('A');
                        previousString = "";
                    } else if (countB == FORTY) { //This would take countA to FORTY
                        countA++;
                    } else if (countB == ADV) {
                        countB = FORTY;
                    }
                } else {
                    //PLAYER A WINS
                    incrementGames('A');
                    previousString = "";
                }

            } else {
                if (countB == 0) {
                    countB++;
                } else if (countB == FIFTEEN) {
                    countB++;
                } else if (countB == THIRTY) {
                    countB++;
                } else if (countB == FORTY) {
                    if (countA < FORTY) {
                        //PLAYER B WINS
                        incrementGames('B');
                        previousString = "";
                    } else if (countA == FORTY) { //This would take countB to FORTY
                        countB++;
                    } else if (countA == ADV) {
                        countA = FORTY;
                    }
                } else {
                    //PLAYER B WINS
                    incrementGames('B');
                    previousString = "";
                }
            }
        }
        int[] playerADisplay = score.getPlayerAgames();
        int[] playerBDisplay = score.getPlayerBgames();
        return scoring[countA] + ":" + scoring[countB] + "\t" + playerADisplay[0] + "-" + playerBDisplay[0] + "  " + playerADisplay[1] + "-" + playerBDisplay[1] + "  " + playerADisplay[2] + "-" + playerBDisplay[2] + "  " + playerADisplay[3] + "-" + playerBDisplay[3] + "  " + playerADisplay[4] + "-" + playerBDisplay[4];
    }


	public Score getScore() {
		return score;
	}

	

}
