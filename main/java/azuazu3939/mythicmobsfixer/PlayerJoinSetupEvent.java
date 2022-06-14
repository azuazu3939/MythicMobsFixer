package azuazu3939.mythicmobsfixer;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitItemStack;
import io.lumine.xikage.mythicmobs.items.MythicItem;
import io.lumine.xikage.mythicmobs.util.jnbt.CompoundTag;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinSetupEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Cooldown.setupCooldown();
        Player player = event.getPlayer();
        MythicMobs tansyuku = MythicMobs.inst();

        for (ItemStack item : player.getInventory().getContents()) {

            if (item == null) continue;

            CompoundTag tags = tansyuku.getVolatileCodeHandler().getItemHandler().getNBTData(item);

            if (!tags.containsKey("MYTHIC_TYPE")) continue;

            for (MythicItem mythicItem : tansyuku.getItemManager().getItems()) {

                BukkitItemStack bukkitItemStack = new BukkitItemStack(tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()));

                if (tansyuku.getItemManager().getItemStack(mythicItem.getInternalName()).equals(item)) continue;

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


