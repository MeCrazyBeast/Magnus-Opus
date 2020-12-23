package gData;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import java.util.Stack;
public class Jobs {
    private List<String> jT1 = new Stack<>() {
        {
            add("Mage");
            add("Brawler");
            add("Generic Game Occupation");
        }
    };
    private List<String> jT2 = new Stack<>() {
        {
            add("Slaughterer");
            add("Caretaker");
            add("Bat");
        }
    };
    private Map<String, List> uParentJob = Map.ofEntries(
            entry("Tier 1", jT1),
            entry("Tier 2", jT2)
    );
    //public List availableJob()
    //{
    //}
}
