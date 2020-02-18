# Description
This class use to create one ship on board. 

# Fields
* listSquareOfShip - type List<Square> - This list contain squares which are part of ship 

# Methods
1. Ship(ArrayList<Square> arraySquareNewShip, ArrayList<Square> arrayFieldsReserved)
    * This costructor creates a new ship and it adds to Square of Ship to list listSquareOfShip. Later this constructor sets field isReserved on true in surrounding this ship Squares.

1. getIsShip()
    * This method return value(boolean) of fields isShip.
    
2. setShip()
    * This method set field isShip as true.
    * This method doesn't have return value.

3. getIsReserved()
    * This method return value(boolean) of fields isReserved.

4. setReserved()
    * This method set field isReserved as true.
    * This method doesn't have return value.

5. getIsChosen()
    * This method return value(boolean) of fields isChosen.

6. setChosen()
    * This method set field isChosen as true.
    * This method doesn't have return value.

7. toString(Game currentGame)
    * This method return Square as a String.
    * It gets one parameter:
        * currentGame as a type of Game. 
    

