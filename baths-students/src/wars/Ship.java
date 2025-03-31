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
    boolean blockade;
    boolean skirmish;
    boolean battle;


    public Ship(String nameIn, String capIn, int bsIn, int dIn, int mIn, int cIn, boolean dcIn)
    {
        this.commissionFee = setFee();
        this.name = nameIn;
        this.Captain = capIn;
        this.battleSkill = bsIn;
        this.marines = mIn;
        this.cannons = cIn;
        this.ifDocPin = dcIn;
        this.battle = true;
        this.state = ShipState.RESERVE;
        setNavyRules();
        
        
    }

    abstract int setFee();
    
    abstract void setNavyRules();
    
    
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
   
    public void commissionShip(int warchest) //Squadron squad
    {
        warchest -= this.commissionFee;
        //squad.add(this)
        this.state = this.state.ACTIVE;
    }
    
    public void restoreShip()
    {
        this.state = this.state.ACTIVE;
    }
    
    public void decommissionShip(int warchest) //Squadron squad
    {
        warchest += this.commissionFee / 2;
        //squad.remove(this)
        this.state = this.state.RESERVE;
    }
    
    public void shipRest()
    {
        this.state = this.state.RESTING;
    }
    
    public void shipSunk()
    {
        this.state = this.state.SUNK;
    }
    
    

    






}