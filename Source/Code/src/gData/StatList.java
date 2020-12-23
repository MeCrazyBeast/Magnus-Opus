package gData;
import java.util.List;
import java.util.Stack;
public class StatList
{
    protected static final List<String> setStats = new Stack<>() {{
        add("Stamina");
        add("Strength");
        add("Intelligence");
        add("Agility");
        add("Endurance");
        add("Faith");
        add("Leadership");
        add("Kindness");
        add("Infamy");
    }};
    public List getListOfFinalStats()
    {
        return setStats;
    }
}
