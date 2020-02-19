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
    * 

3. isSunk(int x, int y)
    * 

4. addShip(int x, int y, boolean isHorizontal, int length)
    * 

5. hasLost()
    * 

6. addReservedFields(int x, int y, List<Square> arrayFieldsReserved)
    * 

7. validateNotHangOffEdge(int x, int y, boolean isHorizontal, int length)
    * 

8. validateNotOverlap(int x, int y, boolean isHorizontal, int length)
    * 

9. toString(boolean hasGameStarted)
    * 
