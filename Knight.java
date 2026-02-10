public class Knight {
    // Attributes
    private Color color;
    private char column;
    private int row;

    // Constructors
    public Knight(){

    }

    public Knight(Color colorIn, char columnIn, int rowIn){
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
        int colDiff = Math.abs(column - this.column);
        int rowDiff = Math.abs(row - this.row);

        return (colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2);
    }
}
