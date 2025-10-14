package qa.tennis;

public class TennisScorer {
	private Score score;
	private String previousString;
//    Final is its fixed. Static means there is only 1 no matter how many objects you create
    static final String[] scoring = {"0","15","30","40","A"};

	public TennisScorer() {
		score = new Score();
		previousString = "";
	}
	
	public void winningPoint(char player) {
		winningPoints(String.valueOf(player));
	}
	
	public void winningPoints(String players) {
		previousString += players;
//        previousString = aababbababa

	}



	public String currentScore() {
		char[] winningSequence = previousString.toCharArray();
		int countA = 0;
        int countB = 0;

        for (char playerA : winningSequence ){
            if (playerA == 'a' || playerA == 'A'){
                ++countA;
            }
            else {
                countB++;
            }
        }

        if (countA > 3 && countB > 3 && countA == countB) {

            return "40:40";
        } else if (countA > 3 && countB > 3 && countA > countB) {
            return "A:40";

        }else if (countA > 3 && countB > 3 && countA < countB){
            return "40:A";
        }

        String result = scoring[countA] + ":" + scoring[countB];
		return result;
	}

	public Score getScore() {
		return score;
	}
	
	

}
