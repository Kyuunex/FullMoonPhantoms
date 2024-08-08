package moe.kyuunex.fullMoonPhantoms;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Calendar;

public final class FullMoonPhantoms extends JavaPlugin {
    @Override
    public void onEnable() {
        // Schedule a task that runs every 2 hours
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                // Get the current date
                Calendar calendar = Calendar.getInstance();
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                // Check if today is the 28th
                if (dayOfMonth == 28) {
                    // Set the gamerule doInsomnia to true
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule doInsomnia true");
                    getLogger().info("Gamerule doInsomnia set to true, as it's the 28th of the month.");
                } else {
                    // Set the gamerule doInsomnia to false
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule doInsomnia false");
                    getLogger().info("Gamerule doInsomnia set to false.");
                }
            }
        }, 0L, 20L * 60 * 60 * 2); // 20 ticks per second * 60 seconds * 60 minutes * 2 hours
    }
}
