/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author nagli
 */
public class Sloop extends Ship
{
    public Sloop(String nameIn, String capIn, int dIn, int mIn, int cIn, boolean dcIn)
    {
        super(nameIn, capIn, dIn, mIn, cIn, dcIn);
        this.type = "Sloop";
        this.battleSkill = 5;
    }
    
    @Override
    public void setNavyRules()
    {
        this.blockade = true;   
    }
    
    @Override
    public int setFee()
    {
        return this.commissionFee ; //sloops set their own fees
    }
    
    public void setFee(int fee)//seperate Method that calls override method to set the commission fee
    {
        this.commissionFee = fee;
        setFee();
    }
}
