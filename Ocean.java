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

    public void printOcean(){
        for(ArrayList<Square> row : board){
            for(Square singleSquare : row){
                String symbol = (singleSquare.getIsShip()) ? " x " : " . ";
                System.out.print(symbol);               
            }
            System.out.println("");
        }
    }

    public boolean addShip(int x, int y, boolean isHorizontal, int length){
        boolean isValid = validateHangOffEdge(x, y, isHorizontal, length);
        isValid = validateOverlap(x, y, isHorizontal, length);

        if(!isValid){
            return false;
        }
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

        return true;

    }

    public boolean validateHangOffEdge(int x, int y, boolean isHorizontal, int length){
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

    public boolean validateOverlap(int x, int y, boolean isHorizontal, int length){
        if(isHorizontal){
            for(int index = 0; index < length ; index++){
                if(board.get(y).get(x + index).getIsShip()){
                    System.out.println("Negatyw");
                    return false;
                }
            
            }
        }
        else{
            for(int index = 0; index < length ; index++){
                if(board.get(y + index).get(x).getIsShip()){
                    System.out.println("Negatyw");
                    return false;
                }
            
            }
        }
        System.out.println("Pozytyw");
        return true;
    }
    
}