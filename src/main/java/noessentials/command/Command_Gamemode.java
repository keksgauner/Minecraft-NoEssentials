package noessentials.command;

import noessentials.external.Check;
import noessentials.external.EZ;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author KeksGauner
 */
public class Command_Gamemode extends BukkitCommand {

    public Command_Gamemode(String name) {
        super(name);
        this.setPermission("noessentials.gamemode");
        this.setAliases(Arrays.asList("gamemode"));
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        // Check if commandsender a Player
        if(Check.isPlayer(sender)) return true;
        Player p = (Player) sender;
        // Check player permission
        if(Check.hasPermission(p, "noessentials.gamemode", "§4Du bist nicht cool genug")) return true;

        if(args.length == 0) {
            if(p.getGameMode() == GameMode.SURVIVAL) {
                p.sendMessage(EZ.t("&eDein Gamemode wurde auf &aCreative &egesetzt"));
                p.setGameMode(GameMode.CREATIVE);
                return true;
            }
            if(p.getGameMode() == GameMode.CREATIVE) {
                p.sendMessage(EZ.t("&eDein Gamemode wurde auf &cSurvival &egesetzt"));
                p.setGameMode(GameMode.SURVIVAL);
                return true;
            }
        }

        if(args.length == 1) {
            switch (String.valueOf(args[0]).toLowerCase()) {
                case "0":
                case "survival":
                    p.sendMessage(EZ.t("&eDein Gamemode wurde auf &aSurvival &egesetzt"));
                    p.setGameMode(GameMode.SURVIVAL);
                    break;
                case "1":
                case "creative":
                    p.sendMessage(EZ.t("&eDein Gamemode wurde auf &bCreative &egesetzt"));
                    p.setGameMode(GameMode.CREATIVE);
                    break;
                case "2":
                case "adventure":
                    p.sendMessage(EZ.t("&eDein Gamemode wurde auf &cAdventure &egesetzt"));
                    p.setGameMode(GameMode.ADVENTURE);
                    break;
                case "3":
                case "spectator":
                    p.sendMessage(EZ.t("&eDein Gamemode wurde auf &7Spectator &egesetzt"));
                    p.setGameMode(GameMode.SPECTATOR);
                    break;
                default:
                    p.sendMessage(EZ.t("&eDer Gamemode wurde nicht gefunden"));
                    break;
            }
            return true;
        }

        if(args.length == 2) {
            Player target = Bukkit.getPlayer(String.valueOf(args[1]));
            if(target == null) {
                p.sendMessage(EZ.t("&ePlayer ist nicht Online"));
                return true;
            }

            switch (String.valueOf(args[0]).toLowerCase()) {
                case "0":
                case "survival":
                    p.sendMessage(EZ.t("&e" + target.getName() + "'s Gamemode wurde von " + p.getName() +" auf &aSurvival &egesetzt"));
                    target.sendMessage(EZ.t("&e" + target.getName() + "'s Gamemode wurde von " + p.getName() +" auf &aSurvival &egesetzt"));
                    target.setGameMode(GameMode.SURVIVAL);
                    break;
                case "1":
                case "creative":
                    p.sendMessage(EZ.t("&e" + target.getName() + "'s  Gamemode wurde von " + p.getName() +" auf &bCreative &egesetzt"));
                    target.sendMessage(EZ.t("&e" + target.getName() + "'s  Gamemode wurde von " + p.getName() +" auf &bCreative &egesetzt"));
                    target.setGameMode(GameMode.CREATIVE);
                    break;
                case "2":
                case "adventure":
                    p.sendMessage(EZ.t("&e" + target.getName() + "'s Gamemode wurde von " + p.getName() +" auf &cAdventure &egesetzt"));
                    target.sendMessage(EZ.t("&e" + target.getName() + "'s Gamemode wurde von " + p.getName() +" auf &cAdventure &egesetzt"));
                    target.setGameMode(GameMode.ADVENTURE);
                    break;
                case "3":
                case "spectator":
                    p.sendMessage(EZ.t("&e" + target.getName() + "'s Gamemode wurde von " + p.getName() +"auf &7Spectator &egesetzt"));
                    target.sendMessage(EZ.t("&e" + target.getName() + "'s Gamemode wurde von " + p.getName() +"auf &7Spectator &egesetzt"));
                    target.setGameMode(GameMode.SPECTATOR);
                    break;
                default:
                    p.sendMessage(EZ.t("&eDer Gamemode wurde nicht gefunden"));
                    break;
            }
            return true;
        }
        if(args.length == 3) {
            p.sendMessage(EZ.t("&eBenutze /gm <gamemode> <player>"));
            return true;
        }

        return false;
    }

    public List<String> tabComplete(CommandSender sender, String alias, String[] args, Location location) {
        if (args.length == 1){ // first args
            List<String> arguments = new ArrayList<>();
            arguments.add("0");
            arguments.add("1");
            arguments.add("2");
            arguments.add("3");
            arguments.add("survival");
            arguments.add("creative");
            arguments.add("adventure");
            arguments.add("spectator");
            return arguments; // give a list back
        }
        if (args.length == 2){ // second args
            List<String> playerNames = new ArrayList<>();
            for (Player all : Bukkit.getOnlinePlayers()){
                playerNames.add(all.getName());
            }
            return playerNames;
        }

        return null; // default return
    }
}
