# Description
This class use to define player. 

# Fields
* name - type String - contain information about name of player.
* ocean - type Ocean - object ocean possesions to player.
* view - type View - object view use to display informations.
* possibleShips - type Hashmap - dictionary has all of ships.


# Methods
1. Player(String name)
    * The constructor get name to attribute  to field name.
    * It create new Ocean and new View.
    * It calls method askForShips.

2. hasLost()
    * call method hasLost from Ocean.
    * return result method hasLost.

3. shoot(int[] coordinates)
    * This method call method isShoot from Ocean
    * It return result method isShoot

4. isSunk(int[] coordinates)
    * This method get coordinates of Square
    * It return true if the ship contains this Square is sunk

5. askForName(String name)
    * This method get name of player
    * This method ask user about its name
    * It attribute it to field name

6. askForShips()
    * This method assign ships to Ocean in correct position.

7. getShipName()
    * 

8. getIsShipHorizontal()
    * 

9. getShipCoordinates()
    * 

10. translateFromStringToCoordinates(String coordinatesAsString)
    *       

11. getOcean()
    * 

12. getName()
    * 

13. setName(String name)
    * 
