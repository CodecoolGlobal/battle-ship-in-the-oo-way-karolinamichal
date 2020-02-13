import java.util.ArrayList;

public class Ship {
    
    //private int
    private ArrayList<Square> listSquareOfShip; 
    
    public Ship(ArrayList<Square> arraySquareNewShip, ArrayList<Square> arrayFieldsReserved){
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