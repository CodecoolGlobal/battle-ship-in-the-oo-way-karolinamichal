__[back to README](../README.md)__

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
    * This method gets name of player
    * This method asks user about its name
    * It attributes answer to field name

6. askForShips()
    * This method assigns ships to Ocean in a correct position.

7. getShipName()
    * This method asks user about what type of ship user would like put in ocean.
    * The method return name of ship in String type

8. getIsShipHorizontal()
    * This method asks user about setting ship in board, horizontal or vertical.
    * If a answer is horizontal the method return true.
    * If a answer is vertical the method return false.

9. getShipCoordinates()
    * This method asks user about coordinaters new ship.
    * When coordinaters are correct method return coordinaters as array of int.

10. translateFromStringToCoordinates(String coordinatesAsString)
    * This method transforms coordinaters from String type to int array type.
    * The method returns array of int. 

11. getOcean()
    * This method returns ocean field.

12. getName()
    * This method returns name field.

13. setName(String name)
    * This method sets name field.
