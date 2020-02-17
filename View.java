import java.util.Scanner;

public class View {
    
    public View(){ 
        // nie wiem czy coś tu w ogóle musi być
    }

    public void printOcean(Ocean currentOcean, Game currentGame) {
        // tu będzie można dodać drukowanie nagłówka, literek ABC... etc.
        System.out.println(currentOcean.toString(currentGame));
    }

    public String inputFromUser(String textToView){
        System.out.println(textToView + ":");
        Scanner scannerFromUser = new Scanner(System.in);
        String input = scannerFromUser.nextLine();

        return input;
    }

    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}