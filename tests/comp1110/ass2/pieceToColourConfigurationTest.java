package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

public class pieceToColourConfigurationTest {
    Random rand = new Random();
    char[] character = {'a','b','c','d','e','f','g','h','i'};

    SquareColour[][][] a = {{
            {SquareColour.GREEN, SquareColour.WHITE, SquareColour.RED},
            {null, SquareColour.RED, null}
    }, {
            {null, SquareColour.GREEN},
            {SquareColour.RED, SquareColour.WHITE},
            {null, SquareColour.RED}
    }, {
            {null, SquareColour.RED, null},
            {SquareColour.RED, SquareColour.WHITE, SquareColour.GREEN}
    }, {
            {SquareColour.RED, null},
            {SquareColour.WHITE, SquareColour.RED},
            {SquareColour.GREEN, null}
    }};

    SquareColour[][][] b = {{
            {null, SquareColour.BLUE, SquareColour.GREEN, SquareColour.GREEN},
            {SquareColour.WHITE, SquareColour.WHITE, null, null}
    }, {
            {SquareColour.WHITE, null},
            {SquareColour.WHITE, SquareColour.BLUE},
            {null, SquareColour.GREEN},
            {null, SquareColour.GREEN}
    }, {
            {null, null, SquareColour.WHITE, SquareColour.WHITE},
            {SquareColour.GREEN, SquareColour.GREEN, SquareColour.BLUE, null}
    }, {
            {SquareColour.GREEN, null},
            {SquareColour.GREEN, null},
            {SquareColour.BLUE, SquareColour.WHITE},
            {null, SquareColour.WHITE}
    }};

    SquareColour[][][] c= {{
            {null, null, SquareColour.GREEN, null},
            {SquareColour.RED, SquareColour.RED, SquareColour.WHITE, SquareColour.BLUE}
    }, {
            {SquareColour.RED, null},
            {SquareColour.RED, null},
            {SquareColour.WHITE, SquareColour.GREEN},
            {SquareColour.BLUE, null}
    }, {
            {SquareColour.BLUE, SquareColour.WHITE, SquareColour.RED, SquareColour.RED},
            {null, SquareColour.GREEN, null, null}
    }, {
            {null, SquareColour.BLUE},
            {SquareColour.GREEN, SquareColour.WHITE},
            {null, SquareColour.RED},
            {null, SquareColour.RED}
    }};



    SquareColour[][][] d = {{
            {SquareColour.RED, SquareColour.RED, SquareColour.RED},
            {null, null, SquareColour.BLUE}
    }, {
            {null, SquareColour.RED},
            {null, SquareColour.RED},
            {SquareColour.BLUE, SquareColour.RED}
    }, {
            {SquareColour.BLUE, null, null},
            {SquareColour.RED, SquareColour.RED, SquareColour.RED}
    }, {
            {SquareColour.RED, SquareColour.BLUE},
            {SquareColour.RED, null},
            {SquareColour.RED, null}
    }};


    SquareColour[][][] e = {{
            {SquareColour.BLUE, SquareColour.BLUE, SquareColour.BLUE},
            {SquareColour.RED, SquareColour.RED, null}
    }, {
            {SquareColour.RED, SquareColour.BLUE},
            {SquareColour.RED, SquareColour.BLUE},
            {null, SquareColour.BLUE}
    }, {
            {null, SquareColour.RED, SquareColour.RED},
            {SquareColour.BLUE, SquareColour.BLUE, SquareColour.BLUE}
    }, {
            {SquareColour.BLUE, null},
            {SquareColour.BLUE, SquareColour.RED},
            {SquareColour.BLUE, SquareColour.RED}
    }};


    SquareColour[][][] f = {{
            {SquareColour.WHITE, SquareColour.WHITE, SquareColour.WHITE},
    }, {
            {SquareColour.WHITE},
            {SquareColour.WHITE},
            {SquareColour.WHITE}
    }, {
            {SquareColour.WHITE, SquareColour.WHITE, SquareColour.WHITE}
    }, {
            {SquareColour.WHITE},
            {SquareColour.WHITE},
            {SquareColour.WHITE}
    }};


    SquareColour[][][] g = {{
            {SquareColour.WHITE, SquareColour.BLUE, null},
            {null, SquareColour.BLUE, SquareColour.WHITE}
    }, {
            {null, SquareColour.WHITE},
            {SquareColour.BLUE, SquareColour.BLUE},
            {SquareColour.WHITE, null}
    }, {
            {SquareColour.WHITE, SquareColour.BLUE, null},
            {null, SquareColour.BLUE, SquareColour.WHITE}
    }, {
            {null, SquareColour.WHITE},
            {SquareColour.BLUE, SquareColour.BLUE},
            {SquareColour.WHITE, null}
    }};


    SquareColour[][][] h = {{
            {SquareColour.RED, SquareColour.GREEN, SquareColour.GREEN},
            {SquareColour.WHITE, null, null},
            {SquareColour.WHITE, null, null}
    }, {
            {SquareColour.WHITE, SquareColour.WHITE, SquareColour.RED},
            {null, null, SquareColour.GREEN},
            {null, null, SquareColour.GREEN}
    }, {
            {null, null, SquareColour.WHITE},
            {null, null, SquareColour.WHITE},
            {SquareColour.GREEN, SquareColour.GREEN, SquareColour.RED}
    }, {
            {SquareColour.GREEN, null, null},
            {SquareColour.GREEN, null, null},
            {SquareColour.RED, SquareColour.WHITE, SquareColour.WHITE}
    }};


    SquareColour[][][] i = {{
            {SquareColour.BLUE, SquareColour.BLUE},
            {null, SquareColour.WHITE}
    }, {
            {null, SquareColour.BLUE},
            {SquareColour.WHITE, SquareColour.BLUE}
    }, {
            {SquareColour.WHITE, null},
            {SquareColour.BLUE, SquareColour.BLUE}
    }, {
            {SquareColour.BLUE, SquareColour.WHITE},
            {SquareColour.BLUE, null}
    }};


    SquareColour[][][] j = {{
            {SquareColour.GREEN, SquareColour.GREEN, SquareColour.WHITE, SquareColour.RED},
            {SquareColour.GREEN, null, null, null}
    }, {
            {SquareColour.GREEN, SquareColour.GREEN},
            {null, SquareColour.GREEN},
            {null, SquareColour.WHITE},
            {null, SquareColour.RED}
    }, {
            {null, null, null, SquareColour.GREEN},
            {SquareColour.RED, SquareColour.WHITE, SquareColour.GREEN, SquareColour.GREEN}
    }, {
            {SquareColour.RED, null},
            {SquareColour.WHITE, null},
            {SquareColour.GREEN, null},
            {SquareColour.GREEN, SquareColour.GREEN}
    }};


    @Test
    public void test(){
        int x = rand.nextInt(9);
        int y = rand.nextInt(5);
        int z = rand.nextInt(4);
        char cha = character[rand.nextInt(10)];
        String str = ""+ cha + x + y + z;
        SquareColour[][] expect= new SquareColour[5][5];
        switch(cha){
            case 'a': expect = a[z];break;
            case 'b': expect = b[z];break;
            case 'c': expect = c[z];break;
            case 'd': expect = d[z];break;
            case 'e': expect = e[z];break;
            case 'f': expect = f[z];break;
            case 'g': expect = g[z];break;
            case 'h': expect = h[z];break;
            case 'i': expect = i[z];break;
        }
        SquareColour[][] result = FocusGame.pieceToColourConfiguration(str);
        assertTrue("Wrong", Arrays.deepEquals(result,expect));
    }
}

