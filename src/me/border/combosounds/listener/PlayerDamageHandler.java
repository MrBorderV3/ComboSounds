package me.border.combosounds.listener;

import me.border.combosounds.ComboSounds;
import me.border.combosounds.util.Utils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;

public class PlayerDamageHandler implements Listener {

    public HashMap<Player, Integer> hitMap = new HashMap<>();
    Sound sound = null;

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player damager = (Player) e.getDamager();
            Player damaged = (Player) e.getEntity();
            hitMap.remove(damaged);
            if (hitMap.containsKey(damager)){
                int hits = hitMap.get(damager);
                hits++;
                hitMap.replace(damager, hits);
                if (hits >= 3){
                    if (sound == null){
                        sound = Sound.valueOf(Utils.cs("Sound"));
                    }
                    damager.playSound(damager.getLocation(), sound, 2F, 1F);
                }
            } else {
                hitMap.put(damager, 1);
            }
        }
    }
}
