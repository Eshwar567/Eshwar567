import java.util.Scanner;
public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner (System.in);
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println("~~~~~~~~~~Welcome to Tic Tac Toe,Let's start playing the game against computer~~~~~~~~~~~");

            ticTacToe.play();
            System.out.println("Thanks for playing,Hope you enjoyed playing tictactoe");
    }

    private final int empty = 0;
    private final int player = 1;
    private final int com = 2;
    private final int size = 3;
    private int[][] board;
    public void printScreen()
    {
        int col;
        int row;
        System.out.println();
        System.out.print(" ");
        for (col = 0; col < size; col ++)
        {
            System.out.print(" " + (col+1));
        }
        System.out.println();
        System.out.print(" ");
        for (col = 0; col < size; col ++)
        {
            System.out.print("--");
        }
        System.out.println("-");
        for (row = 0; row < size; row ++)
        {
            System.out.print((row+1) + "|");
            for (col = 0; col < size; col ++)
            {
                if (board[row][col] == empty)
                {
                    System.out.print(" ");
                }
                else if (board[row][col] == player)
                {
                    System.out.print("X");
                }
                else if (board[row][col] == com)
                {
                    System.out.print("O");
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.print(" ");
            for (col = 0; col < size; col ++)
            {
                System.out.print("--");
            }
            System.out.println("-");
        }
    }
    public void initBoard()
    {
        int col;
        int row;
        board = new int[size][size];
        for (row = 0; row < size; row ++)
        {
            for (col = 0; col < size; col ++)
            {
                board[row][col] = empty;
            }
        }
    }
    public void computerMove()
    {
        int col;
        int row;
        int count;
        int select;
        count = 0;
        for (row = 0; row < size; row ++)
            for (col = 0; col < size; col ++)
                if (board[row][col] == empty)
                    count ++;
        select = (int) (Math.random() * count);
        count = 0;
        for (row = 0; row < size; row ++)
        {
            for (col = 0; col < size; col ++)
            {
                if (board[row][col] == empty)
                {
                    if (count == select)
                    {
                        board[row][col] = com;
                        System.out.println("The computer selects row" + (row+1) + " column " + (col+1) + ".");
                    }
                    count ++;
                }
            }
        }
    }
    public void playerMove()
    {
        Scanner console = new Scanner (System.in);
        int col;
        int row;
            System.out.println("What is your move?  Select a row number from 1 to " + size + " and a column number from 1 to " + size + ".");
            row = console.nextInt();
            col = console.nextInt(); 
            row --;
            col --;
           
             board[row][col] =player;
             printScreen();
        }
    
    public boolean checkWinner()
    {
        int col;
        int row;
        int count;
        int win;
        win = empty;
        for (row = 0; row < size; row ++)
        {
            count = 0;
            if (board[row][0] != empty)
                for (col = 0; col < size; col ++)
                    if (board[row][0] == board[row][col])
                        count ++;
            if (count == size)
                win = board[row][0];
        }
        for (col = 0; col < size; col ++)
        {
            count = 0;
            if (board[0][col] != empty)
                for (row = 0; row < size; row ++)
                    if (board[0][col] == board[row][col])
                        count ++;
            if (count == size)
                win = board[0][col];
        }
        count = 0;
        if (board[0][0] != empty)
            for (row = 0; row < size; row ++)
                if (board[0][0] == board[row][row])
                    count ++;
        if (count == size)
            win = board[0][0];
        count = 0;
        if (board[0][size-1] != empty)
            for (row = 0; row < size; row ++)
                if (board[0][size-1] == board[row][size-row-1])
                    count ++;
        if (count == size)
            win = board[0][size-1];
        if (win != empty)
        {
            if (win == player)
                System.out.println("Congrats Eshwar!! You won the game");
            else if(win == 3)
                System.out.println("Huh!!you lost the game buddy,Please try again");
            return true;
        }
        count = 0;
        for (row = 0; row < size; row ++)
            for (col = 0; col < size; col ++)
                if (board[row][col] == empty)
                    count ++;
        if (count == 0)
        {
            System.out.println("Its a tie!");
            return true;
        }
        return false;
    }
    public void play()
    {
    	initBoard();
    	
    	
        boolean gameOver = false;
        //clear();
        while (gameOver != true)
        {
            printScreen();
            playerMove();
            printScreen();
            gameOver = checkWinner();
            if (gameOver != true)
            {
                computerMove();
                gameOver = checkWinner();
                if (gameOver)
                    printScreen();
            }
        }
    }
}