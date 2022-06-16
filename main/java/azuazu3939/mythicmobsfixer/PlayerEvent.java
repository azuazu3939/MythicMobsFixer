package azuazu3939.mythicmobsfixer;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.items.MythicItem;
import io.lumine.xikage.mythicmobs.util.jnbt.CompoundTag;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEvent implements Listener {

    private static final int COOLDOWN = MythicMobsFixer.getInstance().getConfig().getInt("cooldown");

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (!Cooldown.checkCooldown((Player) event.getWhoClicked())) return;

        Cooldown.setCooldown((Player) event.getWhoClicked(), COOLDOWN);
        MythicMobs tansyuku = MythicMobs.inst();
        Player player = (Player) event.getWhoClicked();
        FileConfiguration config = MythicMobsFixer.getInstance().getConfig();

        for (ItemStack item : player.getInventory().getContents()) {

            if (item == null) continue;
            if (item.getType().equals(Material.PLAYER_HEAD) || item.getType().equals(Material.PLAYER_WALL_HEAD)) continue;

            CompoundTag tag = MythicMobs.inst().getVolatileCodeHandler().getItemHandler().getNBTData(item);

            for (MythicItem mythicItem : tansyuku.getItemManager().getItems()) {

                if (config.contains(mythicItem.getInternalName())) continue;
                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).isSimilar(item)) continue;

                if (tag.containsKey("MYTHIC_TYPE")) {
                    String mm = mythicItem.getInternalName();
                    if (!tag.getString("MYTHIC_TYPE").equals(mm)) continue;

                    item.setItemMeta(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta());
                    item.setType(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getType());
                }
            }
        }
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {

        if (!Cooldown.checkCooldown((Player) event.getPlayer())) return;

        Cooldown.setCooldown((Player) event.getPlayer(), COOLDOWN);
        MythicMobs tansyuku = MythicMobs.inst();
        Player player = (Player) event.getPlayer();
        FileConfiguration config = MythicMobsFixer.getInstance().getConfig();

        for (ItemStack item : player.getInventory().getContents()) {

            if (item == null) continue;
            if (item.getType().equals(Material.PLAYER_HEAD) || item.getType().equals(Material.PLAYER_WALL_HEAD)) continue;

            CompoundTag tag = MythicMobs.inst().getVolatileCodeHandler().getItemHandler().getNBTData(item);

            for (MythicItem mythicItem : tansyuku.getItemManager().getItems()) {

                if (config.contains(mythicItem.getInternalName())) continue;
                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).isSimilar(item)) continue;

                if (tag.containsKey("MYTHIC_TYPE")) {
                    String mm = mythicItem.getInternalName();
                    if (!tag.getString("MYTHIC_TYPE").equals(mm)) continue;

                    item.setItemMeta(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta());
                    item.setType(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getType());
                }
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {

        if (!Cooldown.checkCooldown((Player) event.getPlayer())) return;

        Cooldown.setCooldown((Player) event.getPlayer(), COOLDOWN);
        MythicMobs tansyuku = MythicMobs.inst();
        Player player = (Player) event.getPlayer();
        FileConfiguration config = MythicMobsFixer.getInstance().getConfig();

        for (ItemStack item : player.getInventory().getContents()) {

            if (item == null) continue;
            if (item.getType().equals(Material.PLAYER_HEAD) || item.getType().equals(Material.PLAYER_WALL_HEAD)) continue;

            CompoundTag tag = MythicMobs.inst().getVolatileCodeHandler().getItemHandler().getNBTData(item);

            for (MythicItem mythicItem : tansyuku.getItemManager().getItems()) {

                if (config.contains(mythicItem.getInternalName())) continue;
                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).isSimilar(item)) continue;

                if (tag.containsKey("MYTHIC_TYPE")) {
                    String mm = mythicItem.getInternalName();
                    if (!tag.getString("MYTHIC_TYPE").equals(mm)) continue;

                    item.setItemMeta(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta());
                    item.setType(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getType());
                }
            }
        }
    }
}
