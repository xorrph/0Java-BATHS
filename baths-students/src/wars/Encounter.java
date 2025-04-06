/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

import java.io.Serializable;

/**
 *
 * @author nagli
 */
public class Encounter implements Serializable 
{
    private int encounterNo;
    private EncounterType type;
    private String location;
    private int reqSkill;
    private int prizeMoney;

    /** Constructor requires the number/ id of the encounter, the type of encounter
     * the location of the encounter, the required battle skill of the encounter and the prize money
     * that is gained or lost after an encounter
     * @param encounterNo the number and identifier for the encounter
     * @param type the enum type of encounter
     * @param location the location of the encounter
     * @param reqSkill required skill to win the encounter
     * @param prizeMoney prize money to be lost or gained after the encounter
     */ 
    public Encounter(int encounterNo, EncounterType type, String location, int reqSkill, int prizeMoney)
    {
        this.encounterNo = encounterNo;
        this.type = type;
        this.location = location;
        this.reqSkill = reqSkill;
        this.prizeMoney = prizeMoney;
    }

    /**returns the encounter number / identifier 
     * @return the encounter Number
     **/
    public int getEncounterNo()
    {
        return encounterNo;
    }

    /**returns the enum class Encounter type that is associated with the encounter
     * @return the enum class Encounter type that is associated with the encounter
     **/
    public EncounterType getType()
    {
        return type;
    }

    /**returns the name of the location as a String
     * @return the name of the location as a String
     **/
    public String getLocation()
    {
        return location;
    }

    /**returns the required skill of the fight as an integer
     * @return the required skill of the fight as an integer
     **/
    public int getReqSkill()
    {
        return reqSkill;
    }
    
    /**returns the prize money to be won or lost 
     * @return the prize money to be won or lost 
     **/
    public int getPrizeMoney()
    {
        return prizeMoney;
    }
    
    /**Return a String representation of the encounter and its attribute
     * @return a String representation of the encounter and its attributes
     */ 
    @Override
    public String toString()
    {
        return "Encounter{" + "encounterNo=" + encounterNo + ", type=" + type + ", location=" + location + ", reqSkill=" + reqSkill + ", prizeMoney=" + prizeMoney + '}';
    }
}
