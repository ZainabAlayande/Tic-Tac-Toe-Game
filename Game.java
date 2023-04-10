package TicTacToeGame;
import TicTacToePackage.TicTacValues;
import java.util.Objects;

public class Game {
    public static String[][] gameBoard = new String[3][3];
    Player player = new Player();
    static boolean isWon;
    int row;
    int col;


    public void initializeGameBoardToZero() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = " ";
            }
        }
    }


    public String[][] displayGameBoard() {
        initializeGameBoardToZero();
        return gameBoard;
    }



    public static void checkTie() {
        if (!isWon) {
            int count = 0;
            for (String[] row : gameBoard) {
                for (String square : row) {
                    if (!square.equals(TicTacEnum.EMPTY.getName())) {
                        count++;
                    }
                }
            }
            if (count == 9) {
                isWon = true;
                printTieMessage();
            }
        }
    }

    private static void printTieMessage() {
        TicTacMain.displayTicTacBoardAsGameIsOn();
        System.out.println("No Winner!!!!! Its a tie");
        System.exit(0);
    }


    public void takePositionForPlayerAndComputer(int position){
        row = (position - 1) / 3;
        col = (position - 1) % 3;

        if (!Objects.equals(gameBoard[row][col], TicTacEnum.EMPTY.getName()))
            throw new IllegalArgumentException("Position has been taken " +
                    " Please enter a valid position:");

        validatePosition(position);
        gameBoard[row][col] = player.getNextPlayer();
    }


    public void takePosition(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (!Objects.equals(gameBoard[row][col], TicTacEnum.EMPTY.getName()))
            throw new IllegalArgumentException("Position has been taken " +
            " Please enter a valid position:");

        validatePosition(position);
        gameBoard[row][col] = player.getNextPlayer();
    }



    private static void validatePosition(int position) {
        if (position < 1 || position > 9)
            throw new IllegalArgumentException("Position can only be between 1 and 9");
    }

    public static boolean winningPosition() {

        if (gameBoard[0][0].equals(TicTacValues.X.getName()) &&
                gameBoard[0][1].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[0][2].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;
        }

        if (gameBoard[1][0].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[1][2].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;
        }


        if (gameBoard[2][0].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[2][1].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[2][2].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;
        }


        if (gameBoard[0][0].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[1][0].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[2][0].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;

        }

        if (gameBoard[0][1].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[2][1].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;
        }

        if (gameBoard[0][2].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[2][0].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;

        }

        if (gameBoard[0][2].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[1][2].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[2][2].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;
        }

        if (gameBoard[0][0].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.X.getName()) &&
                gameBoard[2][2].equalsIgnoreCase(TicTacValues.X.getName())) {
            printWinningMessage();
            isWon = true;
        }

        if (gameBoard[0][0].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[0][1].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[0][2].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;
        }

        if (gameBoard[1][0].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[1][2].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;

        }

        if (gameBoard[0][0].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[2][2].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;

        }

        if (gameBoard[2][0].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[2][1].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[2][2].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;
        }

        if (gameBoard[0][0].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[1][0].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[2][0].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;

        }

        if (gameBoard[0][1].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[2][1].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;

        }

        if (gameBoard[0][2].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[1][2].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[2][2].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;

        }

        if (gameBoard[0][2].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[1][1].equalsIgnoreCase(TicTacValues.O.getName()) &&
                gameBoard[2][0].equalsIgnoreCase(TicTacValues.O.getName())) {
            printWinningMessage();
            isWon = true;

        }
        return true;
    }



    public static void printWinningMessage() {
        TicTacMain.displayTicTacBoardAsGameIsOn();
        System.out.println("Congratulations, You won this round!!!");
        System.exit(0);
    }
}




