package uData;
import Misc.Error.*;
import gData.StatList;
import java.util.HashMap;
import java.util.Map;

public class Stats {
    HashMap statList=new HashMap<>();
    public void addStatToList(String[][]uStats)
    {
        SetMisMatch check=new SetMisMatch();
        for(int noOfStat=0;noOfStat<uStats.length;noOfStat++)//inserts the stats in the HaspMap
        {
            //check.checkValue(uStats[noOfStat][0],new StatList().getListOfFinalStats());
            statList.put(uStats[noOfStat][0],Integer.parseInt(uStats[noOfStat][1]));
        }
    }
    public Map returnListOfFinalStats()
    {
        return statList;
    }
    public static void main(String[] args)
    {

    }
}
