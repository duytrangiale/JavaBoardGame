package comp1110.ass2.gui;

import comp1110.ass2.FocusGame;
import comp1110.ass2.Piece;
import comp1110.ass2.SquareColour;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

import java.util.*;

/**
 * @author Jaxon   u6432607
 */
public class GameWindow extends Scene {

    // CLASS PROPERTIES
    public Scene scene;
    public Stage parent;
    public double width;
    public double height;
    private static final int GAP_SIZE = 12;
    private static final int SQUARE_SIZE = 52;
    private Placement placement;
    private String challenge = "WRGRRBRBR";

    class Placement {

        ArrayList<Piece> pieces;

        public Placement() {
            pieces = new ArrayList<>();
        }

        /**
         * Checks if piece already on the board - if so, remove it
         */
        private void reconfigureBoardForPiece(Piece piece1) {
            for (int i = 0; i < pieces.size(); i++) {
                Piece piece = pieces.get(i);
                if (piece.shape == piece1.shape) {
                    pieces.remove(i);
                    break;
                }
            }
        }

        /**
         * Checks if the placement meets the challenge solution
         */
        public Boolean challangeComplete() {
            if (FocusGame.getSolution(challenge) == placementString()) {
                return true;
            }
            return false;
        }

        public Boolean addPiece(Piece piece) {
            reconfigureBoardForPiece(piece);
            ArrayList<Piece> tmp_pieces = new ArrayList<>(pieces);
            pieces.add(piece);
            if (FocusGame.isPlacementStringValid(placementString())) {
                return true;
            }
            pieces = tmp_pieces;
            return false;
        }

        /**
         * Generates a placement string given the current pieces on the board
         */
        public String placementString() {
            String result = "";
            for (int i = 0; i < pieces.size(); i++) {
                Piece piece = pieces.get(i);
                String piecePlacement = "";
                piecePlacement += Character.toString(piece.shape) + Integer.toString(piece.column) + Integer.toString(piece.row) + Integer.toString(piece.orientation);
                result += piecePlacement;
            }
            return result;
        }

    }

    public GameWindow(double width, double height, Stage parent, String challenge) {
        super(new Group(), width, height);
        this.width = width;
        this.height = height;
        this.parent = parent;
        this.challenge = challenge;
        this.placement = new Placement();
        this.initialise();
    }

    private class GamePiece {

        public char shape;
        public int orientation;
        public ImageView imageView;
        public String pieceString;
        public int initialX;
        public int initialY;
        double originalSceneX, originalSceneY;
        double originalTranslateX, originalTranslateY;
        public int topPadding = 470;
        private Boolean dragged = false;

        public void rotate() {
            orientation = (orientation + 1)%4;
            imageView.setRotate(imageView.getRotate()+90);
        }

        /**
         * Gets board copordinates based on piece x and y on stage
         */
        public double[] boardLocation() {
            double currentX = imageView.getX()+imageView.getTranslateX();
            double currentY = imageView.getY()+imageView.getTranslateY();
            int boardOffsetX = 60;
            int boardOffsetY = 88;
            int x = ((int) (currentX-boardOffsetX)/SQUARE_SIZE);
            if (x < 0) {
                x = 0;
            }
            if (x > 8) {
                x = 8;
            }
            int y = ((int) (currentY-boardOffsetY)/SQUARE_SIZE);
            if (y < 0) {
                y = 0;
            }
            if (y > 4) {
                y = 4;
            }
            System.out.println("("+Integer.toString(x) + ", " + Integer.toString(y)+")");
            double[] result = {x, y};
            return result;
        }

        public GamePiece(char shape, int initialX, int initialY) {
            this.shape = shape;
            this.orientation = 0;
            this.initialX = initialX;
            this.initialY = initialY;
            this.pieceString = Character.toString(shape) + "000";
            String shapeImageString = "file:src/comp1110/ass2/gui/assets/"+shape+".png";
            Image shapeImage = new Image(shapeImageString);
            this.imageView = new ImageView(shapeImage);

            this.imageView.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    originalSceneX = event.getSceneX();
                    originalSceneY = event.getSceneY();
                    originalTranslateX = imageView.getTranslateX();
                    originalTranslateY = imageView.getTranslateY();
                    event.consume();
                }
            });

            // Action when shape clicked
            this.imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    event.consume();
                }
            });

            // Action when shape clicked
            this.imageView.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    // Check if piece is dragged
                    if (!dragged) {
                        rotate();
                    } else {
                        dragged = false;
                    }

                    double[] newLocation = boardLocation();
                    int x = (int) newLocation[0];
                    int y = (int) newLocation[1];
                    String pieceString = Character.toString(shape) + Integer.toString(x) + Integer.toString(y) + Integer.toString(orientation);
                    Piece piece = new Piece(pieceString);

                    if (placement.addPiece(piece)) {

                        // VALID MOVE

                        // Position piece
                        int boardOffsetX = 60;
                        int boardOffsetY = 88;
                        double pieceX = boardOffsetX + (GAP_SIZE*x) + (x*SQUARE_SIZE);
                        double pieceY = boardOffsetY + (GAP_SIZE*y) + (y*SQUARE_SIZE);
                        imageView.setX(pieceX);
                        imageView.setY(pieceY);
                        imageView.setTranslateX(0);
                        imageView.setTranslateY(0);
                        originalSceneX = 0;
                        originalSceneY = 0;
                        originalTranslateX = 0;
                        originalTranslateY = 0;


                    } else {

                        // INVALID MOVE

                        // Reposition piece
                        imageView.setTranslateX(0);
                        imageView.setTranslateY(0);
                        imageView.setX(initialX);
                        imageView.setY(initialY);
                        originalSceneX = 0;
                        originalSceneY = 0;
                        originalTranslateX = 0;
                        originalTranslateY = 0;

                    }
                    System.out.println(placement.placementString());
                    event.consume();
                }
            });

            // Action when shape is dragged
            this.imageView.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    dragged = true;
                    double offsetX = event.getSceneX() - originalSceneX;
                    double offsetY = event.getSceneY() - originalSceneY;
                    double newTranslateX = originalTranslateX + offsetX;
                    double newTranslateY = originalTranslateY + offsetY;

                    imageView.setTranslateX(newTranslateX);
                    imageView.setTranslateY(newTranslateY);

                    event.consume();
                }
            });

            // Shape image view and add to array
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

            // Size piece
            this.imageView.setFitWidth(pieceDimensions.get(shape).get(0));
            this.imageView.setFitHeight(pieceDimensions.get(shape).get(1));

        }

    }

    public void initialise() {

        // Load an board image
        String boardImageUrl = "file:assets/board.png";
        Image boardImage = new Image(boardImageUrl);

        // Create the ImageView for board image
        ImageView boardImageView = new ImageView(boardImage);
        boardImageView.setFitWidth(650);
        boardImageView.setPreserveRatio(true);

        // Create quit button
        Button quit_button = new Button("QUIT");
        quit_button.setPrefHeight(50);
        quit_button.setPrefWidth(200);
        quit_button.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
        quit_button.setTextFill(Color.BLACK);
        quit_button.setLayoutX(725);
        quit_button.setLayoutY(10);
        // add action event for when button clicked
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                MenuWindow menu = new MenuWindow(width, height, parent, 'j');
                parent.setScene(menu.scene);
            }
        };
        quit_button.setOnAction(event);

        // Challenge group generation
        int size = 50;
        ImageView square1 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(0)))+".png"));
        square1.setFitWidth(size);
        square1.setPreserveRatio(true);
        ImageView square2 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(1)))+".png"));
        square2.setFitWidth(size);
        square2.setPreserveRatio(true);
        ImageView square3 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(2)))+".png"));
        square3.setFitWidth(size);
        square3.setPreserveRatio(true);
        ImageView square4 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(3)))+".png"));
        square4.setFitWidth(size);
        square4.setPreserveRatio(true);
        ImageView square5 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(4)))+".png"));
        square5.setFitWidth(size);
        square5.setPreserveRatio(true);
        ImageView square6 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(5)))+".png"));
        square6.setFitWidth(size);
        square6.setPreserveRatio(true);
        ImageView square7 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(6)))+".png"));
        square7.setFitWidth(size);
        square7.setPreserveRatio(true);
        ImageView square8 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(7)))+".png"));
        square8.setFitWidth(size);
        square8.setPreserveRatio(true);
        ImageView square9 = new ImageView(new Image("file:src/comp1110/ass2/gui/assets/sq-"+Character.toString(Character.toLowerCase(challenge.charAt(8)))+".png"));
        square9.setFitWidth(size);
        square9.setPreserveRatio(true);

        // Create grid of pieces
        GridPane challengePane = new GridPane();
        challengePane.add(square1, 0, 0, 1, 1);
        challengePane.add(square2, 1, 0, 1, 1);
        challengePane.add(square3, 2, 0, 1, 1);
        challengePane.add(square4, 0, 1, 1, 1);
        challengePane.add(square5, 1, 1, 1, 1);
        challengePane.add(square6, 2, 1, 1, 1);
        challengePane.add(square7, 0, 2, 1, 1);
        challengePane.add(square8, 1, 2, 1, 1);
        challengePane.add(square9, 2, 2, 1, 1);

        // Place challenge pane
        challengePane.setLayoutX(735);
        challengePane.setLayoutY(100);


        //Creating a board group
        Group boardGroup = new Group();
        boardGroup.getChildren().add(boardImageView);
        boardGroup.getChildren().add(quit_button);

        //Creating a piece group
        Group pieceGroup = new Group();

        // Create array of shapes and add to flow pane
        ArrayList<ImageView> shapeImages = new ArrayList<ImageView>();
        for (int i = 0; i < 10; i++) {
            // Generate position of piece
            int x = (i%5)*4*SQUARE_SIZE;
            int y = (i/5)*2*SQUARE_SIZE+450;
            // Create piece
            GamePiece piece = new GamePiece("abcdefghij".charAt(i), x, y);
            piece.imageView.setX(x);
            piece.imageView.setY(y);
            // Add piece to be placed on stage
            shapeImages.add(piece.imageView);
        }

        //Adding all the nodes to the flow pane
        boardGroup.getChildren().addAll(shapeImages);

        // Create a parent group
        Group parentGroup = new Group();
        parentGroup.getChildren().add(boardGroup);
        parentGroup.getChildren().add(challengePane);

        // Add scene
        scene = new Scene(parentGroup, width, height);

    }

}
