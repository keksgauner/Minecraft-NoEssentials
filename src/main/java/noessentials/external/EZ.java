package noessentials.external;

import net.md_5.bungee.api.ChatColor;

public class EZ {
    // t for Translate
    public static String t(String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }
}
