package wars; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "Team 21";
        
        details[1] = "Slamiskis";
        details[2] = "Naglis";
        details[3] = "22051850";

        details[4] = "Wang Williams";
        details[5] = "Dylan";
        details[6] = "22065548";

        details[7] = "Najmiddinov";
        details[8] = "Sirojiddin";
        details[9] = "22096506";


        details[10] = "Abduazimov";
        details[11] = "Nursultan";
        details[12] = "23010162";


    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
