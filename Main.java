import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello from Tic-Tac-Toe Folder!!! ");

// initial board
        char [][] board = new char[3][3];
        for(int row=0;row<3;row++ ){
            for(int col=0; col<3; col++) {
                board[row][col]=' ';
            }
        }
//inputs
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Initial Board : \n");
        printboard(board);
        while(!gameOver){
//            printboard(board);
            System.out.println("Player: "+player+", Enter : ");
            System.out.print("\tRow(0~2): ");
            int row = sc.nextInt();
            System.out.print("\tCol(0~2): " );
            int col = sc.nextInt();
            System.out.println();

            if (board[row][col]==' '){
                board[row][col]=player;
                gameOver = isgameOver(board,player);
                if (gameOver){
                    System.out.println("Player :"+player+" Won !!!");
                }else{
                    player = player=='X'?'O':'X';
                }
            }
            else{
                System.out.println("Enter Valid Input !!!, try again!");
            }

            printboard(board);
        }
    }
//checking winning conditions
    private static boolean isgameOver(char[][] board, char player) {
        //checking the rows
        for(char[] row : board){
            if(row[0]!=' ' && row[0]==row[1] && row[1]==row[2]){
                return true;
            }
        }
        //checking the col
        for (int col = 0; col<3; col++){
            if(board[0][col]!=' '           &&
               board[0][col]==board[1][col] &&
               board[1][col]==board[2][col] ){
                return true;
            }
        }
        //checking the diagonal
        if(board[0][0]!=' ' &&
                board[0][0]==board[1][1] &&
                board[1][1]==board[2][2] ){
            return true;
        }
        if(board[0][2]!=' ' &&
                board[0][2]==board[1][1] &&
                board[1][1]==board[2][0] ){
            return true;
        }
        return false;
    }
//print board
    private static void printboard(char[][] board) {
        for(int row=0;row<3;row++ ){
            if(row ==0) System.out.println("   0  1  2");
            System.out.println("  ----------");
            for(int col=0; col<3; col++) {
                if(col==0){
                    System.out.print(row+" |");
                }
                else{
                    System.out.print(" |");
                }
                System.out.print(board[row][col]);
                if(col==2) System.out.print(" |");
            }
            if (row==2)System.out.println("\n  ----------");
            System.out.println();
//            System.out.println(" -- -- --");

        }

    }

}
