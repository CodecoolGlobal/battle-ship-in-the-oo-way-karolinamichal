import java.util.ArrayList;

public class Ship {
    
    //private int 
    
    public Ship(ArrayList<Square> arraySquareNewShip, ArrayList<Square> arrayFieldsReserved){
        for(Square square : arraySquareNewShip){
            square.setShip();
        }

        for(Square square : arrayFieldsReserved){
            square.setReserved();
        }
    }
}