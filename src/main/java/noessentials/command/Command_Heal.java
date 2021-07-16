package noessentials.command;

import noessentials.external.Check;
import noessentials.external.EZ;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KeksGauner
 */
public class Command_Heal extends BukkitCommand {

    public Command_Heal(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        // Check if commandsender a Player
        if(Check.isPlayer(sender)) return true;
        Player p = (Player) sender;
        // Check player permission
        if(Check.hasPermission(p, "noessentials.heal", "§4Du bist nicht cool genug")) return true;
        if(args.length == 0) {
            p.setHealth(20);
            p.setFoodLevel(20);
            for(PotionEffect effect : p.getActivePotionEffects())
            {
                p.removePotionEffect(effect.getType());
            }

            p.sendMessage(EZ.t("&eDu hast dich geheilt"));
            return true;
        }
        if(args.length == 1) {

            if(Check.hasPermission(p, "noessentials.heal.other", "§4Du bist nicht cool genug")) return true;
            Player target = Bukkit.getPlayer(String.valueOf(args[0]));
            if(target != null) {
                target.setHealth(20);
                target.setFoodLevel(20);
                for(PotionEffect effect : target.getActivePotionEffects())
                {
                    target.removePotionEffect(effect.getType());
                }
                p.sendMessage(EZ.t("&eDu wurdest geheilt"));
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
