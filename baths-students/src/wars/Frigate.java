/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author nagli
 */
public class Frigate extends Ship
{
    @Override
    public void setNavyRules()
    {
        if(this.ifDocPin)
        {
            this.blockade = true;
        }
        this.skirmish = true;
    }
    
    @Override
    public int setFee()
    {
        return this.cannons * 10;
    }
}
