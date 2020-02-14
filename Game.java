public class Game{
    private boolean hasStarted; //false jeśli jesteśmy w fazie przygtowań, true gdy rozpocznie się rozgrywka

    public Game(){ // tu na razie przeniosłam wszystko z maina, ale te rzeczy trzeba będzie "rozlokować" po konkretnych metodach
        hasStarted = false;
        Ocean myOcean = new Ocean();
        myOcean.addShip(0, 0, false, 1);
        myOcean.addShip(0, 9, false, 1);
        myOcean.addShip(0, 9, false, 1);
        myOcean.addShip(9, 0, false, 1);
        myOcean.addShip(9, 9, false, 1);
        
        View view = new View();
        view.printOcean(myOcean, this);
    }

    // tu możemy zrobić 2 metody: prepare() (która odpowiada za ustawianie statków na planszy) 
    // oraz play() (która odpowiada za grę)

    public boolean getHasStarted() {
        return hasStarted;
    }
}