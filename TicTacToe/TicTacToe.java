package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentp = 'X';
    private static Scanner input = new Scanner(System.in);

    public static void emptyBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2)
                    System.out.print("|");
            }
            System.out.println();
            if (i < 2)
                System.out.println("  -----");

        }
    }
    public static void move(){
        int row,col;
        while (true) {
            row = input.nextInt();
            col = input.nextInt();
            if (row>=0 && col>=0 && row<3 && col<3 && board[row][col] == ' ') {
                board[row][col] = currentp;
                break;
            }
            else {
                System.out.println("Invalid Move Please Try Again");
            }
        }
    }
    public static void switchp(){
        if (currentp == 'X') {
            currentp = 'O';
        }
        else if (currentp == 'O') {
            currentp = 'X';
        }
    }
    public static boolean full(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkWinner(){
        for (int i = 0; i < 3; i++) {
            if(board[i][0]!= ' ' && board[i][0]== board[i][1] && board[i][1] == board[i][2]){
                System.out.println("Player "+board[i][0]+" is the winner");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(board[0][i]!= ' ' && board[0][i]== board[1][i] && board[1][i] == board[2][i]){
                System.out.println("Player "+board[0][i]+" is the winner");
                return true;
            }
        }
        if(board[0][0]!= ' ' && board[0][0]== board[1][1] && board[1][1] == board[2][2]) {
            System.out.println("Player "+board[0][0]+" is the winner");
            return true;
        }
        if(board[0][2]!= ' ' && board[0][2]== board[1][1] && board[1][1] == board[2][0]) {
            System.out.println("Player "+board[0][2]+" is the winner");
            return true;
        }
        if(full()){
            System.out.println("No Body Wins");
            return true;
        }
        return false;

    }
    public static void play(){
        emptyBoard();
        printBoard();
        while(true){
            move();
            printBoard();
            if(checkWinner()){
                break;
            }
            switchp();
        }
        input.close();
    }

}
