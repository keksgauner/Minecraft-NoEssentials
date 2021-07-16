package noessentials.command;

import noessentials.external.Check;
import noessentials.external.EZ;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KeksGauner
 */
public class Command_Enderchest extends BukkitCommand {

    public Command_Enderchest(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        // Check if commandsender a Player
        if(Check.isPlayer(sender)) return true;
        Player p = (Player) sender;
        // Check player permission
        if(Check.hasPermission(p, "noessentials.enderchest", "§4Du bist nicht cool genug")) return true;
        if(args.length == 0) {
            p.openInventory(p.getEnderChest());
            return true;
        }
        if(args.length == 1) {

            if(Check.hasPermission(p, "noessentials.enderchest.other", "§4Du bist nicht cool genug")) return true;
            Player target = Bukkit.getPlayer(String.valueOf(args[0]));
            if(target != null) {
                p.openInventory(target.getEnderChest());
            } else
                p.sendMessage(EZ.t("&ePlayer ist nicht Online"));
        }
        return false;
    }
    public List<String> tabComplete(CommandSender sender, String alias, String[] args, Location location) {
        if (args.length == 1){ // first args
            List<String> playerNames = new ArrayList<>();
            for (Player all : Bukkit.getOnlinePlayers()){
                playerNames.add(all.getName());
            }
            return playerNames;
        }
        return null; // default return
    }
}
