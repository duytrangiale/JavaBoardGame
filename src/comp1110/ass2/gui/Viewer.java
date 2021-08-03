package comp1110.ass2.gui;

import comp1110.ass2.Piece;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import comp1110.ass2.Piece;

/**
 * A very simple viewer for piece placements in the IQ-Focus game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int GAP_SIZE = 10;
    private static final int SQUARE_SIZE = 62;
    private static final int VIEWER_WIDTH = 840;
    private static final int VIEWER_HEIGHT = 600;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final List<ImageView> boardPieces = new ArrayList<>();
    private final Group controls = new Group();
    private TextField textField;

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer

        // Clear the board
        root.getChildren().removeAll(boardPieces);
        boardPieces.clear();

        // Isolate all pieces in the string
        Pattern pattern = Pattern.compile("(....)");
        Matcher matcher = pattern.matcher(placement);

        // Loop through all pieces
        while (matcher.find()) {

            // Generate dictionary of width and height of each piece
            Dictionary<Character, List<Integer>> pieceDimensions = new Hashtable<>();
            pieceDimensions.put('a', Arrays.asList(3*SQUARE_SIZE, 2*SQUARE_SIZE));
            pieceDimensions.put('b', Arrays.asList(4*SQUARE_SIZE, 2*SQUARE_SIZE));
            pieceDimensions.put('c', Arrays.asList(4*SQUARE_SIZE, 2*SQUARE_SIZE));
            pieceDimensions.put('d', Arrays.asList(3*SQUARE_SIZE, 2*SQUARE_SIZE));
            pieceDimensions.put('e', Arrays.asList(3*SQUARE_SIZE, 2*SQUARE_SIZE));
            pieceDimensions.put('f', Arrays.asList(3*SQUARE_SIZE, SQUARE_SIZE));
            pieceDimensions.put('g', Arrays.asList(3*SQUARE_SIZE, 2*SQUARE_SIZE));
            pieceDimensions.put('h', Arrays.asList(3*SQUARE_SIZE, 3*SQUARE_SIZE));
            pieceDimensions.put('i', Arrays.asList(2*SQUARE_SIZE, 2*SQUARE_SIZE));
            pieceDimensions.put('j', Arrays.asList(4*SQUARE_SIZE, 2*SQUARE_SIZE));

            // Get a hold of the piece string
            String pieceString = matcher.group(1);
            System.out.println(pieceString);

            // Initialise piece for piece string
            Piece piece = new Piece(pieceString);

            List<Integer> dimensions = pieceDimensions.get(piece.shape);
            Integer pieceWidth = dimensions.get(0);
            Integer pieceHeight = dimensions.get(1);

            // Size piece image correctly
            piece.imageView.setFitWidth(pieceWidth);
            piece.imageView.setPreserveRatio(true);

            int boardOffsetX = 60;
            int boardOffsetY = 95;
            int pieceX = boardOffsetX + (GAP_SIZE*piece.column) + (piece.column*60);
            int pieceY = boardOffsetY + (GAP_SIZE*piece.row) + (piece.row*60);

            // Rotate piece
            Rotate rotation = new Rotate();
            rotation.setAngle(piece.rotation);
            rotation.setPivotX(pieceX);
            rotation.setPivotY(pieceY);
            piece.imageView.getTransforms().add(rotation);

            // Change location of piece
            switch(piece.rotation) {
                case 90:
                    piece.imageView.setX(pieceX);
                    piece.imageView.setY(pieceY-pieceHeight);
                    break;
                case 180:
                    piece.imageView.setX(pieceX-pieceWidth);
                    piece.imageView.setY(pieceY-pieceHeight);
                    break;
                case 270:
                    piece.imageView.setX(pieceX-pieceWidth);
                    piece.imageView.setY(pieceY);
                    break;
                default:
                    piece.imageView.setX(pieceX);
                    piece.imageView.setY(pieceY);
                    break;
            }

            // Add piece to board pieces group
            boardPieces.add(piece.imageView);

            // Add piece to the view
            root.getChildren().add(piece.imageView);
        }

    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FocusGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        // Load an board image
        String boardImageUrl = "file:assets/board.png";
        Image boardImage = new Image(boardImageUrl);

        // Create the ImageView for board image
        ImageView boardImageView = new ImageView(boardImage);

        // Add board to the screen
        root.getChildren().add(boardImageView);

        makeControls();
        root.getChildren().add(controls);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
