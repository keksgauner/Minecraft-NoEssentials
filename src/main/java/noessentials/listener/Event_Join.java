package noessentials.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author KeksGauner
 */
public class Event_Join implements Listener {
    @EventHandler
    public void onEvent(PlayerJoinEvent event)
    {
       Player p = event.getPlayer();

        // stay = ticks || 20 ticks = 1 sec || 5 sec = 100 ticks
        p.sendTitle("§cWillkommen §a" + p.getName(), "", 1, 100, 1);
        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 100, 0);


        /*BossBar bossBar = Bukkit.createBossBar(p.getName()+ " willkommen", BarColor.BLUE, BarStyle.SOLID);
        bossBar.addPlayer(p);

        // Example of a scheduke task
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                // Example of a try and catch
                try {
                    bossBar.removeAll();
                } catch (Exception e) {}
            }
        }, 100);*/

    }
}
