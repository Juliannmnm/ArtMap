package me.Fupery.ArtMap.Listeners;

import me.Fupery.ArtMap.ArtMap;
import me.Fupery.ArtMap.Utils.Preview;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerQuitListener implements Listener {

    private final ArtMap plugin;

    public PlayerQuitListener(ArtMap plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        if (plugin.getArtistHandler() != null
                && plugin.getArtistHandler().containsPlayer(event.getPlayer())) {
            plugin.getArtistHandler().removePlayer(event.getPlayer());
        }

        if (plugin.isPreviewing(event.getPlayer())) {

            if (event.getPlayer().getItemInHand().getType() == Material.MAP) {

                Preview.stop(plugin, event.getPlayer());
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        if (plugin.getArtistHandler() != null
                && plugin.getArtistHandler().containsPlayer(event.getEntity())) {
            plugin.getArtistHandler().removePlayer(event.getEntity());
        }

        if (plugin.isPreviewing(event.getEntity())) {

            Preview.stop(plugin, event.getEntity());
        }
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {

        if (plugin.getArtistHandler() != null
                && plugin.getArtistHandler().containsPlayer(event.getPlayer())) {
            plugin.getArtistHandler().removePlayer(event.getPlayer());
        }
    }
}
