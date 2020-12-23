package gData;
import java.util.Map;
import static java.util.Map.entry;
public class Locations {
    private final Map<String, String> rBasicLocationMap = Map.ofEntries(
            entry("LOL", "Land of Light"),
            entry("LON","Land of Night"),
            entry("LOF", "Land of the Forgotten"));
    private final Map<String, String> rLocationMap = Map.ofEntries(
            entry("LBN","Land of Beginning"),
            entry("LOL", "Land of Light"),
            entry("LON","Land of Night"),
            entry("LOF", "Land of the Forgotten"),
            entry("LOD", "Land of Dragons"),
            entry("LOM", "Land of Mana"),
            entry("LFI","Land of Fire"),
            entry("LOB", "Land of Blood"),
            entry("LOG", "Land of Giants"),
            entry("HVN", "Heaven"),
            entry("HLL", "Hell"),
            entry("LOS", "Land of Swords"),
            entry("LBA", "Land of Balance"),
            entry("LOC", "Land of Creation"),
            entry("ASS", "Abyss"),
            entry("VID", "Void"),
            entry("LOA", "Land of Ancient")
    );
    public Map getLocation()
    {
        return rBasicLocationMap;
    }
}
