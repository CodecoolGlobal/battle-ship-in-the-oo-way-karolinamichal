import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Player {
    
    private String name;
    private Ocean ocean;
    private View view;
    private HashMap<String, Integer> possibleShips;
    {
        possibleShips = new HashMap<>();
        possibleShips.put("Carrier", 5);
        possibleShips.put("Battleship", 4);
        possibleShips.put("Cruiser", 3);
        possibleShips.put("Submarine", 3);
        possibleShips.put("Destroyer", 2);
    }

    public Player(String num){
        askForName(num);
        ocean = new Ocean();
        view = new View();
        ocean.addShip(1,1,true, 2);
        //askForShips();// <--- odkomentować do właściwej gry!!!

    }

    public boolean hasLost(){
        return ocean.hasLost();
    }

    public boolean shoot(int[] coordinates){
        return ocean.isShoot(coordinates[0],coordinates[1]);
    }

    public boolean isSunk(int[] coordinates){
        return ocean.isSunk(coordinates[0], coordinates[1]);
    }

    public void askForName(String num) {
        view = new View();
        view.clearScreen();
        name = view.inputFromUser(String.format("Please insert name of the %s user", num));
        while (name.length() < 1) {
            System.out.println("Your name should consist of at least 1 character");
            name = view.inputFromUser(String.format("Please insert name of the %s user", num));
        }
    }

    public void askForShips() { 
        
        while (possibleShips.size() > 0) {
            view.clearScreen();
            String title = String.format("%s - time to place your ships!", name);
            view.printTitle(title);
            view.printOcean(ocean, false);
            view.printPossibleShips(possibleShips);
            
            String shipName = getShipName();
            int shipLength = possibleShips.get(shipName);
            boolean isHorizontal = getIsShipHorizontal();
            int[] coordinates = getShipCoordinates();

            boolean isAdded = ocean.addShip(coordinates[0], coordinates[1], isHorizontal, shipLength);

            if (isAdded) {
                possibleShips.remove(shipName);
            } else {
                System.out.println("You can't put your ship there. Try again!"); // może to dobre miejsce na łapanie wyjątków z addship?
            }
        }
    }
    
    public String getShipName() {
        String shipName = view.inputFromUser("Please type in the name of the ship you choose");
        shipName = shipName.substring(0, 1).toUpperCase() + shipName.substring(1).toLowerCase();
        
        while (!possibleShips.containsKey(shipName)){
            System.out.println("This name is not on the list of permitted ships"); 
            shipName = view.inputFromUser("Please type in the name of the ship you choose");
            shipName = shipName.substring(0, 1).toUpperCase() + shipName.substring(1).toLowerCase();
        }
        return shipName;
    }

    public boolean getIsShipHorizontal() {
        String position = view.inputFromUser("Please type H if you want your ship to be HORIZONTAL or V if VERTICAL").toUpperCase();
            while (!position.equals("H") && !position.equals("V")) {
                System.out.println(position);
                System.out.println("Wrong input.");
                position = view.inputFromUser("Please type H if you want your ship to be HORIZONTAL or V if VERTICAL").toUpperCase();
            }
        boolean isHorizontal = (position.equals("H")) ? true : false;
        
        return isHorizontal;
    }

    public int[] getShipCoordinates() {
        String coordinates = view.inputFromUser("What is the starting point of your ship? Type it in '1A' format").toUpperCase();
        String[] possibleNumbers = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List<String> possibleNumbersList = Arrays.asList(possibleNumbers);
        String[] possibleLetters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        List<String> possibleLettersList = Arrays.asList(possibleLetters);
        String firstSign = (coordinates.length() > 2) ? coordinates.substring(0,2) : coordinates.substring(0,1);
        String secondSign = (coordinates.length() > 2) ? coordinates.substring(2) : coordinates.substring(1);
        
        while (!possibleLettersList.contains(secondSign) || !possibleNumbersList.contains(firstSign) || (coordinates.length() > 2 && !coordinates.substring(0,2).equals("10"))) {
            coordinates = view.inputFromUser("What is the starting point of your ship? Type it in '1A' format").toUpperCase();
            firstSign = (coordinates.length() > 2) ? coordinates.substring(0,2) : coordinates.substring(0,1);
            secondSign = (coordinates.length() > 2) ? coordinates.substring(2) : coordinates.substring(1);
        }
        int[] finalCoordinates = translateFromStringToCoordinates(coordinates);

        return finalCoordinates;
    }

    public int[] translateFromStringToCoordinates(String coordinatesAsString){
        // skopiowałam tą funkcję z game() bo potrzebowałam jej tutaj
        String[] alfabet = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int lenghtArrayOfAlfabet = alfabet.length;
        int X_INDEX = 1;
        int Y_INDEX = 0;
        int[] coordinatesAsInt = new int[] {1, 2};
        String xAsString = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(0,2) : coordinatesAsString.substring(0,1);
        String yAsString = (coordinatesAsString.length() > 2) ? coordinatesAsString.substring(2) : coordinatesAsString.substring(1);
        
        coordinatesAsInt[X_INDEX] = Integer.parseInt(xAsString) - 1;
        
        for(int index = 0; index < lenghtArrayOfAlfabet; index++){
            if(yAsString.equals(alfabet[index])){
                coordinatesAsInt[Y_INDEX] = index;
            }
        }
        return coordinatesAsInt;
    }

    public Ocean getOcean() {
        return ocean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
