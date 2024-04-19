import java.util.Scanner;
public class TicTacToe
{
    // Declare global variables
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    // main method
    public static void main(String[] args)
    {
        // Declare variables
        Scanner in = new Scanner(System.in);
        String player = "X";
        int moves = 1;
        int row = 0;
        int col = 0;


        do // loop for if user wants to play again
        {
            clearBoard();
            do // loop while no win or tie
            {
                // toggle player
                if (moves % 2 == 0)
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }

                System.out.println("player " + player);

                boolean loop = false;
                do // loop until player chooses an empty square
                {
                    display();
                    row = SafeInput.getRangedInt(in, "Enter the row coordinate for your move(1-3)", 1,3) - 1;
                    col = SafeInput.getRangedInt(in, "Enter the column coordinate for your move(1-3)", 1,3) - 1;


                    // check to make sure the coordinates are empty
                    if (board[row][col].equals("X") || board[row][col].equals("O"))
                    {
                        System.out.println("Invalid move");
                        loop = true;
                    }
                    else
                    {
                        board[row][col] = player;
                        moves++;
                        loop = false;
                    }
                }
                while (loop == true);
            }
            while (isWin(player) == false && isTie() == false);

            // display results
            display();
            if (isTie() == true && isWin(player) == false)
            {
                System.out.println("Its a tie!");
            }
            else
            {
                System.out.println(player + " wins!!!");
            }
        }
        while(SafeInput.getYNConfirm(in,"Would you like to play again?") == true);
    }

    private static void clearBoard()
    {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }
    private static void display()
    {
        for (int col = 0; col < COL; col++)
        {
            for (int row = 0; row < ROW; row++)
            {
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }

    }
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if (board[row][col].equals(""))
        {
            retVal = true;
        }

        return retVal;
    }

    // Win condition methods
    // _____________________
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }

        }
        return false;
    }
    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }

        }
        return false;
    }
    private static boolean isDiagonalWin(String player)
    {
        boolean topCorners = false;
        boolean middle = false;
        boolean bottomCorners = false;

        for (int row = 0; row < ROW; row++) {
            if (row == 0 || row == 2) {
                if (board[row][0].equals(player) && board[row][2].equals(player)) {
                    if (row == 0) {
                        topCorners = true;
                    } else if (row == 2) {
                        bottomCorners = true;
                    }
                }
            } else if (row == 1) {
                if (board[row][1].equals(player)) {
                    middle = true;
                }
            }
        }
        if (topCorners == true && middle == true && bottomCorners == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private static boolean isTie()
    {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                if (board[row][col].equals(" "))
                {
                    return false;
                }
            }
        }
        return true;
    }
}