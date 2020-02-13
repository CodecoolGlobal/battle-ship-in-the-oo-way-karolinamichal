public class Main{
    public static void main(String[] args){
        Ocean myOcean = new Ocean();
        myOcean.addShip(0, 0, false, 1);
        myOcean.addShip(1, 0, false, 1);
        myOcean.addShip(9, 0, false, 1);
        myOcean.addShip(9, 9, false, 1);
        myOcean.printOcean();
    }
}