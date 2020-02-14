import java.util.ArrayList;

public class Ocean{

    ArrayList<ArrayList<Square>> board;
    ArrayList<Ship> shipsArray;

    final static int WIDTH = 10;
    final static int HEIGHT = 10;
    
    public Ocean(){
        this.shipsArray = new ArrayList<Ship>();
        this.board = new ArrayList<ArrayList<Square>>();
        for(int iRow = 0; iRow < HEIGHT; iRow++ ){
            ArrayList<Square> row = new ArrayList<Square>();
            
            for(int iCol = 0; iCol < WIDTH; iCol++ ){
                Square newSquare = new Square();
                row.add(newSquare);
            }
            this.board.add(row);
        }

    }

    // public void printOcean(){
    //     for(ArrayList<Square> row : board){
    //         for(Square singleSquare : row){
    //             String symbol = singleSquare.getIsShip() ? " x " : " . ";
    //             System.out.print(symbol);               
    //         }
    //         System.out.println("");
    //     }
    // }

    public boolean addShip(int x, int y, boolean isHorizontal, int length){
        boolean isValid = validateNotHangOffEdge(x, y, isHorizontal, length);
        isValid = validateNotOverlap(x, y, isHorizontal, length);

        if(!isValid){
            return false;
        }
        ArrayList<Square> arraySquare = new ArrayList<Square>();
        ArrayList<Square> arrayFieldsReserved = new ArrayList<Square>();

        for(int index = 0; index < length; index++){
            int[] coordinates = (isHorizontal) ? new int[]{y, x+index} : new int[]{y+index, x};
            arraySquare.add(board.get(coordinates[0]).get(coordinates[1]));
            addReservedFields(coordinates[1], coordinates[0], arrayFieldsReserved);
        }
        Ship newShip = new Ship(arraySquare, arrayFieldsReserved);
        shipsArray.add(newShip);

        return true;
    }

    public boolean hasLost(){
        for(Ship ship: shipsArray){
            if(!ship.isSunk()){
                return false;
            }
        }
        return true;
    }

    private void addReservedFields(int x, int y, ArrayList<Square> arrayFieldsReserved){
        int[] arrayCol = new int[]{y+1, y+1, y, y-1, y-1, y-1, y, y+1};
        int[] arrayRow = new int[]{x, x+1, x+1, x+1, x, x-1, x-1, x-1};
        final int RESERVED_FIELDS_NUMBER = 8;
        
        for(int index = 0; index < RESERVED_FIELDS_NUMBER; index++){
            if(arrayCol[index] < WIDTH && arrayRow[index] < HEIGHT && arrayCol[index] >= 0 
               && arrayRow[index] >= 0)
                arrayFieldsReserved.add(board.get(arrayCol[index]).get(arrayRow[index]));
        }
    }

    public boolean validateNotHangOffEdge(int x, int y, boolean isHorizontal, int length){
        if(x < 0 || y < 0 ||  x > WIDTH || y > HEIGHT){
            return false;
        }
        if(isHorizontal){
            if(x+length > WIDTH){
                return false;
            }   
        }
        else{
            if(y+length > HEIGHT){
                return false;
            }
        }
        return true;
    }

    public boolean validateNotOverlap(int x, int y, boolean isHorizontal, int length){
        for(int index = 0; index < length; index++){
            
            int[] coordinates = (isHorizontal) ? new int[]{y, x+index} : new int[]{y+index, x};
            
            if(board.get(coordinates[0]).get(coordinates[1]).getIsShip() || board.get(coordinates[0]).get(coordinates[1]).getIsReserved()){
                System.out.println("Negatyw");
                return false;
            }
        }
        System.out.println("Pozytyw");
        return true;
    }
    
    public String toString(Game currentGame) {
        String boardString = "";

        for(ArrayList<Square> row : board){
            for(Square singleSquare : row){
                boardString += singleSquare.toString(currentGame);
            }
            boardString += "\n";
        }
        return boardString;
    }
}
