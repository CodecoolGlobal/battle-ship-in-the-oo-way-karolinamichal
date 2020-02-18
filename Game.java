import java.util.regex.Pattern;

public class Game {
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
        player1.getOcean().addShip(0, 0, true, 2);
        player2.getOcean().addShip(0, 0, false, 2);
        
        currentPlayer = player2;
    }

    public void playGame() {
        hasStarted = true;
        // do celów testowych:
        // int[] coordinates = translateFromStringToCoordinates("3C");
        // System.out.println(coordinates[0]);
        // System.out.println(coordinates[1]);
        // currentPlayer.getOcean().shoot(coordinates[0], coordinates[1]);
        // currentPlayer.getOcean().shoot(0, 0);
        // currentPlayer.getOcean().shoot(0, 1);
        String textToDisplay = "";
        boolean isGamming = true; 
        while(isGamming){
            view.clearScreen();
            view.printText(String.format("Turn of %s", turnOfPlayer()));
            view.printOcean(currentPlayer.getOcean(), hasStarted);
            String coordinatesAsString = view.inputFromUser("Please insert a coordinates to attack");
            int[] coordinatesAsInt = translateFromStringToCoordinates(coordinatesAsString);
            boolean wasShoot = currentPlayer.shoot(coordinatesAsInt);
            textToDisplay = wasShoot ? "You hit!" : "You miss!" ;
            wasShoot = currentPlayer.isSunk(coordinatesAsInt);
            textToDisplay = wasShoot ? "Hit and sunk!": textToDisplay;
            view.printText(textToDisplay);
            if(player1.hasLost() || player2.hasLost()){
                isGamming = false;
            }
            else{
                changeCurrentPlayer();
                view.inputFromUser("Press Enter to continue");
            }
        }

        view.printText(String.format("Congratoulations %s! You Win!", turnOfPlayer()));
        
        
        // change current player
    }

    public boolean getHasStarted() {
        return hasStarted;
    }

    public String turnOfPlayer(){
        if (currentPlayer == player1) {
            return player2.getName();
        } else {
            return player1.getName();
        }
    }

    public void changeCurrentPlayer() {
        if (currentPlayer.getName() == player1.getName()) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean checkCoordinates(String coordinatesAsString){
        Pattern pattern = Pattern.compile("([1-9][0]?[A-J])|([A-J][0-9][0]?)");
        if (coordinatesAsString == null) {
            return false; 
        }
        return pattern.matcher(coordinatesAsString).matches();
    }

    public String[] transformToCorrectCoordinates(String coordinatesAsString){
        Pattern pattern = Pattern.compile("([1-9][0]?[A-J])");
        String[] arrayCoordinates = new String[] {"", ""};

        if(pattern.matcher(coordinatesAsString).matches()){
            arrayCoordinates[0] = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(0,2) : coordinatesAsString.substring(0,1);
            arrayCoordinates[1] = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(2) : coordinatesAsString.substring(1);
        }else{
            arrayCoordinates[0] = coordinatesAsString.substring(0,1);
            arrayCoordinates[1] = coordinatesAsString.length() > 2 ? coordinatesAsString.substring(1,3) : coordinatesAsString.substring(1,2);
        }        
        
        return arrayCoordinates;
    }
    
    public int[] translateFromStringToCoordinates(String[] coordinatesAsString){
        String[] alfabet = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int lenghtArrayOfAlfabet = alfabet.length;
        int X_INDEX = 1;
        int Y_INDEX = 0;
        int[] coordinatesAsInt = new int[] {-1, -1};
        String xAsString = coordinatesAsString[X_INDEX];
        String yAsString = coordinatesAsString[Y_INDEX];
        
        if(!isNumeric(xAsString)){
            String temp = xAsString;
            xAsString = yAsString;
            yAsString = temp;
        }
        coordinatesAsInt[X_INDEX] = Integer.parseInt(xAsString) - 1;
        for(int index = 0; index < lenghtArrayOfAlfabet; index++){
            if(yAsString.equals(alfabet[index])){
                coordinatesAsInt[Y_INDEX] = index;
            }
        }

        return coordinatesAsInt;
    }

    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("\\d+");

        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }
}