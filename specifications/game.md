__[back to README](../README.md)__

# Description
This class use to launch game. 

# Fields
* hasStarted - type boolean - contain information about start or stop game.
* currentplayer - type Player - contain reference to actual player
* player1 - type Player - contain reference to object Player one
* player2 - type Player - contain reference to object Player two
* view - type View - use to launch view methods

# Methods
1. Game()
    * This contructor launchs new game object and prepares new game.

2. prepareToGame()
    * This method create two objects type Player and set currentPlayer field

3. playGame()
    * This method:
        * get coordinates from user.
        * sent coordinates to shoot method.
        * display information about hit or miss.
        * check coondition about end of game.

4. shoot(int[] coordinatesAsInt)
    * this method return information about hit or miss.

5. getCoordinates(String coordinatesAsString)
    * this method convert coordinates from string format to int array.

6. getHasStarted()
    * this method return value of field hasStarted.

7. turnOfPlayer()
    * this method return name of current player.

8. changeCurrentPlayer()
    * This method change value field currentPlayer.

9. checkCoordinates(String coordinatesAsString)
    * this method check if coordinatesAsString contain correct value.
    * If it is true, method return true, else return false.

10. transformToCorrectCoordinates(String coordinatesAsString)
    * This method check if input from user is not obverse.
    * If it is true, method set coordinates in correct place.
    * Method return coordiantesAsString.

11. translateFromStringToCoordinates(String[] coordinatesAsString)
    * This method convert coordinates from String format to int array.
    * And next method return int array of coordinates.

12. isNumeric(String strNum)
    * This method check if strNum contain __only__ number.
    * If it's return true, if not return false. 
    