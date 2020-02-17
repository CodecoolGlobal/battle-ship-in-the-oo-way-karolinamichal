import java.util.HashMap;

public class Player {
    
    private String name;
    private Ocean ocean;
    private View view;
    private static HashMap<String, Integer> possibleShips;
    static {
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
        addShipsForPlayer();
    }

    public void askForName(String num) {
        view = new View();
        name = view.inputFromUser(String.format("Please insert name of the %s user", num));
        while (name.length() < 1) {
            System.out.println("Your name should consist of at least 1 character");
            name = view.inputFromUser(String.format("Please insert name of the %s user", num));
        }
    }

    public void addShipsForPlayer() {
        while (possibleShips.size() > 0) {
            view.clearScreen();
            String title = String.format("%s - time to place your ships!", name);
            view.printTitle(title);
            view.printOcean(ocean, false);
            view.printPossibleShips(possibleShips);
            String shipName = view.inputFromUser("Please type in the name of the ship you choose");
            shipName = shipName.substring(0, 1).toUpperCase() + shipName.substring(1).toLowerCase();
            while (!possibleShips.containsKey(shipName)){
                System.out.println("This name is not on the list of permitted ships"); 
                shipName = view.inputFromUser("Please type in the name of the ship you choose");
                shipName = shipName.substring(0, 1).toUpperCase() + shipName.substring(1).toLowerCase();
            }
            int numberOfCells = possibleShips.get(shipName);
            possibleShips.remove(shipName);

            String position = view.inputFromUser("Please type H if you want your ship to be HORIZONTAL or V if VERTICAL");
            String[] possibleAnswers = ["H", "h", "V", "v"];
            while 
            // add ship
            // print ocean (albo na początku?)
        }
        
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
