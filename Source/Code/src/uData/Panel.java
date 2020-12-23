package uData;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;
public class Panel
{
    HashMap uData=new HashMap<String, String>();
    HashMap uStats=new HashMap<String, Integer>();
    String [][]sData;
    String [][]iData;
    public void get(HashMap uInfo, HashMap uStat)
    {
        uData = uInfo;
        uStats = uStat;
    }
    private void calcPanel()
    {
        String [] rawData= uStats.toString().split(",");
        sData=new String[rawData.length][2];
        for(int i=0; i<sData.length;i++)
        {
            sData[i][0]=rawData[i].substring(1,rawData[i].indexOf("="));
            sData[i][1]=(rawData[i].substring(rawData[i].indexOf("=")+1)).replace("}"," ");
        }
        rawData= uData.toString().split(",");
        iData= new String[rawData.length][2];
        for(int i=0; i<iData.length;i++)
        {
            iData[i][0]=rawData[i].substring(1,rawData[i].indexOf("="));
            iData[i][1]=(rawData[i].substring(rawData[i].indexOf("=")+1)).replace("}"," ");
        }
    }
    private void displayPanel()
    {
        System.out.println(""+StringUtils.center("+++++++++++++++++++++++++Status Panel+++++++++++++++++++++++++",60));
        for(int index=iData.length-1;index>=0;index--)
        {
            System.out.println(StringUtils.center(iData[index][0],20)+":"+ StringUtils.center(iData[index][1],5));
        }
        System.out.println();
        System.out.println(StringUtils.center("----------------Stats----------------",60));
        for(int index=0;index<sData.length;index++)
        {
            System.out.print(StringUtils.center(sData[index][0],20)+":"+ StringUtils.center(sData[index][1],4));
            System.out.print((index%2!=0)?"\n":"");
        }
    }
    public static void main(String[] args) throws IOException
    {
        Panel uPanel = new Panel();
        Stats doWorkOnStats =new Stats();
        String [][]xd={{"Stamina","42"},{"Stamina","35"},{"Intelligence","36"}};
        doWorkOnStats.addStatToList(xd);
        Scanner scanFileContents=new Scanner(Path.of("setUserInfo.txt"));
        HashMap uInfo=new HashMap<String,String>();
        int i=0;
        while (i!=3)
        {
            String content = scanFileContents.nextLine();
            uInfo.put(content.substring(0, content.indexOf(':')), content.substring(content.indexOf(':') + 1));
            i++;
        }
        uPanel.get(uInfo, doWorkOnStats.statList);
        uPanel.calcPanel();
        uPanel.displayPanel();
    }

}
