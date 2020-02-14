public class Player{
    
    private String name;
    private Ocean ocean;

    public Player(){
        name = askForName();
        ocean = new Ocean();
    }

    private String askForName() {
        // tutaj metoda pytająca o imię i walidująca input
        String name = "Mariusz";
        return name;
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
