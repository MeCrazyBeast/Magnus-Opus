package gData;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import static java.util.Map.entry;
public class Races
{
    /* How to make idRace
     *idRace.length()=8
     *The first character would be a letter, showing the precedence. z=Oldest, a=Newest.
     *Next three characters will be Starting: Stamina Multiplier, Level Multiplier and Mana Core Multiplier
     *Next letter would be their base spawn place, must be three characters.
     *Last would depict the bloodline, which would be in the E-S tier, which is not predetermined.
     *Example:
     *Agnus Dragonair is Z686LODS, but for any Dragonair it's Z686LOD@, where @ is the bloodline.
     *Normal Human is M121LBEC
     *Glitch Arch-Human is S232LBES
     */
    private Map<String, String> rBasicID=Map.ofEntries(
            entry("Human","M222LBE"),
            entry("Elf","P123LOE"),
            entry("Dwarf","O321LFI"),
            entry("Orc","N411LOG"),
            entry("Ghoul","G212LOB"));
    public Map returnIDBasicRace()
    {
        return rBasicID;
    }
    private List<String> gBasicList = new Stack<>() {{
        add("Human");
        add("Elf");
        add("Dwarf");
        add("Orc");
        add("Ghoul");
    }};
    private Map<String, String> rT1ID=Map.ofEntries(
            entry("Specter","S133HLL"),
            entry("",""));
    List<String> gTier1List = new Stack<>()
    {{
        add("Specter");
        add("");
    }};
    private Map<String, String> rT2ID=Map.ofEntries(
            entry("",""));
    final List<String> gTier2List = new Stack<>()
    {
    };
    private Map<String, String> rT3ID=Map.ofEntries(
            entry("Arch-Human","S232LBES"));
    final List<String> gTier3List = new Stack<>()
    {
    };
    private Map<String, String> rT4ID=Map.ofEntries(
            entry("",""));
    final List<String> gTier4List = new Stack<>()
    {
    };
    private Map<String, String> rT5ID=Map.ofEntries(
            entry("Gods","W565LOA"));
    List<String> gTier5List = new Stack<>()
    {
    };
    private Map<String, String> rT6ID=Map.ofEntries(
            entry("Dragonair","Z686LOD"));
    List<String> gTier6List = new Stack<>()
    {
    };
    List<List> gParentList = new Stack<>() {{
        add(getBasicList());
        add(gTier1List);
        add(gTier2List);
        add(gTier3List);
        add(gTier4List);
        add(gTier5List);
        add(gTier6List);
    }};
    public List<String> getBasicList() {
        return gBasicList;
    }

}