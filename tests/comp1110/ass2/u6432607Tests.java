package comp1110.ass2;

import org.junit.Test;
import static org.junit.Assert.*;

public class u6432607Tests {

    @Test
    public void testChallengeStringToArray() {
        SquareColour[] test1Array = {SquareColour.RED, SquareColour.WHITE, SquareColour.RED, SquareColour.BLUE, SquareColour.BLUE, SquareColour.WHITE, SquareColour.BLUE, SquareColour.BLUE, SquareColour.BLUE};
        SquareColour[] test2Array = {SquareColour.GREEN, SquareColour.GREEN, SquareColour.RED, SquareColour.BLUE, SquareColour.RED, SquareColour.RED, SquareColour.WHITE, SquareColour.WHITE, SquareColour.WHITE};
        assertEquals(FocusGame.challengeStringToChallengeData("RWRBBWBBB"), test1Array);
        assertEquals(FocusGame.challengeStringToChallengeData("GGRBRRWWW"), test2Array);
    }

    @Test
    public void pieceConfigurationTest() {
        int[][] test1Array = {
                {1, 1, 1},
                {0, 1, 0}
        };
        int[][] test2Array = {
                {0, 1},
                {0, 1},
                {1, 1}
        };
        int[][] test3Array = {
                {1, 0},
                {1, 1}
        };
        int[][] test4Array = {
                {1, 0},
                {1, 0},
                {1, 0},
                {1, 1}
        };
        assertEquals(FocusGame.pieceToConfiguration("a010"), test1Array);
        assertEquals(FocusGame.pieceToConfiguration("d431"), test2Array);
        assertEquals(FocusGame.pieceToConfiguration("i032"), test3Array);
        assertEquals(FocusGame.pieceToConfiguration("j123"), test4Array);
    }

}
