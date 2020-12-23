package Misc.Error;

import java.util.List;

public class SetMisMatch {
    public void checkLength(int sOneLength, int sTwoLength)
    {
        if(sOneLength !=sTwoLength)
        {
            System.exit(-1);
        }
    }
    public void checkValue(String value, List listValue)
    {
        if(!listValue.contains(value))
        {
            System.exit(-1);
        }
    }
}
