__[back to README](../README.md)__

# Description
This class use to define ocean for each player. 

# Fields
* board - type List<ArrayList<Square>> - It is list of list of Squares.
* shipsArray - type List<Ship> - List contain Ships.
* WIDTH - type final int - width of board.
* HEIGTH - type final int - heigth of board.

# Methods
1. Ocean()
    * The constructor fills board squares.

2. isShoot(int x, int y)
    * This method return true if coordinates indicate part of a ship.
    * If not method return false.

3. isSunk(int x, int y)
    * This method return true if coordinates indicate part of sunken ship.
    * If not method return false.

4. addShip(int x, int y, boolean isHorizontal, int length)
    * This method add new ship to Ocean.

5. hasLost()
    * This method check if all ship in Ocean is sunk.
    * If it is return true, if it is not return false.

6. addReservedFields(int x, int y, List<Square> arrayFieldsReserved)
    * This method add Square around new ship to array arrayFieldsReserved.

7. validateNotHangOffEdge(int x, int y, boolean isHorizontal, int length)
    * This method check if is possible add new ship about this parameter to board.
    * If it's possible return true.
    * If it's inpossible return false. 

8. validateNotOverlap(int x, int y, boolean isHorizontal, int length)
    * This method check if new ship can be put in these coordinates
    * If these coordinates are occupied by other ship method will return false.
    * If these coordinates are free return true.

9. toString(boolean hasGameStarted)
    * This method use to print board in human-frendly view.
