package comp1110.ass2;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

import java.util.*;

public class ColourSquare {
    //public int column = 3;
    //public int row = 1;
    private static final int SQUARE_SIZE = 55;
    public Image image;
    public ImageView imageView;


    double[][] challengeSquareCoordinates = {{264.8, 168}, {334.4, 168}, {404.8, 168}, {264.8, 235.2}, {334.4, 235.2}, {404.8, 235.2}, {264.8, 304.8}, {334.4, 304.8}, {404.8, 304.8}};

    public Image ColourSquare(char challengeColor) {
        String squareImageUrl;
        Image pieceImage;
        //char[] colorCharacters = challenge.toCharArray();
        switch (challengeColor) {
            case 'R':
                squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-r.png";
                pieceImage = new Image(squareImageUrl);
                this.image = pieceImage;
                this.imageView = new ImageView(this.image);
                break;
            case 'G':
                squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-g.png";
                pieceImage = new Image(squareImageUrl);
                this.image = pieceImage;
                this.imageView = new ImageView(this.image);
                break;
            case 'B':
                squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-b.png";
                pieceImage = new Image(squareImageUrl);
                this.image = pieceImage;
                this.imageView = new ImageView(this.image);
                break;
            case 'W':
                squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-w.png";
                pieceImage = new Image(squareImageUrl);
                this.image = pieceImage;
                this.imageView = new ImageView(this.image);
                break;
        }
        this.imageView.setImage(this.image);
        this.imageView.setFitWidth(SQUARE_SIZE);
        this.imageView.setPreserveRatio(true);
        //this.imageView.setX(challengeSquareCoordinates[i][0]);
        //this.imageView.setY(challengeSquareCoordinates[i][1]);
        this.imageView.setSmooth(true);
        return this.image;
    }

}
