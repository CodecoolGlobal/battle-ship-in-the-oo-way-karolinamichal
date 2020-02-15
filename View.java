public class View{
    
    public View(){ 
        // nie wiem czy coś tu w ogóle musi być
    }

    public void printOcean(Ocean currentOcean, Game currentGame) {
        // tu będzie można dodać drukowanie nagłówka, literek ABC... etc.
        System.out.print(currentOcean.toString(currentGame));
    }

    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}