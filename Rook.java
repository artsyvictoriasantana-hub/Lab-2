public class Rook {
    // Attributes
    private Color color;
    private char column;
    private int row;

    // Constructors
    public Rook(){

    }

    public Rook(Color colorIn, char columnIn, int rowIn){
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
        return (column != this.column || row != this.row) && (this.column == column || this.row == row);
    }
}
