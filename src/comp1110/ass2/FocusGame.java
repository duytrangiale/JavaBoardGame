package comp1110.ass2;

import com.sun.source.tree.WhileLoopTree;
import gittest.A;
import jdk.jfr.StackTrace;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This class provides the text interface for the IQ Focus Game
 * <p>
 * The game is based directly on Smart Games' IQ-Focus game
 * (https://www.smartgames.eu/uk/one-player-games/iq-focus)
 */
public class FocusGame {

    /**
     * Determine whether a piece placement is well-formed according to the
     * following criteria:
     * - it consists of exactly four characters
     * - the first character is in the range a .. j (shape)
     * - the second character is in the range 0 .. 8 (column)
     * - the third character is in the range 0 .. 4 (row)
     * - the fourth character is in the range 0 .. 3 (orientation)
     *
     * @param piecePlacement A string describing a piece placement
     * @return True if the piece placement is well-formed
     * @author Jaxon   u6432607
     */
    static boolean isPiecePlacementWellFormed(String piecePlacement) {
        // FIXME Task 2: determine whether a piece placement is well-formed
        if (piecePlacement.length() > 4) {
            return false;
        }
        String regexPattern = "[a-j][0-8][0-4][0-3]";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(piecePlacement);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    /**
     * Determine whether a placement string is well-formed:
     * - it consists of exactly N four-character piece placements (where N = 1 .. 10);
     * - each piece placement is well-formed
     * - no shape appears more than once in the placement
     *
     * @param placement A string describing a placement of one or more pieces
     * @return True if the placement is well-formed
     * @author Duy Le - u6923736
     */
    public static boolean isPlacementStringWellFormed(String placement) {
        // FIXME Task 3: determine whether a placement is well-formed
        boolean flag = false;
        if (placement.length() == 0)
            return false;
        else if ((placement.length() % 4) != 0)
            return false;
        else if ((placement.length() % 4) == 0) {
            if (placement.length() > 4) {  // Case of more than 1 piece
                for (int i = 0; i < placement.length() - 1; i += 4) {
                    String piece = placement.substring(i, i + 4);  // Cut down into piece
                    if (isPiecePlacementWellFormed(piece))
                        flag = true;
                    else if (!isPiecePlacementWellFormed(piece))
                        return false;

                    for (int j = i + 4; j < placement.length() - 1; j += 4) {
                        if (placement.charAt(i) != placement.charAt(j))
                            flag = true;
                        else
                            return false;
                    }
                }
            } else if (isPiecePlacementWellFormed(placement)) // Case of just 1 piece
                return true;
        }
        return flag;
    }


    public static int[][] pieceToConfiguration(String pieceString) {
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

        switch (pieceString.charAt(0)) {
            case 'a':
                return a_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'b':
                return b_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'c':
                return c_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'd':
                return d_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'e':
                return e_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'f':
                return f_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'g':
                return g_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'h':
                return h_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'i':
                return i_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'j':
                return j_config[Character.getNumericValue(pieceString.charAt(3))];
            default:
                return a_config[0];
        }
    }

    /**
     * @author Jaxon Kneipp u6432607
     */
    public static String printBoard(SquareColour[][] board) {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            result += Arrays.toString(board[i]) + "\n";
        }
        return result;
    }

    /**
     * Determine whether a placement string is valid.
     * <p>
     * To be valid, the placement string must be:
     * - well-formed, and
     * - each piece placement must be a valid placement according to the
     * rules of the game:
     * - pieces must be entirely on the board
     * - pieces must not overlap each other
     *
     * @param placement A placement string
     * @return True if the placement sequence is valid
     */
    public static boolean isPlacementStringValid(String placement) {
        // FIXME Task 5: determine whether a placement string is valid

        // Create board state
        int[][] boardStates = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
        };

        // Isolate all pieces in the string
        Pattern pattern = Pattern.compile("(....)");
        Matcher matcher = pattern.matcher(placement);

        // Loop through all pieces
        while (matcher.find()) {

            // Get a hold of the piece string
            String pieceString = matcher.group();
            if (!isPiecePlacementWellFormed(pieceString)) {
                return false;
            }
            int[][] pieceConfiguration = pieceToConfiguration(pieceString);

            int pieceRow = Character.getNumericValue(pieceString.charAt(2));
            int pieceCol = Character.getNumericValue(pieceString.charAt(1));

            // Updated board
            for (int y_offset = 0; y_offset < pieceConfiguration.length; y_offset++) {
                for (int x_offset = 0; x_offset < pieceConfiguration[y_offset].length; x_offset++) {
                    int currentBoardX = pieceCol + x_offset;
                    int currentBoardY = pieceRow + y_offset;
                    if (currentBoardY > 4 || currentBoardX > 8) {
                        return false;
                    }
                    if (boardStates[currentBoardY][currentBoardX] == 1 && pieceConfiguration[y_offset][x_offset] == 1) {
                        return false;
                    }
                    if (boardStates[currentBoardY][currentBoardX] == 0) {
                        if (pieceConfiguration[y_offset][x_offset] == 1) {
                            boardStates[currentBoardY][currentBoardX] = pieceConfiguration[y_offset][x_offset];
                        }
                    }
                }
            }

        }
        return true;
    }

    /**
     *Get a two-dimensional array that describes colors according to the type and direction of a piece.
     * @param pieceString A string describing a placement of one piece
     * @author Mingda Zheng   u6686733
     */
    public static SquareColour[][] pieceToColourConfiguration(String pieceString) {
        // TODO : Task 6A
        //Use a three-dimensional array to store the color status of different types of pieces in different directions
        SquareColour[][][] a_colour_config = {{
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


        SquareColour[][][] b_colour_config = {{
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


        SquareColour[][][] c_colour_config = {{
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


        SquareColour[][][] d_colour_config = {{
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


        SquareColour[][][] e_colour_config = {{
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


        SquareColour[][][] f_colour_config = {{
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


        SquareColour[][][] g_colour_config = {{
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


        SquareColour[][][] h_colour_config = {{
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


        SquareColour[][][] i_colour_config = {{
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


        SquareColour[][][] j_colour_config = {{
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
        //Get the piece type and direction based on the String description to get the corresponding color array
        switch (pieceString.charAt(0)) {
            case 'a':
                return a_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'b':
                return b_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'c':
                return c_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'd':
                return d_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'e':
                return e_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'f':
                return f_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'g':
                return g_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'h':
                return h_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'i':
                return i_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            case 'j':
                return j_colour_config[Character.getNumericValue(pieceString.charAt(3))];
            default:
                return a_colour_config[0];
        }
    }

    public static SquareColour[] challengeStringToChallengeData(String challenge) {
        SquareColour[] result = new SquareColour[9];
        char[] colorCharacters = challenge.toCharArray();
        for (int index = 0; index < colorCharacters.length; index++) {
            char color = colorCharacters[index];
            switch (color) {
                case 'R':
                    result[index] = SquareColour.RED;
                    break;
                case 'G':
                    result[index] = SquareColour.GREEN;
                    break;
                case 'B':
                    result[index] = SquareColour.BLUE;
                    break;
                case 'W':
                    result[index] = SquareColour.WHITE;
                    break;
            }
        }
        return result;
    }

    /**
     * @author Jaxon   u6432607
     */
    public static Boolean isPlacementConsistentWithChallenge(SquareColour[][] boardState, String placement, String pieceString, String challenge, int col, int row) {

        // TODO : Task 6C

        // Initialise list containing coordinates of the challenge squares
        int[][] challengeSquareCoordinates = {{3, 1}, {4, 1}, {5, 1}, {3, 2}, {4, 2}, {5, 2}, {3, 3}, {4, 3}, {5, 3}};

        // Create new placement string containing the new piece
        String newPlacementString = placement + pieceString;

        // Generate new board state (with piece included)
        SquareColour[][] boardStateUpdated = placementToBoardState(newPlacementString);

        // Check if board state is valid
        if (boardStateUpdated == null) {
            return false;
        }

        // Check if piece location has tile occupying it
        if (boardStateUpdated[row][col] == null) {
            return false;
        }

        // Convert challenge string to array of SquareColors
        SquareColour[] challengeColorData = challengeStringToChallengeData(challenge);
        // Loop over the coordinates of the challenge square
        for (int index = 0; index < challengeSquareCoordinates.length; index++) {

            // Obtain currently index coordinates
            int[] coordinates = challengeSquareCoordinates[index];
            int first = coordinates[1];
            int second = coordinates[0];

            // Obtain above indexed coordinated Square color both on the board and within the challenge string.
            SquareColour boardColor = boardStateUpdated[first][second];
            SquareColour color = challengeColorData[index];

            // Check if the board and challenge tiles allign
            if (boardColor != color) {
                // Check if the board tile is empty
                if (boardColor != null) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * @author Duy Le - u6923736
     */
    public static SquareColour[][] placementToBoardState(String placementString) {
        // TODO : Task 6B
        // Create board state with colour
        SquareColour[][] boardStates = {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {SquareColour.DEFAULT, null, null, null, null, null, null, null, SquareColour.DEFAULT},
        };
        // Isolate all pieces in the string
        Pattern pattern = Pattern.compile("(....)");
        Matcher matcher = pattern.matcher(placementString);

        // Loop through all pieces
        while (matcher.find()) {

            // Get a hold of the piece string
            String pieceString = matcher.group();
            if (!isPiecePlacementWellFormed(pieceString)) {
                return null;
            }
            SquareColour[][] pieceConfiguration = pieceToColourConfiguration(pieceString);

            int pieceRow = Character.getNumericValue(pieceString.charAt(2));
            int pieceCol = Character.getNumericValue(pieceString.charAt(1));

            // Updated board
            for (int y_offset = 0; y_offset < pieceConfiguration.length; y_offset++) {
                for (int x_offset = 0; x_offset < pieceConfiguration[y_offset].length; x_offset++) {
                    int currentBoardX = pieceCol + x_offset;
                    int currentBoardY = pieceRow + y_offset;
                    if (currentBoardY > 4 || currentBoardX > 8) {
                        return null;
                    }
                    if (boardStates[currentBoardY][currentBoardX] != null && pieceConfiguration[y_offset][x_offset] != null) {
                        return null;
                    }
                    if (boardStates[currentBoardY][currentBoardX] == null) {
                        if (pieceConfiguration[y_offset][x_offset] != null) {
                            boardStates[currentBoardY][currentBoardX] = pieceConfiguration[y_offset][x_offset];
                        }
                    }
                }
            }

        }
        return boardStates;
    }

    /**
     * Given a string describing a placement of pieces and a string describing
     * a challenge, return a set of all possible next viable piece placements
     * which cover a specific board location.
     * <p>
     * For a piece placement to be viable
     * - it must be valid
     * - it must be consistent with the challenge
     *
     * @param placement A viable placement string
     * @param challenge The game's challenge is represented as a 9-character string
     *                  which represents the color of the 3*3 central board area
     *                  squares indexed as follows:
     *                  [0] [1] [2]
     *                  [3] [4] [5]
     *                  [6] [7] [8]
     *                  each character may be any of
     *                  - 'R' = RED square
     *                  - 'B' = Blue square
     *                  - 'G' = Green square
     *                  - 'W' = White square
     * @param col       The location's column.
     * @param row       The location's row.
     * @return A set of viable piece placements, or null if there are none.
     * @author Jaxon Kneipp u6432607
     */
    public static Set<String> getViablePiecePlacements(String placement, String challenge, int col, int row) {

        // FIXME Task 6: determine the set of all viable piece placements given existing placements and a challenge

        // Generate an initial board state
        SquareColour[][] boardState = placementToBoardState(placement);

        // Check if board state is valid.
        if (boardState == null) {
            // Board state is invalid, thus there are no viable moves
            System.out.println("Invalid board state");
            return null;
        }

        // Initialise set to store all possible placements.
        Set<String> placements = new HashSet<>();//arrange set elements in order

        // Loop
        for (int tmpCol = 0; tmpCol <= 8; tmpCol++) {
            for (int tmpRow = 0; tmpRow <= 4; tmpRow++) {
                // Loop over all shapes
                for (char shape : "abcdefghij".toCharArray()) {

                    // Check if shape is already used
                    if (!placement.contains(Character.toString(shape))) {

                        // Loop over all orientations
                        for (int orientation = 0; orientation <= 3; orientation++) {

                            // Gererate piece placement string based on current loops values
                            String piecePlacement = shape + Integer.toString(tmpCol) + (tmpRow) + (orientation);

                            // Check if the placement conforms to the challenge
                            if (isPlacementConsistentWithChallenge(boardState, placement, piecePlacement, challenge, col, row)) {
                                // Add piece string to possible placements
                                placements.add(piecePlacement);
                            }
                        }
                    }
                }
            }
        }

        // Check if any placements have been found
        if (placements.isEmpty()) {
            //System.out.println("No possible placements");
            return null;
        }
        return placements;
    }

    /**
     * Check if there is positions where cannot be put any pieces,like,
     *    []              [][]
     * [] * []         [] * * []
     *   []              [][]
     *
     * @param placement  A string describing a placement of one or more pieces
     * @author Mingda Zheng u6686733
     */
    public static boolean notUselessPiece(String placement) {
        SquareColour[][] boardState = placementToBoardState(placement);
        if (boardState == null) {
            return false;
        }
        if (boardState[0][0] == null && boardState[0][1] != null && boardState[1][0] != null) {
            return false;
        }
        if (boardState[3][0] == null && boardState[2][0] != null && boardState[3][1] != null) {
            return false;
        }
        if (boardState[4][1] == null && boardState[3][1] != null && boardState[4][2] != null) {
            return false;
        }
        if (boardState[0][8] == null && boardState[0][7] != null && boardState[1][8] != null) {
            return false;
        }
        if (boardState[3][8] == null && boardState[2][8] != null && boardState[3][7] != null) {
            return false;
        }
        if (boardState[4][7] == null && boardState[3][7] != null && boardState[4][6] != null) {
            return false;
        }
        if (boardState[1][0] == null && boardState[0][0] != null && boardState[1][1] != null && boardState[2][0] != null) {
            return false;
        }
        if (boardState[2][0] == null && boardState[1][0] != null && boardState[2][1] != null && boardState[3][0] != null) {
            return false;
        }
        if (boardState[1][8] == null && boardState[0][8] != null && boardState[1][7] != null && boardState[2][8] != null) {
            return false;
        }
        if (boardState[2][8] == null && boardState[1][8] != null && boardState[2][7] != null && boardState[3][8] != null) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (i > 0 && i < 4 && j > 0 && j < 8) {
                    if (boardState[i][j] == null && boardState[i - 1][j] != null && boardState[i + 1][j] != null && boardState[i][j - 1] != null && boardState[i][j + 1] != null) {
                        return false;
                    }
                }
                if (i == 0 && j > 0 && j < 8) {
                    if (boardState[i][j] == null && boardState[i][j - 1] != null && boardState[i][j + 1] != null && boardState[i + 1][j] != null) {
                        return false;
                    }
                }
                if (i == 4 && j > 1 && j < 7) {
                    if (boardState[i][j] == null && boardState[i][j - 1] != null && boardState[i][j + 1] != null && boardState[i - 1][j] != null) {
                        return false;
                    }
                }
            }
        }
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 7; j++) {
                if (boardState[i][j] == null && boardState[i][j + 1] == null && boardState[i][j - 1] != null && boardState[i][j + 2] != null && boardState[i - 1][j] != null && boardState[i - 1][j + 1] != null && boardState[i + 1][j] != null && boardState[i + 1][j + 1] != null) {
                    return false;
                }
                if (boardState[i][j] == null && boardState[i + 1][j] == null && boardState[i - 1][j] != null && boardState[i + 2][j] != null && boardState[i][j - 1] != null && boardState[i][j + 1] != null && boardState[i + 1][j - 1] != null && boardState[i + 1][j + 1] != null) {
                    return false;
                }
            }
        }
        for (int i = 1; i < 3; i++) {
            int j = 7;
            if (boardState[i][j] == null && boardState[i][j + 1] == null && boardState[i][j - 1] != null && boardState[i - 1][j] != null && boardState[i - 1][j + 1] != null && boardState[i + 1][j] != null && boardState[i + 1][j + 1] != null) {
                return false;
            }
            if (boardState[i][j] == null && boardState[i + 1][j] == null && boardState[i - 1][j] != null && boardState[i + 2][j] != null && boardState[i][j - 1] != null && boardState[i][j + 1] != null && boardState[i + 1][j - 1] != null && boardState[i + 1][j + 1] != null) {
                return false;
            }
        }
        for (int j = 1; j < 7; j++) {
            int i = 0;
            if (boardState[i][j] == null && boardState[i][j + 1] == null && boardState[i][j - 1] != null && boardState[i][j + 2] != null && boardState[i + 1][j] != null && boardState[i + 1][j + 1] != null) {
                return false;
            }
            if (boardState[i][j] == null && boardState[i + 1][j] == null && boardState[i][j - 1] != null && boardState[i][j + 1] != null && boardState[i + 1][j - 1] != null && boardState[i + 1][j + 1] != null && boardState[i + 2][j] != null) {
                return false;
            }
        }
        if (boardState[0][7] == null && boardState[0][8] == null && boardState[0][6] != null && boardState[1][7] != null && boardState[1][8] != null) {
            return false;
        }
        if (boardState[0][7] == null && boardState[1][7] == null && boardState[0][6] != null && boardState[0][8] != null && boardState[1][6] != null && boardState[1][8] != null && boardState[2][7] != null) {
            return false;
        }
        for (int j = 2; j < 6; j++) {
            int i = 4;
            if (boardState[i][j] == null && boardState[i][j + 1] == null && boardState[i][j - 1] != null && boardState[i][j + 2] != null && boardState[i - 1][j] != null && boardState[i - 1][j + 1] != null) {
                return false;
            }
            if (boardState[i][j] == null && boardState[i - 1][j] == null && boardState[i][j - 1] != null && boardState[i][j + 1] != null && boardState[i - 1][j - 1] != null && boardState[i - 1][j + 1] != null && boardState[i - 2][j] != null) {
                return false;
            }
        }
        if (boardState[4][1] == null && boardState[4][2] == null && boardState[3][1] != null && boardState[3][2] != null && boardState[4][3] != null) {
            return false;
        }
        if (boardState[4][1] == null && boardState[3][1] == null && boardState[2][1] != null && boardState[3][0] != null && boardState[3][2] != null && boardState[4][2] != null) {
            return false;
        }

        if (boardState[4][6] == null && boardState[4][7] == null && boardState[3][6] != null && boardState[3][7] != null && boardState[4][5] != null) {
            return false;
        }
        if (boardState[4][7] == null && boardState[3][7] == null && boardState[2][7] != null && boardState[3][6] != null && boardState[3][8] != null && boardState[4][6] != null) {
            return false;
        }

        if (boardState[1][0] == null && boardState[2][0] == null && boardState[0][0] != null && boardState[1][1] != null && boardState[2][1] != null && boardState[3][0] != null) {
            return false;
        }
        if (boardState[1][0] == null && boardState[1][1] == null && boardState[0][0] != null && boardState[0][1] != null && boardState[1][2] != null && boardState[2][0] != null && boardState[2][1] != null) {
            return false;
        }
        if (boardState[1][8] == null && boardState[2][8] == null && boardState[0][8] != null && boardState[1][7] != null && boardState[2][7] != null && boardState[3][8] != null) {
            return false;
        }
        if (boardState[1][8] == null && boardState[1][7] == null && boardState[0][7] != null && boardState[0][8] != null && boardState[1][6] != null && boardState[2][7] != null && boardState[2][8] != null) {
            return false;
        }
        if (boardState[2][0] == null && boardState[3][0] == null && boardState[1][0] != null && boardState[2][1] != null && boardState[3][1] != null) {
            return false;
        }
        if (boardState[2][0] == null && boardState[2][1] == null && boardState[1][0] != null && boardState[1][1] != null && boardState[2][2] != null && boardState[3][0] != null && boardState[3][1] != null) {
            return false;
        }
        if (boardState[2][8] == null && boardState[3][8] == null && boardState[1][8] != null && boardState[2][7] != null && boardState[3][7] != null) {
            return false;
        }
        if (boardState[2][8] == null && boardState[2][7] == null && boardState[1][8] != null && boardState[1][7] != null && boardState[2][6] != null && boardState[3][7] != null && boardState[3][8] != null) {
            return false;
        }
        if (boardState[3][0] == null && boardState[3][1] == null && boardState[2][0] != null && boardState[2][1] != null && boardState[3][2] != null && boardState[4][1] != null) {
            return false;
        }
        if (boardState[3][8] == null && boardState[3][7] == null && boardState[2][8] != null && boardState[2][7] != null && boardState[3][6] != null && boardState[4][7] != null) {
            return false;
        }
        if (boardState[0][0] == null && boardState[1][0] == null && boardState[0][1] != null && boardState[1][1] != null && boardState[2][0] != null) {
            return false;
        }
        if (boardState[0][0] == null && boardState[0][1] == null && boardState[0][2] != null && boardState[1][0] != null && boardState[1][1] != null) {
            return false;
        }
        if (boardState[0][8] == null && boardState[1][8] == null && boardState[0][7] != null && boardState[1][7] != null && boardState[2][8] != null) {
            return false;
        }
        if (boardState[0][8] == null && boardState[0][7] == null && boardState[0][6] != null && boardState[1][7] != null && boardState[1][8] != null) {
            return false;
        }


        return true;
    }

    /**
     * Return the canonical encoding of the solution to a particular challenge.
     * <p>
     * A given challenge can only solved with a single placement of pieces.
     * <p>
     * Since some piece placements can be described two ways (due to symmetry),
     * you need to use a canonical encoding of the placement, which means you
     * must:
     * - Order the placement sequence by piece IDs
     * - If a piece exhibits rotational symmetry, only return the lowest
     * orientation value (0 or 1)
     *
     * @param challenge A challenge string.
     * @return A placement string describing a canonical encoding of the solution to
     * the challenge.
     * @author Mingda Zheng u6686733
     */
    public static String getSolution(String challenge) {
        // FIXME Task 9: determine the solution to the game, given a particular challenge
        String solution = "";
        //Create an ArrayList to store viable placement string
        ArrayList<ArrayList<String>> placementList = new ArrayList<>();
        //Get viable piece placement string with coordinate (4,2)
        ArrayList<String> viablePieces = new ArrayList<>(Objects.requireNonNull(getViablePiecePlacements(solution, challenge, 4, 2)));
        placementList.add(viablePieces);
        //Remove rotational symmetry pieces
        for (int index = placementList.get(placementList.size() - 1).size() - 1; index >= 0; index--) {
            int pos = placementList.get(placementList.size() - 1).get(index).indexOf("f");
            if (pos != -1) {
                String subStr = placementList.get(placementList.size() - 1).get(index).substring(pos, pos + 4);
                if (subStr.charAt(3) == '2' || subStr.charAt(3) == '3') {
                    placementList.get(placementList.size() - 1).remove(index);
                }
            }
        }
        for (int index = placementList.get(placementList.size() - 1).size() - 1; index >= 0; index--) {
            int pos = placementList.get(placementList.size() - 1).get(index).indexOf("g");
            if (pos != -1) {
                String subStr = placementList.get(placementList.size() - 1).get(index).substring(pos, pos + 4);
                if (subStr.charAt(3) == '2' || subStr.charAt(3) == '3') {
                    placementList.get(placementList.size() - 1).remove(index);
                }
            }
        }

        int count = 0;
        //Use the loop to get the viable placement string of the middle nine positions
        for (int col = 3; col < 6; col++) {
            for (int row = 1; row < 4; row++) {
                ArrayList<String> nextViablePieces = new ArrayList<>();
                for (int index = 0; index < placementList.get(count).size(); index++) {
                    solution = solution + placementList.get(count).get(index);
                    SquareColour[][] boardState = placementToBoardState(solution);
                    //Check whether the state of each of nine positions is not null
                    boolean flag = true;
                    outerLoop:for (int tempCol = 3; tempCol < 6; tempCol++) {
                        for (int tempRow = 1; tempRow < 4; tempRow++) {
                            assert boardState != null;
                            if (boardState[row][col] == null) {
                                flag = false;
                                break outerLoop;
                            }
                        }
                    }
                    if (flag) {
                        nextViablePieces.add(solution);
                    } else {
                        if (boardState[row][col] == null) {
                            if (getViablePiecePlacements(solution, challenge, col, row) != null) {
                                //Create an ArrayList to store the viable placements of current position
                                ArrayList<String> next = new ArrayList<>(Objects.requireNonNull(getViablePiecePlacements(solution, challenge, col, row)));
                                for (int nextIndex = 0; nextIndex < next.size(); nextIndex++) {
                                    solution = solution + next.get(nextIndex);
                                    if (isPlacementStringValid(solution) && notUselessPiece(solution)) {
                                        nextViablePieces.add(solution);
                                    }
                                    solution = solution.replace(next.get(nextIndex), "");
                                }
                            }
                        }
                    }
                    solution = "";
                }
                //Add viable string list to placementList
                placementList.add(nextViablePieces);
                //Remove rotational symmetry pieces
                for (int index = placementList.get(placementList.size() - 1).size() - 1; index >= 0; index--) {
                    int pos = placementList.get(placementList.size() - 1).get(index).indexOf("f");

                    if (pos != -1) {
                        String subStr = placementList.get(placementList.size() - 1).get(index).substring(pos, pos + 4);

                        if (subStr.charAt(3) == '2' || subStr.charAt(3) == '3') {

                            placementList.get(placementList.size() - 1).remove(index);
                        }

                    }
                }
                for (int index = placementList.get(placementList.size() - 1).size() - 1; index >= 0; index--) {
                    int pos = placementList.get(placementList.size() - 1).get(index).indexOf("g");
                    if (pos != -1) {
                        String subStr = placementList.get(placementList.size() - 1).get(index).substring(pos, pos + 4);
                        if (subStr.charAt(3) == '2' || subStr.charAt(3) == '3') {

                            placementList.get(placementList.size() - 1).remove(index);
                        }

                    }
                }
                count++;

            }
        }



        //Creat an ArrayList to store the viable string combinations
        ArrayList<ArrayList<String>> allPlacementList = new ArrayList<>();
        //Add the string finally obtained above (nine challenge position) to new ArrayList-allPlacementList
        allPlacementList.add(placementList.get(placementList.size() - 1));
        solution = "";
        int number = 0;
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 5; row++) {
                ArrayList<String> nextViablePieces = new ArrayList<>();
                for (int index = 0; index < allPlacementList.get(number).size(); index++) {

                    solution = solution + allPlacementList.get(number).get(index);
                    SquareColour[][] boardState = placementToBoardState(solution);
                    boolean flag = true;
                    //Check whether the state of every positions is not null
                    outerLoop:for (int tempCol = 0; tempCol < 9; tempCol++) {
                        for (int tempRow = 0; tempRow < 5; tempRow++) {
                            assert boardState != null;
                            if (boardState[row][col] == null) {
                                flag = false;
                                break outerLoop;
                            }
                        }
                    }
                    if (flag) {
                        nextViablePieces.add(solution);
                    } else {
                        if (boardState[row][col] == null) {
                            if (getViablePiecePlacements(solution, challenge, col, row) != null) {
                                //Create an ArrayList to store the viable placements of current position
                                ArrayList<String> next = new ArrayList<>(Objects.requireNonNull(getViablePiecePlacements(solution, challenge, col, row)));
                                for (int nextIndex = 0; nextIndex < next.size(); nextIndex++) {
                                    solution = solution + next.get(nextIndex);
                                    if (isPlacementStringValid(solution) && notUselessPiece(solution)) {
                                        nextViablePieces.add(solution);
                                    }
                                    solution = solution.replace(next.get(nextIndex), "");
                                }
                            }
                        }
                    }
                    solution = "";

                }
                //Add viable string list to placementList
                allPlacementList.add(nextViablePieces);
                //Remove rotational symmetry pieces
                for (int index = allPlacementList.get(allPlacementList.size() - 1).size() - 1; index >= 0; index--) {
                    int pos = allPlacementList.get(allPlacementList.size() - 1).get(index).indexOf("f");

                    if (pos != -1) {
                        String subStr = allPlacementList.get(allPlacementList.size() - 1).get(index).substring(pos, pos + 4);

                        if (subStr.charAt(3) == '2' || subStr.charAt(3) == '3') {

                            allPlacementList.get(allPlacementList.size() - 1).remove(index);
                        }

                    }
                }
                for (int index = allPlacementList.get(allPlacementList.size() - 1).size() - 1; index >= 0; index--) {
                    int pos = allPlacementList.get(allPlacementList.size() - 1).get(index).indexOf("g");

                    if (pos != -1) {
                        String subStr = allPlacementList.get(allPlacementList.size() - 1).get(index).substring(pos, pos + 4);

                        if (subStr.charAt(3) == '2' || subStr.charAt(3) == '3') {

                            allPlacementList.get(allPlacementList.size() - 1).remove(index);
                        }

                    }
                }
                number++;

            }
        }

        //Converts the final string into an array
        String[] solve = new String[10];
        int sign = 0;
        for (int s = 0; s <= (allPlacementList.get(allPlacementList.size() - 1).get(0).length()) - 4; s = s + 4) {
            String str = allPlacementList.get(allPlacementList.size() - 1).get(0).substring(s, s + 4);
            solve[sign] = str;
            sign++;

        }
        //Sort the array and convert it into a string
        Arrays.sort(solve);
        solution = "";
        for (int sol = 0; sol < solve.length; sol++) {
            solution = solution + solve[sol];
        }
        //Return the solution string
        return solution;

    }


}
