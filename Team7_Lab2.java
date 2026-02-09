/* Fausto Lozano, Marisol Anaya Molina, Victoria Santana 
[CS 3331] Lab 1: Programming skills assessment

This program checks whether a chess piece chosen by a user can make a valid move from a chosen starting position to another chosen target position. 
The user selects a chess piece and sets its initial location, then chooses a target location to move to.
The system determines and displays whether the move is valid or invalid.
The user can tezt additional target positions using the same starting position, or choose a different chess piece and begin again.


Change log:

01/30/2026:
Fausto Lozano
- Created main file

02/08/2026:
Victoria Santana
- Added user input for selecting a chess piece, color, and starting position
- Implemented validation for board boundaries and invalid inputs
- Added move verification logic for all chess pieces
- Enabled repeated target position checks for the same piece
- Added option to restart with a new piece or exit the program
- Debug syntax errors

*/
import java.util.Scanner;

public class Team7_Lab2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Chessboard board = new Chessboard();

        boolean playGame = true;

        while (playGame){
            ChessPieceType pieceType = null;
            while (pieceType == null){
                System.out.println("Select a chess piece (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING): ");
                String input = scanner.next().toUpperCase();

                ChessPieceType[] pieces = ChessPieceType.values();

                for (int i = 0; i < pieces.length; i++){
                    if (pieces[i].name().equals(input)){
                        pieceType = pieces[i];
                        break;
                    }
                }

                if (pieceType == null){
                    System.out.println("Invalid chess piece. Try again.");
                }
            }

            // ======== Select color ========
            Color color = null;
            while (color == null){
                System.out.println("Select a color (WHITE or BLACK): ");
                String input = scanner.next().toUpperCase();

                Color[] colors = Color.values();

                for (int i = 0; i < colors.length; i++){
                    if (colors[i].name().equals(input)){
                        color = colors[i];
                        break;
                    }
                }

                if (color == null){
                    System.out.println("Invalid color. Try again.");
                }
            }

            char currentColumn;
            int currentRow;

            while (true){
                System.out.println("Enter current column (a-h): ");
                currentColumn = scanner.next().toLowerCase().charAt(0);

                System.out.println("Enter current row (1-8): ");
                currentRow = scanner.nextInt();

                if(board.withinChessboard(currentColumn, currentRow)){
                    break;
                }
                else{
                    System.out.println("Invalid position.");
                }
            }
            
            Object piece = null;

            switch (pieceType){
                case PAWN:
                    piece = new Pawn(color, currentColumn, currentRow);
                    break;
                case ROOK:
                    piece = new Rook(color, currentColumn, currentRow);
                    break;
                case KNIGHT:
                    piece = new Knight(color, currentColumn, currentRow);
                    break;
                case BISHOP:
                    piece = new Bishop(color, currentColumn, currentRow);
                    break;
                case QUEEN:
                    piece = new Queen(color, currentColumn, currentRow);
                    break;
                case KING:
                    piece = new King(color, currentColumn, currentRow);
                    break;
            }

            boolean verifyTargetPosition = true;

            while (verifyTargetPosition){
                char targetColumn = 0;
                int targetRow = 0;

                while(true){
                    System.out.println("Enter target column (a-h): ");
                    targetColumn = scanner.next().toLowerCase().charAt(0);

                    System.out.println("Enter target row (1-8): ");
                    targetRow = scanner.nextInt();

                    if (!board.withinChessboard(targetColumn, targetRow)){
                        System.out.println("Target position is out of bounds.");
                    }
                    else if (targetColumn == currentColumn && targetRow == currentRow){
                        System.out.println("Target position must be different from current position.");
                    }
                    else{
                        break;
                    }
                }

                boolean validMove = false;

                switch (pieceType){
                    case PAWN:
                        validMove = ((Pawn) piece).verifyTarget(targetColumn, targetRow);
                        break;
                    case ROOK:
                        validMove = ((Rook) piece).verifyTarget(targetColumn, targetRow);
                        break;
                    case KNIGHT:
                        validMove = ((Knight) piece).verifyTarget(targetColumn, targetRow);
                        break;
                    case BISHOP:
                        validMove = ((Bishop) piece).verifyTarget(targetColumn, targetRow);
                        break;
                    case QUEEN:
                        validMove = ((Queen) piece).verifyTarget(targetColumn, targetRow);
                        break;
                    case KING:
                        validMove = ((King) piece).verifyTarget(targetColumn, targetRow);
                        break;
                }

                if (validMove){
                    System.out.println("Valid move!");
                    
                }
                else{
                    System.out.println("Invalid move for this piece.");
                }

                System.out.print("Do you want to try another target position with the same piece? (yes/no): ");
                String choiceTarget = scanner.next().toLowerCase();
                if (!choiceTarget.equals("yes")){
                    verifyTargetPosition = false;
                }
            }

            System.out.print("Do you want to select another piece? (yes/no): ");
            String choicePiece = scanner.next().toLowerCase();
            if (!choicePiece.equals("yes")){
                playGame = false;
            }
        }

        System.out.println("Game terminated.");
        scanner.close();
    }
}
