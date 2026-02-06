public class Chessboard {
    public static int MAX_ROW = 8;
    public static int MIN_ROW = 1;


    public ChessBoard(){

    }

    public boolean withinChessboard(char column, int row){

        if (column < 'a' || column > 'h'){
            return false;
        }

        if (row < MIN_ROW || row > MAX_ROW){
            return false;
        }

        return false;
    }
}
