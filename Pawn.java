public class Pawn {
    // Attributes
    private Color color;
    private char column;
    private int row;

    // Constructors
    public Pawn(){

    }

    public Pawn(Color colorIn, char columnIn, int rowIn){
        this.color = colorIn;
        this.column = columnIn;
        this.row = rowIn;
    }

    // Getters
    public Color getColor(){
        return this.color;
    }

    public char getColumn(){
        return this.column;
    }

    public int getRow(){
        return this.row;
    }

    // Setters
    public void setColumn(char columnIn){
        this.column = columnIn;
    }

    public void setRow(char rowIn){
        this.row = rowIn;
    }

    public boolean verifyTarget(char column, int row){
        if (this.color == Color.WHITE) {
            return this.column == column && this.row == row + 1;
        } else {
            return this.column == column && this.row == row - 1;
        }
    }
}