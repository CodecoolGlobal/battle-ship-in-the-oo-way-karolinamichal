import java.util.ArrayList;

public class Ship {
    
    //private int 
    
    public Ship(ArrayList<Square> arraySquareNewShip){
        for(Square square : arraySquareNewShip){
            square.setShip();
        }
    }
}