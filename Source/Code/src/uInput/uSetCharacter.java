package uInput;
import java.io.*;

import Misc.Commons.StringFunctions;
import gData.Locations;
import gData.Races;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class uSetCharacter
{
    public static void main(String[] args) throws IOException {
        Map Locations=new Locations().getLocation();
        List Races=new Races().getBasicList();
        Scanner scanner = new Scanner(System.in);
        System.out.println(StringUtils.center("Welcome to Oasis: Abyss", 60));
        System.out.print("Please Enter Your Name:" + StringUtils.center("", 4));
        final String uName = scanner.nextLine();
        System.out.println("Name:" + StringUtils.center(uName, 4));
        String uRace;
        boolean checkCorrectRace;
        AtomicInteger systemAnnoyedCount= new AtomicInteger();
        do
        {
            {
                System.out.println(Races + StringUtils.center("[Random]", 4));
                System.out.print("Select Your Race:" + StringUtils.center("", 4));
                uRace = new StringFunctions(scanner.nextLine()).capitalizeString(0);
                checkCorrectRace = (Races.contains(uRace));
                if (!checkCorrectRace && !uRace.equalsIgnoreCase("Random")) {
                    systemAnnoyedCount.getAndIncrement();
                } else if (uRace.equalsIgnoreCase("Random")) {
                    String randomRace = (String) Races.get(new Random().nextInt(5));
                    System.out.println("Your Race has been randomized to " + (uRace = randomRace));
                    break;
                }
            }
        } while(!checkCorrectRace);
        String uSpawningPoint;
        boolean checkCorrectLocation;
        do
        {
                System.out.println(Locations.values()+"[Random]");
                System.out.print("Select Your Spawning Point:" + StringUtils.center("", 4));
                uSpawningPoint = new StringFunctions(scanner.nextLine()).capitalizeString(2);
                if(checkCorrectLocation = (Locations.get(uSpawningPoint.toUpperCase()) != null||Locations.containsValue(uSpawningPoint)))
                    break;
                if (!checkCorrectLocation && !uSpawningPoint.equalsIgnoreCase("Random")) {
                    systemAnnoyedCount.getAndIncrement();
                } else if (uSpawningPoint.equalsIgnoreCase("Random")) {
                    Set randomSpawningPoint = Locations.keySet();
                    Object key = randomSpawningPoint.toArray()[new Random().nextInt(3)];
                    System.out.println("Your Spawn Point has been randomized to " + Locations.get(key));
                    break;
            }
        }while(!checkCorrectLocation);
        File setUserInfo=new File("setUserInfo.txt");
        FileOutputStream fos = new FileOutputStream("setUserInfo.txt");
        fos.write(("Name:"+uName+"\n").getBytes());
        fos.write(("Race:"+uRace+"\n").getBytes());
        fos.write(("Spawn Point:"+uSpawningPoint+"\n").getBytes());
        Scanner scanFileContents = new Scanner(setUserInfo);
    }
}
