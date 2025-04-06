    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.util.HashMap;

/**
 *
 * @author naglis
 */

/**
 * Represents a ship in the game.
 */
public abstract class Ship 
{

    /** Enum class for the ship's state
    */
    ShipState state;
    
    /** How much the ship costs as an int
    */
    int commissionFee;
    
    /** Name of the ship in a String
    */
    String name;
    
    /** Captain of the ship in a String
    */
    String Captain;
    
    /** Battle skill of the ship as an int
    */
    int battleSkill;
    
    /** How many decks in the ship as an int
    */
    int decks;
    
    /** How many marines are carried in the ship as an int
    */
    int marines;
    
    /** Amount of cannons on the ship as an int
    */
    int cannons;
    
    /** The type of ship (this will be an override attribute)
    */
    String type;
    
    /** If the ship has a doctor or pinnace as a boolean
    */
    boolean ifDocPin;
    
    /** If the ship can fight in a blockade encounter as a boolean
    */
    boolean blockade = false;
    
    /** If the ship can fight in a skirmish encounter as a boolean
    */
    boolean skirmish = false;
    
    /** If the ship can fight in a battle encounter as a boolean
    */
    boolean battle;
    
    /** HashMap pairing the types of encounters the ships will face and if they
     * are able to fight them
    */
    HashMap<EncounterType,Boolean> navyRules;
    


    /** Constructor requires the name of the Ship, the captains name, amount of
     * decks, amount of marines, amount of cannons and if the ship has a doctor 
     * or pinnace.
     * Also initialises the ships state to reserve, calls the abstract methods 
     * setNavyRules and setFee and finalises the HashMap for a finished set up
     * @param nameIn the name of the ship
     * @param capIn the name of the captain
     * @param dIn amount of decks
     * @param mIn amount of marines
     * @param cIn amount of cannons
     * @param dcIn if doctor or pinnace is on the ship
     */  
    public Ship(String nameIn, String capIn, int dIn, int mIn, int cIn, boolean dcIn)
    {
        this.battle = true;
        this.commissionFee = setFee();
        this.name = nameIn;
        this.Captain = capIn;
        this.decks = dIn;
        this.marines = mIn;
        this.cannons = cIn;
        this.ifDocPin = dcIn;
        this.state = ShipState.RESERVE;
        this.setNavyRules();
        this.navyRules = new HashMap<EncounterType,Boolean>();
        this.navyRules.put(EncounterType.BATTLE, battle);
        this.navyRules.put(EncounterType.BLOCKADE, blockade);
        this.navyRules.put(EncounterType.SKIRMISH, skirmish);
        this.commissionFee = this.setFee();
        
        
    }
    
    // ***************  subclasses to override  *********************

    /**returns the calculated fee, different for each Ship child
     * @returns calculated or given fee
     */
    abstract int setFee();
    
    /**Initialises the navy rules hash map
     */
    abstract void setNavyRules();
    
   // ***************   getter and setter methods  *********************
    
    
    /**returns ShipState enum object of the ships current state
     * @returns ShipState enum object of the ships current state
     */
    public ShipState getState() {
        return state;
    }

    /**returns int value of the commission fee
     * @returns int value of the commission fee
     */
    public int getCommissionFee() {
        return commissionFee;
    }

    /**returns String value of the ship's name
     * @returns String value of the ship's name
     */
    public String getName() {
        return name;
    }

    /**returns String value of the ship's Captain
     * @returns String value of the ship's Captain
     */
    public String getCaptain() {
        return Captain;
    }

    /**returns int value of the ship's battle skill level
     * @returns int value of the ship's battle skill level
     */
    public int getBattleSkill() {
        return battleSkill;
    }

    /**returns int value of the ship's deck amount
     * @returns int value of the ship's deck amount
     */
    public int getDecks() {
        return decks;
    }

    /**returns int value of how many marines are being carried
     * @returns int value of how many marines are being carried
     */
    public int getMarines() {
        return marines;
    }

    /**returns int value of the ship's amount of cannons
     * @returns int value of the ship's amount of cannons
     */
    public int getCannons() {
        return cannons;
    }

    /**returns boolean value of if the ship has a doctor or pinnace
     * @returns boolean value of if the ship has a doctor or pinnace
     */
    public boolean isIfDocPin() {
        return ifDocPin;
    }

    /**returns String value of the type of ship
     * @returns String value of the type of ship
     */
    public String getType() {
        return type;
    }
    
    /**returns boolean value of if the ship can fight the current encounter
     * @param et type of encounter the ship will fight
     * @returns boolean value of if the ship can fight the current encounter
     */
    public boolean canFight(EncounterType et)
    {
        return this.navyRules.get(et);
    }
   
    /**Commissions the ship by setting its state to active which will be filtered
     * in Fleet class
    */
    public void activateShip() //Squadron squad
    {
        this.state = this.state.ACTIVE;
    }
    
    /**Decommissions the ship by setting its state to reserve which will be 
     * filtered in Fleet class
    */
    public void decommissionShip()
    {
        this.state = this.state.RESERVE;
    }
    
    /**Rests the ship by setting its state to resting which will be filtered
     * in Fleet class
    */
    public void shipRest()//Set state to rest after a battle
    {
        this.state = this.state.RESTING;
    }
    
    /**Sinks the ship by setting its state to sunk which will be filtered in 
     * Fleet class
    */
    public void shipSunk()//Can not be used anymore
    {
        this.state = this.state.SUNK;
    }
    
    /** Returns a string representation of every attribute for the ship
    */
    @Override
    public String toString() {
        return "Ship " + "Name=" + this.name + ", commissionFee=" + this.commissionFee + ", state=" + this.state + ", Captain=" + this.Captain + ", battleSkill=" +this.battleSkill + ", decks=" + this.decks + ", marines=" + this.marines + ", cannons=" + this.cannons + ", type=" + this.type + ", ifDocPin=" + this.ifDocPin + ", blockade=" + this.blockade + ", skirmish=" + this.skirmish + ", battle=" + this.battle;
    }

    






}