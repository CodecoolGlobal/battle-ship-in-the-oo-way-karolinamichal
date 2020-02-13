public class Main{
    public static void main(String[] args){
        Ocean myOcean = new Ocean(9,9);
        myOcean.addShip(0, 0, true, 2);
        myOcean.printOcean();
    }
}