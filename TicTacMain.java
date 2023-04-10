package TicTacToeGame;

import java.util.*;

public class TicTacMain {
    private static final Scanner keyboardInputCollector = new Scanner(System.in);
    private static final String[] players = new String[2];
    private static final Game game = new Game();
    private static int[] storeMoves = new int[9];
    private static int[] confirmRandomNumber = new int[9];
    private static int numberOfTurns = 0;


    public static void main(String[] args) {

        startGame();

    }


    private static void startGame() {
        String userInput = input("""
                -------------------------------------------------
                |          LET's PLAY TIC-TAC-TOE!!!!!!!        |
                -------------------------------------------------
                |       PRESS 1 FOR -> TWO PLAYERS              |
                -------------------------------------------------
                |       PRESS 2 TO -> GAME WITH THE COMPUTER    |
                -------------------------------------------------
                |       PRESS 3 TO -> EXIT GAME                 |
                -------------------------------------------------""");
        addNewLine();
        switch (userInput) {
            case "1" -> getMethodTwoPlayer();
            case "2" -> playWithTheComputer();
            case "3" -> exitGame();
            default -> startGame();
        }
    }

    private static void exitGame() {
        display("Game Over!!!!!!!");
        System.exit(1);
    }

    private static void playWithTheComputer() {
        playerAndComputer();
        displayTicTacToeBoardBeforeGame();
        switchPlayerBetweenComputer();


    }

    private static void playGameBetweenPlayerAndComputer(int position) {
        while (true) {
            try {
                game.takePositionForPlayerAndComputer(position);
                Game.winningPosition();
                Game.checkTie();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                position = keyboardInputCollector.nextInt();
                keyboardInputCollector.nextLine();
            }
        }
    }

//    private static int generateRandomNumber() {
//        Random random = new Random();
//        int rand;
//
//        do {
//            rand = 1 + random.nextInt(9);
//        } while (contains(confirmRandomNumber, rand));
//
//        confirmRandomNumber[numberOfTurns] = rand;
//        numberOfTurns++;
//
//        System.out.println("Random number: " + rand);
//        return rand;
//    }

    private static int generateRandomNumber() {
        Random random = new Random();
        int rand;

        do {
            rand = 1 + random.nextInt(9);
        } while (contains(confirmRandomNumber, rand, storeMoves));

        confirmRandomNumber[numberOfTurns] = rand;
        numberOfTurns++;

        return rand;
    }

    private static boolean contains(int[] confirmRandomNumber, int rand, int[] storeMoves) {

        for (int i = 0; i < confirmRandomNumber.length; i++) {
            if (confirmRandomNumber[i] == rand || storeMoves[i] == rand)
                return true;

        }
        return false;
    }

    public static void outputPlayerNameWithComputerAsGameIsOn() {
        int index = 0;
        try {
            for (String player : players) {
                if (Objects.equals(player, players[0])) {
                    display("");
                    String playerPosition = input("Mark the board " + player);
                    storeMoves[index] = Integer.parseInt(playerPosition);
                    display("");
                    playGameBetweenPlayerAndComputer(Integer.parseInt(playerPosition));
                    displayTicTacBoardAsGameIsOn();
                }

                else if (Objects.equals(player, players[1])) {
                    Time.delay();
                    storeMoves[index] = generateRandomNumber();
                    playGameBetweenPlayerAndComputer(generateRandomNumber());
                    displayTicTacBoardAsGameIsOn();
                }
                index++;

            }
        } catch (NumberFormatException error) {
            System.out.println(error.getMessage());
            keyboardInputCollector.nextLine();
        }
    }


    public static void switchPlayerBetweenComputer() {
        game.initializeGameBoardToZero();
        display("");
        try {
            do {
                outputPlayerNameWithComputerAsGameIsOn();
            } while (!Game.isWon);
        } catch (InputMismatchException | NumberFormatException | NullPointerException error) {
            display(error.getMessage());
            keyboardInputCollector.nextLine();
            display("");
        }
    }

    private static void playerAndComputer() {
        display("");
        for (int i = 0; i < players.length - 1; i++) {
            players[i] = input("Enter player name: ");
            players[i + 1] = "Robot";
            display("");
            display("My name is " + players[1]);
            display("Let's battle " + players[i]);
            display("");
        }
    }


    private static void getMethodTwoPlayer() {
        getPlayerNames();
        displayTicTacToeBoardBeforeGame();
        switchPlayer();

    }

    public static void displayTicTacToeBoardBeforeGame() {
        display("");
        game.initializeGameBoardToZero();
        for (String[] lists : Game.gameBoard) {
            display(Arrays.deepToString(lists));
        }
    }
    private static void getPlayerNames() {
        display("");
        for (int i = 0; i < players.length; i++) {
            players[i] = input("Enter name of Player " + (i + 1) + ":");
            display("");
        }
    }

    public static void switchPlayer() {
        game.initializeGameBoardToZero();
        display("");
        try {
            do {
                outputPlayerNameAsGameIsOn();
            } while (!Game.isWon);
        } catch (InputMismatchException | NumberFormatException | NullPointerException error) {
            display(error.getMessage());
            keyboardInputCollector.nextLine();
            display("");
        }
    }


    public static void outputPlayerNameAsGameIsOn() {
        try {
            for (String player : players) {
                String playerPosition = input("Mark the board player " + player);
                playGameBetweenTwoPlayers(Integer.parseInt(playerPosition));
                displayTicTacBoardAsGameIsOn();
            }
        } catch (NumberFormatException error) {
            System.out.println(error.getMessage());
            keyboardInputCollector.nextLine();
        }
    }


    private static void playGameBetweenTwoPlayers(int position) {
        while (true) {
            try {
                game.takePosition(position);
                Game.winningPosition();
                Game.checkTie();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                position = keyboardInputCollector.nextInt();
                keyboardInputCollector.nextLine();
            }
        }
    }

    public static void displayTicTacBoardAsGameIsOn() {
        for (String[] lists : Game.gameBoard) {
            display(Arrays.deepToString(lists));
        }

    }

    private static void addNewLine() {
        display("");
        display("");
    }
    
    private static void display(String prompt) {
        System.out.println(prompt);
    }
    
    
    private static String input(String prompt) {
        System.out.println(prompt);
        return keyboardInputCollector.next();
    }
}
