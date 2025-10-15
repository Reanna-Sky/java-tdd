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



	public String currentScore() {
        char[] winningSequence = previousString.toCharArray();
        int countA = 0;
        int countB = 0;

        for (char playerA : winningSequence) {
            if (playerA == 'a' || playerA == 'A') {
                ++countA;
            } else {
                countB++;
            }
        }

        String result = "";
        if (countA < 4 && countB < 4) { //This prints results up to 40:40
            result += scoring[countA] + ":" + scoring[countB];
        }

        else if (countA == 4 && countB < 3) { //this is when player a wins
           result += "0:0";

        } else if (countA > 3 && countB  == 3){
            return "A:40";

        } else if (countA == 3 && countB >3 ) {
            return "40:A";

        } else  if (countA > 3 && countB > 3) {
            if (countA == countB) {
                return "40:40";
            } else if (countA > countB) {
                return "A:40";
            } else {
                return "40:A";
            }
        }

//        String result = scoring[countA] + ":" + scoring[countB];
		return result;
	}

	public Score getScore() {
		return score;
	}
	
	

}
