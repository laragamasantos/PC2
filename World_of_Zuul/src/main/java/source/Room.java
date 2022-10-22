package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

class Room 
{
    private String roomDescription;
    private String hideInformation;
    private HashMap<String, String> Map;
    private ArrayList<Item> roomItem;
    
    /*
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    
    //ADICIONAR SAIDAS PARA CIMA E PARA BAIXO
    public Room upstairsExit;
    public Room downstairsExit;
    */

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Room(String description, String hideInformation, String roomN, String roomS, 
            String roomE, String roomW, String roomUP, String roomDOWN) 
    {
        this.roomDescription = description;
        this.hideInformation = hideInformation;
        
        this.roomItem = new ArrayList();
        
        this.Map = new HashMap<>();
        this.Map.put("north", roomN);
        this.Map.put("south", roomS);
        this.Map.put("east", roomE);
        this.Map.put("west", roomW);
        this.Map.put("upstairs", roomUP);
        this.Map.put("downstairs", roomDOWN);

    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    
    /*
    public void setExits(Room north, Room east, Room south, Room west, Room upstairs, Room downstairs) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        
        //ADICIONAR NOVAS SAIDAS CIMA E BAIXO
        if(upstairs != null)
            upstairsExit = upstairs;
        if(downstairs != null)
            downstairsExit = downstairs;
    }
    */

    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public void addItem(Item item){
        this.roomItem.add(item);
    }
    
    public void removeItem(Item item){
        this.roomItem.remove(item);
    }
    
    public String getRoomDescription()
    {
        return roomDescription;
    }

    public HashMap<String, String> getMap() {
        return Map;
    }

    public void setMap(HashMap<String, String> Map) {
        this.Map = Map;
    }

    public String getHideInformation() {
        return hideInformation;
    }

    public void setHideInformation(String hideInformation) {
        this.hideInformation = hideInformation;
    }

    public Item getAllItems() {
        for(Item item : this.roomItem){
            return item;
        }
        
      return null;  
    }

    public ArrayList<Item> getRoomItem() {
        return roomItem;
    }

    
    public void setRoomItem(ArrayList<Item> roomItem) {
        this.roomItem = roomItem;
    }

    
}