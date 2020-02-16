public class Game{
    private boolean hasStarted; //false jeśli jesteśmy w fazie przygtowań, true gdy rozpocznie się rozgrywka
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    public View view = new View();

    public Game(){ 
        hasStarted = false;
        // 
        
        
        // view.printOcean(myOcean, this);
        prepareToGame();
        playGame();
    }

    public void prepareToGame() {
        player1 = new Player();
        player2 = new Player();
        currentPlayer = player1;
        // tu jakieś metody wywołane w celu "postawienia" statków przez playera

        // do celów testowych:
        view.printOcean(player1.getOcean(), this);
        currentPlayer.getOcean().addShip(0, 0, false, 1);
        currentPlayer.getOcean().addShip(0, 9, false, 1);
        currentPlayer.getOcean().addShip(0, 9, false, 1);
        currentPlayer.getOcean().addShip(9, 0, false, 1);
        currentPlayer.getOcean().addShip(9, 9, false, 1);
        view.printOcean(player1.getOcean(), this);
    }

    public void playGame() {
        // główna pętla odpowiadająca za rozgrywkę ?
        hasStarted = true;

        currentPlayer.getOcean().shoot(0,0);
        currentPlayer.getOcean().shoot(0,1);
        // do celów testowych:
        view.printOcean(currentPlayer.getOcean(), this);
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
}