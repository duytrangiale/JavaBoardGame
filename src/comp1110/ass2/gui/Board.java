package comp1110.ass2.gui;

import javafx.application.Application;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Board extends Application {

    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;

    /**
     * @author Jaxon   u6432607
     */
    // FIXME Task 7: Implement a basic playable Focus Game in JavaFX that only allows pieces to be placed in valid places

    /**
     * @author Duy Le - u6923736
     */
    // FIXME Task 8: Implement challenges (you may use challenges and assets provided for you in comp1110.ass2.gui.assets: sq-b.png, sq-g.png, sq-r.png & sq-w.png)

    // FIXME Task 10: Implement hints

    // FIXME Task 11: Generate interesting challenges (each challenge may have just one solution)

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("IQ-Focus");

        /*Media media = new Media("/assets/theme_music.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);*/

        // Initialise menu scene and display it
        MenuWindow menu = new MenuWindow(BOARD_WIDTH, BOARD_HEIGHT, primaryStage, 'j');
        primaryStage.setScene(menu.scene);
        primaryStage.show();

        //mediaPlayer.play();

    }
}

