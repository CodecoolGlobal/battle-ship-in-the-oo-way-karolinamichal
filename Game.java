public class Game{
    private boolean hasStarted; //false jeśli jesteśmy w fazie przygtowań, true gdy rozpocznie się rozgrywka
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    public View view = new View();

    public Game(){ 
        hasStarted = false;
        prepareToGame();
        playGame();
    }

    public void prepareToGame() {
        player1 = new Player("first");
        player2 = new Player("second");
        
        currentPlayer = player1;
        // tu jakieś metody wywołane w celu "postawienia" statków przez playera

        // do celów testowych:
        view.printOcean(player1.getOcean(),hasStarted);
        currentPlayer.getOcean().addShip(0, 0, false, 1);
        currentPlayer.getOcean().addShip(0, 9, false, 1);
        currentPlayer.getOcean().addShip(0, 9, false, 1);
        currentPlayer.getOcean().addShip(9, 0, false, 1);
        currentPlayer.getOcean().addShip(9, 9, false, 1);
        view.printOcean(player1.getOcean(), hasStarted);
    }

    

    public void playGame() {
        // główna pętla odpowiadająca za rozgrywkę ?
        hasStarted = true;
        int[] coordinates = chooseFieldToStrike("1G");
        currentPlayer.getOcean().shoot(coordinates[0], coordinates[1]);
        currentPlayer.getOcean().shoot(0, 0);
        currentPlayer.getOcean().shoot(0, 1);
        // do celów testowych:
        view.printOcean(currentPlayer.getOcean(), hasStarted);
    }

    public boolean getHasStarted() {
        return hasStarted;
    }

    public void changeCurrentPlayer() {
        if (currentPlayer.getName() == player1.getName()) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public int[] chooseFieldToStrike(String coordinatesAsString){
        String[] alfabet = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int lenghtArrayOfAlfabet = alfabet.length;
        int X_INDEX = 1;
        int Y_INDEX = 0;
        int[] coordinatesAsInt = new int[] {1, 2};
        String xAsString = coordinatesAsString.substring(0,1);
        String yAsString = coordinatesAsString.substring(1,2);
        coordinatesAsInt[X_INDEX] = Integer.parseInt(xAsString) - 1;
        for(int index = 0; index < lenghtArrayOfAlfabet; index++){
            if(yAsString.equals(alfabet[index])){
                coordinatesAsInt[Y_INDEX] = index;
            }
        }


        return coordinatesAsInt;
    }
}