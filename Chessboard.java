/*
Change log:

02/06/2026:
Victoria Santana
- Defined board boundaries
- Implemented method for withinChessboard

*/

public class Chessboard {

    // Define constants that represent the maximum and minimum valid row number on a chessboard
    public static int MAX_ROW = 8;
    public static int MIN_ROW = 1;

    // Default constructor that does not initialize any fields
    public Chessboard(){

    }

    // Method that checks whether a given position is within the chessboard
    public boolean withinChessboard(char column, int row){

        // Check if the column is outside the valid range (a-h)
        if (column < 'a' || column > 'h'){
            return false;
        }

        //Check if the row is outside the valid range (1-8)
        if (row < MIN_ROW || row > MAX_ROW){
            return false;
        }

        //If both the column and row are valid, the position is within the chessboard
        return true;
    }
}