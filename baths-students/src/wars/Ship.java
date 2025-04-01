/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;


/**
 *
 * @author naglis
 */

public abstract class Ship 
{

    ShipState state;
    int commissionFee;
    String name;
    String Captain;
    int battleSkill;
    int decks;
    int marines;
    int cannons;
    String type;
    boolean ifDocPin;
    boolean blockade = false;
    boolean skirmish = false;
    boolean battle;


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
        setNavyRules();
        
        
    }
    
    // subclasses to override

    abstract int setFee();
    
    abstract void setNavyRules();
    
    // getter and setter methods
    
    public ShipState getState() {
        return state;
    }

    public int getCommissionFee() {
        return commissionFee;
    }

    public String getName() {
        return name;
    }

    public String getCaptain() {
        return Captain;
    }

    public int getBattleSkill() {
        return battleSkill;
    }

    public int getDecks() {
        return decks;
    }

    public int getMarines() {
        return marines;
    }

    public int getCannons() {
        return cannons;
    }

    public boolean isIfDocPin() {
        return ifDocPin;
    }

    public String getType() {
        return type;
    }
   
    public void commissionShip() //Squadron squad
    {
        this.state = this.state.ACTIVE;
    }
    
    public void restoreShip()//Used by BA to get resting ships to be active
    {
        this.state = this.state.ACTIVE;
    }
    
    public void decommissionShip()
    {
        this.state = this.state.RESERVE;
    }
    
    public void shipRest()//Set state to rest after a battle
    {
        this.state = this.state.RESTING;
    }
    
    public void shipSunk()//Can not be used anymore
    {
        this.state = this.state.SUNK;
    }
    
    @Override
    public String toString() {
        return "Ship{" + "state=" + state + ", commissionFee=" + commissionFee + ", name=" + name + ", Captain=" + Captain + ", battleSkill=" + battleSkill + ", decks=" + decks + ", marines=" + marines + ", cannons=" + cannons + ", type=" + type + ", ifDocPin=" + ifDocPin + ", blockade=" + blockade + ", skirmish=" + skirmish + ", battle=" + battle + '}';
    }

    






}