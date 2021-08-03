package comp1110.ass2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Piece {

    public int orientation;
    public int rotation;
    public int column;
    public int row;
    public int x;
    public int y;
    public char shape;
    public Image image;
    public ImageView imageView;
    public int[][] configuration;

    public Piece(String pieceString) {

        int offset_x = 60;
        int offset_y = 95;

        // Populate fields
        this.shape = pieceString.charAt(0);
        this.column = Character.getNumericValue(pieceString.charAt(1));
        this.row = Character.getNumericValue(pieceString.charAt(2));
        this.x = offset_x + (column * 60);
        this.y = offset_y + (row * 60);
        this.orientation = Character.getNumericValue(pieceString.charAt(3));
        this.rotation = 90*this.orientation;

        // Create piece image
        String pieceImageUrl = "file:src/comp1110/ass2/gui/assets/"+this.shape+".png";
        Image pieceImage = new Image(pieceImageUrl);
        this.image = pieceImage;
        this.imageView = new ImageView(this.image);

        // Determine configuration of piece
        int[][][] a_config = {{
                {1, 1, 1},
                {0, 1, 0}
        }, {
                {0, 1},
                {1, 1},
                {0, 1}
        }, {
                {0, 1, 0},
                {1, 1, 1}
        }, {
                {1, 0},
                {1, 1},
                {1, 0}
        }};

        int[][][] b_config = {{
                {0, 1, 1, 1},
                {1, 1, 0, 0}
        }, {
                {1, 0},
                {1, 1},
                {0, 1},
                {0, 1}
        }, {
                {0, 0, 1, 1},
                {1, 1, 1, 0}
        }, {
                {1, 0},
                {1, 0},
                {1, 1},
                {0, 1}
        }};

        int[][][] c_config = {{
                {0, 0, 1, 0},
                {1, 1, 1, 1}
        }, {
                {1, 0},
                {1, 0},
                {1, 1},
                {1, 0}
        }, {
                {1, 1, 1, 1},
                {0, 1, 0, 0}
        }, {
                {0, 1},
                {1, 1},
                {0, 1},
                {0, 1}
        }};

        int[][][] d_config = {{
                {1, 1, 1},
                {0, 0, 1}
        }, {
                {0, 1},
                {0, 1},
                {1, 1}
        }, {
                {1, 0, 0},
                {1, 1, 1}
        }, {
                {1, 1},
                {1, 0},
                {1, 0}
        }};

        int[][][] e_config = {{
                {1, 1, 1},
                {1, 1, 0}
        }, {
                {1, 1},
                {1, 1},
                {0, 1}
        }, {
                {0, 1, 1},
                {1, 1, 1}
        }, {
                {1, 0},
                {1, 1},
                {1, 1}
        }};

        int[][][] f_config = {{
                {1, 1, 1},
        }, {
                {1},
                {1},
                {1}
        }, {
                {1, 1, 1}
        }, {
                {1},
                {1},
                {1}
        }};

        int[][][] g_config = {{
                {1, 1, 0},
                {0, 1, 1}
        }, {
                {0, 1},
                {1, 1},
                {1, 0}
        }, {
                {1, 1, 0},
                {0, 1, 1}
        }, {
                {0, 1},
                {1, 1},
                {1, 0}
        }};

        int[][][] h_config = {{
                {1, 1, 1},
                {1, 0, 0},
                {1, 0, 0}
        }, {
                {1, 1, 1},
                {0, 0, 1},
                {0, 0, 1}
        }, {
                {0, 0, 1},
                {0, 0, 1},
                {1, 1, 1}
        }, {
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1}
        }};

        int[][][] i_config = {{
                {1, 1},
                {0, 1}
        }, {
                {0, 1},
                {1, 1}
        }, {
                {1, 0},
                {1, 1}
        }, {
                {1, 1},
                {1, 0}
        }};

        int[][][] j_config = {{
                {1, 1, 1, 1},
                {1, 0, 0, 0}
        }, {
                {1, 1},
                {0, 1},
                {0, 1},
                {0, 1}
        }, {
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        }, {
                {1, 0},
                {1, 0},
                {1, 0},
                {1, 1}
        }};

        switch (this.shape) {
            case 'a' : this.configuration = a_config[this.orientation];
            case 'b' : this.configuration = b_config[this.orientation];
            case 'c' : this.configuration = c_config[this.orientation];
            case 'd' : this.configuration = d_config[this.orientation];
            case 'e' : this.configuration = e_config[this.orientation];
            case 'f' : this.configuration = f_config[this.orientation];
            case 'g' : this.configuration = g_config[this.orientation];
            case 'h' : this.configuration = h_config[this.orientation];
            case 'i' : this.configuration = i_config[this.orientation];
            case 'j' : this.configuration = j_config[this.orientation];
        }

    }

}
