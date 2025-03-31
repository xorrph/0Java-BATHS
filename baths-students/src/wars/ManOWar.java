/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author nagli
 */
public class ManOWar extends Ship
{
    public ManOWar(String nameIn, String capIn, int bsIn, int dIn, int mIn, int cIn, boolean dcIn)
    {
        super(nameIn, capIn, dIn, mIn, cIn, dcIn);
        this.type = "ManOWar";
        this.battleSkill = bsIn;
    }
    
    @Override
    public void setNavyRules()
    {
        this.blockade = true;   
    }
    
    @Override
    public int setFee()
    {
        if (this.decks <= 2)
        {
            return 300;
        }
        return 500; //cost is 500 unless only having 2 decks (might change to ==)
    }
}
