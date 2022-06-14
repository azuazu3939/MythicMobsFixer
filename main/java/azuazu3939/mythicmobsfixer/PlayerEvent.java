package azuazu3939.mythicmobsfixer;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitItemStack;
import io.lumine.xikage.mythicmobs.items.MythicItem;
import io.lumine.xikage.mythicmobs.util.jnbt.CompoundTag;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEvent implements Listener {

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {

        if (!Cooldown.checkCooldown((Player) event.getPlayer())) return;

        Cooldown.setCooldown((Player) event.getPlayer(), 3);
        MythicMobs tansyuku = MythicMobs.inst();
        Player player = (Player) event.getPlayer();

        for (ItemStack item : player.getInventory().getContents()) {

            if (item == null) continue;

            CompoundTag tags = tansyuku.getVolatileCodeHandler().getItemHandler().getNBTData(item);

            if (!tags.containsKey("MYTHIC_TYPE")) continue;

            for (MythicItem mythicItem : tansyuku.getItemManager().getItems()) {

                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).equals(item)) {
                    Bukkit.broadcast(Component.text("1"));
                    continue;
                }

                BukkitItemStack bukkitItemStack = new BukkitItemStack(mythicItem.getInternalName());

                if (!bukkitItemStack.isSimilar(item)) continue;

                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta().hasCustomModelData()) {

                    item.setItemMeta(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta());
                    item.setType(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getType());
                    event.getPlayer().sendMessage(Component.text(ChatColor.WHITE + "アイテムを最新状態にしました。"));
                }

                item.setItemMeta(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta());
                item.setType(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getType());
                event.getPlayer().sendMessage(Component.text(ChatColor.WHITE + "アイテムを最新状態にしました。"));
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {

        if (!Cooldown.checkCooldown((Player) event.getPlayer())) return;

        Cooldown.setCooldown((Player) event.getPlayer(), 3);
        MythicMobs tansyuku = MythicMobs.inst();
        Player player = (Player) event.getPlayer();

        for (ItemStack item : player.getInventory().getContents()) {

            if (item == null) continue;

            CompoundTag tags = tansyuku.getVolatileCodeHandler().getItemHandler().getNBTData(item);

            if (!tags.containsKey("MYTHIC_TYPE")) continue;

            for (MythicItem mythicItem : tansyuku.getItemManager().getItems()) {

                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).equals(item)) continue;

                BukkitItemStack bukkitItemStack = new BukkitItemStack(mythicItem.getInternalName());

                if (!bukkitItemStack.isSimilar(item)) continue;

                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta().hasCustomModelData()) {

                    item.setItemMeta(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta());
                    item.setType(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getType());
                    event.getPlayer().sendMessage(Component.text(ChatColor.WHITE + "アイテムを最新状態にしました。"));
                }

                item.setItemMeta(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getItemMeta());
                item.setType(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).getType());
                event.getPlayer().sendMessage(Component.text(ChatColor.WHITE + "アイテムを最新状態にしました。"));
            }
        }
    }
}






