package TicTacToeGame;

public class Time {

    protected static void delay()  {
        System.out.println("");
        System.out.print("Robot is playing");
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println();

    }

}
