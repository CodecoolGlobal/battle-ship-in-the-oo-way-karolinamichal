import java.util.ArrayList;

public class Ocean{

    ArrayList<ArrayList<Square>> board;
    ArrayList<Ship> shipsArray;


    // x = 10 y = 8
    public Ocean(int x, int y){
        this.shipsArray = new ArrayList<Ship>();
        this.board = new ArrayList<ArrayList<Square>>(10);
        for(int iRow = 0; iRow < y; iRow++ ){
            ArrayList<Square> row = new ArrayList<Square>();
            
            for(int iCol = 0; iCol < x; iCol++ ){
                Square newSquare = new Square();
                row.add(newSquare);
            }
            this.board.add(row);
        }

    }

    public void printOcean(){
        for(ArrayList<Square> row : board){
            for(Square singleSquare : row){
                String symbol = (singleSquare.getIsShip()) ? " x " : " . ";
                System.out.print(symbol);               
            }
            System.out.println("");
        }
    }

    public void addShip(int x, int y, boolean isHorizontal, int length){
        ArrayList<Square> arraySquare = new ArrayList<Square>();
        if(isHorizontal){
            for(int index = 0; index < length; index++){
                arraySquare.add(board.get(y).get(x+index));
                
            }
        }else{
            for(int index = 0; index < length; index++){
                arraySquare.add(board.get(y+index).get(x));
            }
        }
        Ship newShip = new Ship(arraySquare);
        shipsArray.add(newShip);

      //  return newShip;
      //  board.get(x).get(y);

    }
    
}