import java.util.ArrayList;
import java.util.List;

public class Ship {
    
    //private int
    private List<Square> listSquareOfShip;
    
    public Ship(ArrayList<Square> arraySquareNewShip, ArrayList<Square> arrayFieldsReserved){
        listSquareOfShip = new ArrayList<Square>();
        for(Square square : arraySquareNewShip){
            square.setShip();
            listSquareOfShip.add(square);
        }

        for(Square square : arrayFieldsReserved){
            square.setReserved();
        }
    }

    public boolean isSunk(){
        for(Square square : listSquareOfShip){
            if(!square.getIsChosen()){
                return false;
            }
        }
        return true;
    }
}