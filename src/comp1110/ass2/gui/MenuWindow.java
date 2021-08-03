package comp1110.ass2.gui;

import comp1110.ass2.Solution;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Duy Le - u6923736 (with Jaxon Kneipp as collaborator)
 */
public class MenuWindow extends Scene {

    public Scene scene;
    public Stage parent;
    public double width;
    public double height;
    public Character level;
    private static final int SQUARE_SIZE = 60;
    public String challenge = "RRRRRRRRR";
    double[][] challengeSquareCoordinates = {{80, 368}, {149.6, 368}, {220, 368}, {80, 435.2}, {149.6, 435.2}, {220, 435.2}, {80, 504.8}, {149.6, 504.8}, {220, 504.8}};

    public MenuWindow(double width, double height, Stage parent, Character level) {
        super(new Group(), width, height);
        this.width = width;
        this.height = height;
        this.parent = parent;
        this.level = level;
        this.initialise();
    }

    Random random = new Random();

    private class StarterChallenge{
        public String challenge;
        public StarterChallenge(){
            int n = random.nextInt(24 - 0 + 1) + 0;
            this.challenge = Solution.SOLUTIONS[n].objective;
        }
    }

    private class JuniorChallenge{
        public String challenge;
        public JuniorChallenge(){
            int n = random.nextInt(48 - 24 + 1) + 24;
            this.challenge = Solution.SOLUTIONS[n].objective;
        }
    }

    private class MasterChallenge{
        public String challenge;
        public MasterChallenge(){
            int n = random.nextInt(72 - 48 + 1) + 48;
            this.challenge = Solution.SOLUTIONS[n].objective;
        }
    }

    private class ExpertChallenge{
        public String challenge;
        public ExpertChallenge(){
            int n = random.nextInt(96 - 72 + 1) + 72;
            this.challenge = Solution.SOLUTIONS[n].objective;
        }
    }

    private class WizardChallenge{
        public String challenge;
        public WizardChallenge(){
            int n = random.nextInt(120 - 96 + 1) + 96;
            this.challenge = Solution.SOLUTIONS[n].objective;
        }
    }

    // Create a class ColourSquare which receive a character describes colour and return a square image
    private class ColourSquare {
        public char colour;
        public ImageView imageView;
        String squareImageUrl;
        Image squareImage;

        public ColourSquare(char colour) {
            this.colour = colour;
            switch (colour) {
                case 'R':
                    squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-r.png";
                    squareImage = new Image(squareImageUrl);
                    this.imageView = new ImageView((squareImage));
                    this.imageView.setImage(squareImage);
                    this.imageView.setFitWidth(SQUARE_SIZE);
                    this.imageView.setPreserveRatio(true);
                    this.imageView.setSmooth(true);
                    break;
                case 'B':
                    squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-b.png";
                    squareImage = new Image(squareImageUrl);
                    this.imageView = new ImageView((squareImage));
                    this.imageView.setImage(squareImage);
                    this.imageView.setFitWidth(SQUARE_SIZE);
                    this.imageView.setPreserveRatio(true);
                    this.imageView.setSmooth(true);
                    break;
                case 'G':
                    squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-g.png";
                    squareImage = new Image(squareImageUrl);
                    this.imageView = new ImageView((squareImage));
                    this.imageView.setImage(squareImage);
                    this.imageView.setFitWidth(SQUARE_SIZE);
                    this.imageView.setPreserveRatio(true);
                    this.imageView.setSmooth(true);
                    break;
                case 'W':
                    squareImageUrl = "file:src/comp1110/ass2/gui/assets/sq-w.png";
                    squareImage = new Image(squareImageUrl);
                    this.imageView = new ImageView((squareImage));
                    this.imageView.setImage(squareImage);
                    this.imageView.setFitWidth(SQUARE_SIZE);
                    this.imageView.setPreserveRatio(true);
                    this.imageView.setSmooth(true);
                    break;
            }
        }
    }


    public void initialise() {

        // load the banner image
        Image banner = new Image("file:src/comp1110/ass2/gui/assets/banner1.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(banner);
        iv1.setFitWidth(600);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setX((width/2)-(iv1.getFitWidth()/2));
        iv1.setY(height/5);

        // load the background image
        Image background = new Image("file:src/comp1110/ass2/gui/assets/background.png");
        ImageView iv2 = new ImageView();
        iv2.setImage(background);
        iv2.setFitWidth(width+20);
        iv2.setPreserveRatio(true);
        iv2.setLayoutX(-20);
        iv2.setLayoutY(-10);
        iv2.setSmooth(true);

        // Create play button
        Button button = new Button("PLAY");
        button.setPrefHeight(80);
        button.setPrefWidth(240);
        button.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        button.setTextFill(Color.BLACK);
        button.setLayoutX((width/1.22)-(button.getPrefWidth()/2));
        button.setLayoutY(height/1.8);

        // Create starter button
        Button starter_button = new Button("STARTER");
        starter_button.setPrefHeight(70);
        starter_button.setPrefWidth(150);
        starter_button.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        starter_button.setTextFill(Color.GREEN);
        starter_button.setLayoutX((width/2.5)-(starter_button.getPrefWidth()/2));
        starter_button.setLayoutY(height/2);

        // Create junior button
        Button junior_button = new Button("JUNIOR");
        junior_button.setPrefHeight(70);
        junior_button.setPrefWidth(150);
        junior_button.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        junior_button.setTextFill(Color.GREEN);
        junior_button.setLayoutX((width/2.5)-(junior_button.getPrefWidth()/2));
        junior_button.setLayoutY(height/1.65);

        // Create master button
        Button master_button = new Button("MASTER");
        master_button.setPrefHeight(70);
        master_button.setPrefWidth(150);
        master_button.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        master_button.setTextFill(Color.GREEN);
        master_button.setLayoutX((width/2.5)-(master_button.getPrefWidth()/2));
        master_button.setLayoutY(height/1.4);

        // Create expert button
        Button expert_button = new Button("EXPERT");
        expert_button.setPrefHeight(70);
        expert_button.setPrefWidth(150);
        expert_button.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        expert_button.setTextFill(Color.GREEN);
        expert_button.setLayoutX((width/1.75)-(expert_button.getPrefWidth()/2));
        expert_button.setLayoutY(height/1.8);

        // Create wizard button
        Button wizard_button = new Button("WIZARD");
        wizard_button.setPrefHeight(70);
        wizard_button.setPrefWidth(150);
        wizard_button.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        wizard_button.setTextFill(Color.GREEN);
        wizard_button.setLayoutX((width/1.75)-(wizard_button.getPrefWidth()/2));
        wizard_button.setLayoutY(height/1.5);

        // Add action event when starter button clicked
        EventHandler<ActionEvent>starter_event = e -> starter_button.setOnAction(level_event1 ->{
            MenuWindow challenge = new MenuWindow(width, height, parent, 's');
            parent.setScene(challenge.scene);
        });
        starter_button.setOnAction(starter_event);

        // Add action event when junior button clicked
        EventHandler<ActionEvent>junior_event = e -> junior_button.setOnAction(level_event2 ->{
            MenuWindow challenge = new MenuWindow(width, height, parent, 'j');
            parent.setScene(challenge.scene);
        });
        junior_button.setOnAction(junior_event);

        // Add action event when master button clicked
        EventHandler<ActionEvent>master_event = e -> master_button.setOnAction(level_event3 ->{
            MenuWindow challenge = new MenuWindow(width, height, parent, 'm');
            parent.setScene(challenge.scene);
        });
        master_button.setOnAction(master_event);

        // Add action event when expert button clicked
        EventHandler<ActionEvent>expert_event = e -> expert_button.setOnAction(level_event4 ->{
            MenuWindow challenge = new MenuWindow(width, height, parent, 'e');
            parent.setScene(challenge.scene);
        });
        expert_button.setOnAction(expert_event);

        // Add action event when wizard button clicked
        EventHandler<ActionEvent>wizard_event = e -> wizard_button.setOnAction(level_event5 ->{
            MenuWindow challenge = new MenuWindow(width, height, parent, 'w');
            parent.setScene(challenge.scene);
        });
        wizard_button.setOnAction(wizard_event);

        //Creating different challenge group
        Group starterGroup = new Group();
        Group juniorGroup = new Group();
        Group masterGroup = new Group();
        Group expertGroup = new Group();
        Group wizardGroup = new Group();

        if (level == 's') {

            // Create array of square and add to flow pane
            ArrayList<ImageView> starterSquares = new ArrayList<ImageView>();
            StarterChallenge starter = new StarterChallenge();
            char[] starterColour = starter.challenge.toCharArray();
            challenge = starter.challenge;
            for (int i = 0; i < starterColour.length; i++) {
                ColourSquare colourSquare = new ColourSquare(starterColour[i]);
                starterSquares.add(colourSquare.imageView);
                colourSquare.imageView.setX(challengeSquareCoordinates[i][0]);
                colourSquare.imageView.setY(challengeSquareCoordinates[i][1]);
            }
            starterGroup.autosize();
            starterGroup.getChildren().addAll(starterSquares);

        }

        if (level == 'j') {

            ArrayList<ImageView> juniorSquares = new ArrayList<ImageView>();
            JuniorChallenge junior = new JuniorChallenge();
            char[] juniorColour = junior.challenge.toCharArray();
            challenge = junior.challenge;
            for (int i = 0; i < juniorColour.length; i++) {
                ColourSquare colourSquare = new ColourSquare(juniorColour[i]);
                juniorSquares.add(colourSquare.imageView);
                colourSquare.imageView.setX(challengeSquareCoordinates[i][0]);
                colourSquare.imageView.setY(challengeSquareCoordinates[i][1]);
            }
            juniorGroup.autosize();
            juniorGroup.getChildren().addAll(juniorSquares);

        }

        if (level == 'm') {

            ArrayList<ImageView> masterSquares = new ArrayList<ImageView>();
            MasterChallenge master = new MasterChallenge();
            char[] masterColour = master.challenge.toCharArray();
            challenge = master.challenge;
            for (int i = 0; i < masterColour.length; i++) {
                ColourSquare colourSquare = new ColourSquare(masterColour[i]);
                masterSquares.add(colourSquare.imageView);
                colourSquare.imageView.setX(challengeSquareCoordinates[i][0]);
                colourSquare.imageView.setY(challengeSquareCoordinates[i][1]);
            }
            masterGroup.autosize();
            masterGroup.getChildren().addAll(masterSquares);

        }

        if (level == 'e') {

            ArrayList<ImageView> expertSquares = new ArrayList<ImageView>();
            ExpertChallenge expert = new ExpertChallenge();
            char[] expertColour = expert.challenge.toCharArray();
            challenge = expert.challenge;
            for (int i = 0; i < expertColour.length; i++) {
                ColourSquare colourSquare = new ColourSquare(expertColour[i]);
                expertSquares.add(colourSquare.imageView);
                colourSquare.imageView.setX(challengeSquareCoordinates[i][0]);
                colourSquare.imageView.setY(challengeSquareCoordinates[i][1]);
            }
            expertGroup.autosize();
            expertGroup.getChildren().addAll(expertSquares);

        }

        if (level == 'w') {

            ArrayList<ImageView> wizardSquares = new ArrayList<ImageView>();
            WizardChallenge wizard = new WizardChallenge();
            char[] wizardColour = wizard.challenge.toCharArray();
            challenge = wizard.challenge;
            for (int i = 0; i < wizardColour.length; i++) {
                ColourSquare colourSquare = new ColourSquare(wizardColour[i]);
                wizardSquares.add(colourSquare.imageView);
                colourSquare.imageView.setX(challengeSquareCoordinates[i][0]);
                colourSquare.imageView.setY(challengeSquareCoordinates[i][1]);
            }
            wizardGroup.autosize();
            wizardGroup.getChildren().addAll(wizardSquares);

        }

        // add action event for when button clicked
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                GameWindow game = new GameWindow(width, height, parent, challenge);
                parent.setScene(game.scene);
            }
        };
        button.setOnAction(event);

        // Create scene
        Group root = new Group();
        root.getChildren().add(iv1);
        root.getChildren().add(iv2);
        root.getChildren().add(button);
        root.getChildren().add(starter_button);
        root.getChildren().add(starterGroup);
        root.getChildren().add(junior_button);
        root.getChildren().add(juniorGroup);
        root.getChildren().add(master_button);
        root.getChildren().add(masterGroup);
        root.getChildren().add(expert_button);
        root.getChildren().add(expertGroup);
        root.getChildren().add(wizard_button);
        root.getChildren().add(wizardGroup);

        scene = new Scene(root, width, height);
    }

}
