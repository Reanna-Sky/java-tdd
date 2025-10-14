package qa.tennis;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {
    @Test
    public void testNewTennisScorerReturns0_0() {
        TennisScorer ts = new TennisScorer();
        assertEquals("0:0", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns15_0ForIfPersonAWinsFirstPint() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("a");
        assertEquals("15:0", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns0_15ForIfPersonBWinsFirstPint() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("b");
        assertEquals("0:15", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns15_15FIfPersonAAndPersonBHaveWonAPointEach() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("a");
        ts.winningPoints("b");
        assertEquals("15:15", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns30_15IfPersonAHas2PointsAndPersonBHas1Point() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("aba");

        assertEquals("30:15", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns15_30IfPersonAHas1PointAndPersonBHas2Point() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abb");

        assertEquals("15:30", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns30_30IfPersonAHas2PointsAndPersonBHas2Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abba");

        assertEquals("30:30", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns40_30IfPersonAHas3PointsAndPersonBHas2Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaa");

        assertEquals("40:30", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns40_40IfPersonAHas3PointsAndPersonBHas3Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaab");

        assertEquals("40:40", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturnsA_40IfPersonAHas4PointsAndPersonBHas3Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaaba");

        assertEquals("A:40", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturns40_40IfPersonAHas4PointsAndPersonBHas4Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaabab");

        assertEquals("40:40", ts.currentScore());
    }

    @Test
    public void testTennisScoreerReturnsA_40IfPersonAHas5PointsAndPersonBHas4Points() {
        TennisScorer ts = new TennisScorer();
        ts.winningPoints("abbaababa");

        assertEquals("A:40", ts.currentScore());
    }


}