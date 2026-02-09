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

        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Chessboard object used to validate board positions
        Chessboard board = new Chessboard();

        // Controls whether the program coniues running
        boolean playGame = true;

        // Main loop that runsuntil user chooses to exit
        while (playGame){
            // Stores the selected chess piece type
            ChessPieceType pieceType = null;

            // Loop until a valid chess piece is selected
            while (pieceType == null){
                System.out.println("Select a chess piece (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING): ");
                String input = scanner.next().toUpperCase();

                // Get all possible chess piece types
                ChessPieceType[] pieces = ChessPieceType.values();

                // Check if the user input matches a valid piece
                for (int i = 0; i < pieces.length; i++){
                    if (pieces[i].name().equals(input)){
                        pieceType = pieces[i];
                        break;
                    }
                }

                // If no valid piece was chosen, prompt again
                if (pieceType == null){
                    System.out.println("Invalid chess piece. Try again.");
                }
            }

            // Select piece color
            Color color = null;

            // Loop until a valid color is selected
            while (color == null){
                System.out.println("Select a color (WHITE or BLACK): ");
                String input = scanner.next().toUpperCase();

                // Get all possible colors
                Color[] colors = Color.values();

                // Check if user input matches a valid color
                for (int i = 0; i < colors.length; i++){
                    if (colors[i].name().equals(input)){
                        color = colors[i];
                        break;
                    }
                }

                // If no valid color was chosen, prompt again
                if (color == null){
                    System.out.println("Invalid color. Try again.");
                }
            }

            // Variables to store the piece's starting position
            char currentColumn;
            int currentRow;

            // Loop until a valid starting position is entered
            while (true){
                System.out.println("Enter current column (a-h): ");
                currentColumn = scanner.next().toLowerCase().charAt(0);

                System.out.println("Enter current row (1-8): ");
                currentRow = scanner.nextInt();

                // Validate the position using the Chessboard class
                if(board.withinChessboard(currentColumn, currentRow)){
                    break;
                }
                else{
                    System.out.println("Invalid position.");
                }
            }

            // Object piece to store the selected chess piece
            Object piece = null;

            // Create the appropriate chess piece object based on the user's choice
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

            // Controls whether the user wants to test more target positions
            boolean verifyTargetPosition = true;

            // Loop to allow multiple target position checks for the same piece
            while (verifyTargetPosition){
                // Variables to store the target position
                char targetColumn = 0;
                int targetRow = 0;

                // Loop until a valid target position is entered
                while(true){
                    System.out.println("Enter target column (a-h): ");
                    targetColumn = scanner.next().toLowerCase().charAt(0);

                    System.out.println("Enter target row (1-8): ");
                    targetRow = scanner.nextInt();

                    // Check if target position is within the board
                    if (!board.withinChessboard(targetColumn, targetRow)){
                        System.out.println("Target position is out of bounds.");
                    }
                    // Ensure target position is not the same as the starting position
                    else if (targetColumn == currentColumn && targetRow == currentRow){
                        System.out.println("Target position must be different from current position.");
                    }
                    else{
                        break;
                    }
                }

                // Stores whether the attempted move is valid
                boolean validMove = false;

                // Call the appropriate verifyTarget method based on piece type
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

                // Display result of move verification
                if (validMove){
                    System.out.println("Valid move!");
                    
                }
                else{
                    System.out.println("Invalid move for this piece.");
                }

                // Ask the user if they want to try another target position
                System.out.print("Do you want to try another target position with the same piece? (yes/no): ");
                String choiceTarget = scanner.next().toLowerCase();

                // Exit target verification loop if the user chooses not to continue
                if (!choiceTarget.equals("yes")){
                    verifyTargetPosition = false;
                }
            }

            // Ask the user if they want to select a new piece
            System.out.print("Do you want to select another piece? (yes/no): ");
            String choicePiece = scanner.next().toLowerCase();

            // Exit main game loop if the user chooses not to continue
            if (!choicePiece.equals("yes")){
                playGame = false;
            }
        }

        // End of program
        System.out.println("Game terminated.");
        scanner.close();
    }
}