public class Square{
    private boolean isShip;
    private boolean isReserved;
    private boolean isChosen;

    public Square(){
        //System.out.print(" 1 ");
    }

    public boolean getIsShip(){
        return isShip;
    }

    public void setShip(){
        isShip = true;
    }

    public boolean getIsReserved(){
        return isReserved;
    }

    public void setReserved(){
        isReserved = true;
    }

    public boolean getIsChosen(){
        return isChosen;
    }

    public void setChosen(){
        isChosen = true;
    }
}