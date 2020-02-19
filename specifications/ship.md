__[back to README](../README.md)__

# Description
This class use to create one ship on board. 

# Fields
* listSquareOfShip - type List<Square> - This list contain squares which are part of ship 

# Methods
1. Ship(ArrayList<Square> arraySquareNewShip, ArrayList<Square> arrayFieldsReserved)
    * This costructor creates a new ship and it adds to Square of Ship to list listSquareOfShip. Later this constructor sets field isReserved on true in surrounding this ship Squares.

2. isSunk()
    * This method return true if all of Squares of Ship was shooted. If not method return false.

3. isSquareInShip(Square findSquare)
    * This method check if Ship contain findSquare. 
    * If yes return true, if not return false.

4. isShooted(Square squareWithCoordinates)
    * This method change filed chosen in Square to true value. 
    * It return true if square is part of Ship. If else return false.