package TicTacToeGame;

public class Player {
    int count = 2;
    private String name;
    private String currentPlayer = TicTacEnum.O.getName();


    public Player() {
    }

    public int getCount() {
        return count;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNextPlayer() {

        if (currentPlayer.equals("O")) {
            currentPlayer = "X";
        } else {
            currentPlayer = "O";
        }
        return currentPlayer;
    }

}
