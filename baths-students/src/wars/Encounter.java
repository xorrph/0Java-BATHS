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

    public Encounter(int encounterNo, EncounterType type, String location, int reqSkill, int prizeMoney)
    {
        this.encounterNo = encounterNo;
        this.type = type;
        this.location = location;
        this.reqSkill = reqSkill;
        this.prizeMoney = prizeMoney;
    }

    public int getEncounterNo()
    {
        return encounterNo;
    }

    public EncounterType getType()
    {
        return type;
    }

    public String getLocation()
    {
        return location;
    }

    public int getReqSkill()
    {
        return reqSkill;
    }

    public int getPrizeMoney()
    {
        return prizeMoney;
    }
    
    @Override
    public String toString()
    {
        return "Encounter{" + "encounterNo=" + encounterNo + ", type=" + type + ", location=" + location + ", reqSkill=" + reqSkill + ", prizeMoney=" + prizeMoney + '}';
    }
}
