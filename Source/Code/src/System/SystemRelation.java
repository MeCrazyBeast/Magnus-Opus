package System;
import java.util.Map;
import static java.util.Map.entry;
public class SystemRelation
{
    private Map<Integer,String> annoyedSpeech = Map.ofEntries(
            entry(0, "Polite"),
            entry(1, "Normal"),
            entry(2, "Annoyed"),
            entry(3, "Irritated"),
            entry(4, "Infuriated"),
            entry(5, "Angry"),
            entry(7, "Triggered"),
            entry(6, "Haywire"),
            entry(-1, "NormalGood"),
            entry(-2, "Friendly"),
            entry(-3, "Sweet"),
            entry(-4, "Lovable"),
            entry(-5, "Affectionate"),
            entry(-6, "Dear"),
            entry(-7, "Yandere"));
}
