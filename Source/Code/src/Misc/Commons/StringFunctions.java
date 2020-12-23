package Misc.Commons;
public class StringFunctions
{
    String[] globalString;
    String currentChangedString="";
    public StringFunctions(String initialString)
    {
        globalString = initialString.split(" ");
    }
    /*
    Capitalizes the given String with words above the given value, for example: Head is gone becomes, Head is Gone.
     */
    public String capitalizeString(int value)
    {
        for (String s : globalString) {
            String firstChar = "" + s.charAt(0);
            if (s.length() > value) {
                currentChangedString += s.replaceFirst(firstChar, firstChar.toUpperCase()) + " ";
            } else {
                currentChangedString += s + " ";
            }
        }
        return currentChangedString.trim();
    }
    public static void main(String[] args)
    {
    }
}
