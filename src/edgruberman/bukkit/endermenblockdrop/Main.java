package edgruberman.bukkit.endermenblockdrop;

import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityDeath(final EntityDeathEvent event) {
        if (event.getEntityType() != EntityType.ENDERMAN) return;

        final Enderman enderman = (Enderman) event.getEntity();
        enderman.getWorld().dropItemNaturally(enderman.getLocation(), enderman.getCarriedMaterial().toItemStack(1));
    }

}
