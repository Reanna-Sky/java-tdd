package qa.tennis;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {
    @Test
    public void testNewTennisScorerReturns0_0() {
        TennisScorer ts = new TennisScorer();
        assertTrue(ts.currentScore().startsWith("0:0"));
    }

    @Test
    public void testTennisScoreerReturns15_0ForIfPersonAWinsFirstPint() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("a");
        assertTrue(ts.currentScore().startsWith("15:0"));
    }

    @Test
    public void testTennisScoreerReturns0_15ForIfPersonBWinsFirstPint() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("b");
        assertTrue(ts.currentScore().startsWith("0:15"));
    }

    @Test
    public void testTennisScoreerReturns15_15FIfPersonAAndPersonBHaveWonAPointEach() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("a");
        ts.winningPoints("b");
        assertTrue(ts.currentScore().startsWith("15:15"));
    }

    @Test
    public void testTennisScoreerReturns30_15IfPersonAHas2PointsAndPersonBHas1Point() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("aba");

        assertTrue(ts.currentScore().startsWith("30:15"));
    }

    @Test
    public void testTennisScoreerReturns15_30IfPersonAHas1PointAndPersonBHas2Point() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abb");

        assertTrue(ts.currentScore().startsWith("15:30"));
    }

    @Test
    public void testTennisScoreerReturns30_30IfPersonAHas2PointsAndPersonBHas2Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abba");

        assertTrue(ts.currentScore().startsWith("30:30"));
    }

    @Test
    public void testTennisScoreerReturns40_30IfPersonAHas3PointsAndPersonBHas2Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaa");

        assertTrue(ts.currentScore().startsWith("40:30"));
    }

    @Test
    public void testTennisScoreerReturns40_40IfPersonAHas3PointsAndPersonBHas3Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaab");

        assertTrue(ts.currentScore().startsWith("40:40"));
    }

    @Test
    public void testTennisScoreerReturnsA_40IfPersonAHas4PointsAndPersonBHas3Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaaba");

        assertTrue(ts.currentScore().startsWith("A:40"));
    }

    @Test
    public void testTennisScoreerReturns40_40IfPersonAHas4PointsAndPersonBHas4Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaabab");

        assertTrue(ts.currentScore().startsWith("40:40"));
    }

    @Test
    public void testTennisScoreerReturnsA_40IfPersonAHas5PointsAndPersonBHas4Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaababa");

        assertTrue(ts.currentScore().startsWith("A:40"));
    }

    @Test
    @Ignore
    public void testTennisScoreerReturns1_0InGamesIfPersonaWinsFourPointsInRow() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("aaaa");

        assertTrue(ts.currentScore().startsWith("0:0"));
    }
}

