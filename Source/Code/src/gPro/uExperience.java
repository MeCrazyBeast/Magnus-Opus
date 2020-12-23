package gPro;
import java.io.File;
import java.io.FileNotFoundException;
import uData.Stats;
import java.util.Map;
import java.util.Scanner;
import gData.Races;
public class uExperience
{
    private final File setUserInfo=new File("setUserInfo.txt");
    double[] uM =new double[3];
    private Map<String,Integer> allStats;
    int uLevel=0;
    uExperience(int Level, String[][] uStats) throws FileNotFoundException
    {
        Stats stats = new Stats();
        stats.addStatToList(uStats);
        allStats=stats.returnListOfFinalStats();
        uLevel=Level;
        Scanner scanFileContents = new Scanner(setUserInfo);
        String rawRace=scanFileContents.nextLine();
        while (!rawRace.contains("Race"))
        {
            rawRace=scanFileContents.nextLine();
        }
        String raceID= (String) new Races().returnIDBasicRace().get(rawRace.substring(5));
        uM[0]=Double.parseDouble(""+raceID.charAt(1));
        uM[1]=(uLevel<=100)?Double.parseDouble(""+raceID.charAt(2)):((uLevel-100)*0.01)+Double.parseDouble(""+raceID.charAt(2));
        uM[2]=Double.parseDouble(""+raceID.charAt(3));
    }
    public long calcHealth()
    {
        int x1=allStats.get("Stamina");
        int x2=allStats.get("Strength");
        int x3=allStats.get("Intelligence");
        System.out.println(x1+" "+x2+" "+x3);
        return (long) (5* uM[1]*x1+1.5*(x2+x3)+uLevel* uM[1]);
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        String[][]x={{"Stamina","42"},{"Strength","35"},{"Intelligence","36"}};
        uExperience Qx=new uExperience(100, x);
        System.out.println("Health:"+Qx.calcHealth());
    }
    //public String[][] calcStats()
    //{
    //}
}