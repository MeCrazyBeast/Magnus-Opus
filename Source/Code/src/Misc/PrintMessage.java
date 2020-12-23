package Misc;
public class PrintMessage
{
    public String sendMessage(String rMessage, boolean eINP)
    {
        if(eINP)
        {
            return rMessage;
        }
        return "";
    }
    public void cMessage(String mFalse, String mTrue, boolean eINP)
    {
        if(!eINP)
        {
            System.out.println(mFalse);
            return;
        }
        System.out.println(mTrue);
        System.exit(-1);
    }
    public void cMessage(String mTrue, boolean eINP)
    {
        if(!eINP)
        {
            System.out.println(mTrue);
            System.exit(-1);
        }
    }
    public int cMessage(String cINP)
    {
        try
        {
            return Integer.parseInt(cINP);
        }
        catch (NumberFormatException numberFormatException)
        {
            //use StackTrace to call the error.
            System.exit(-1);
        }
        return 0;
    }
}
