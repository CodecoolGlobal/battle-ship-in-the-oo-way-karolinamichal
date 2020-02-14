public class View{
    
    public View(){ 
        // nie wiem czy coś tu w ogóle musi być
    }

    public void printOcean(Ocean currentOcean, Game currentGame) {
        System.out.print(currentOcean.toString(currentGame));
    }
}