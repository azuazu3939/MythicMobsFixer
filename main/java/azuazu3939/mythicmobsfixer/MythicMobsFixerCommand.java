package azuazu3939.mythicmobsfixer;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.items.MythicItem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MythicMobsFixerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String action;
        FileConfiguration config = MythicMobsFixer.getInstance().getConfig();
        MythicMobs tansyuku = MythicMobs.inst();
        String itemname;
        String mmitemname;

        if (sender instanceof Player && !sender.hasPermission("MythicMobs.mmf")) sender.sendMessage(ChatColor.RED + "権限がありません");

        try {
            action = args[0];
            if (action.equals("reload")) {
                MythicMobsFixer.getInstance().saveConfig();
                sender.sendMessage(ChatColor.WHITE + "MythicMobsFixerのconfigをリロードしました。");
                return true;
            }
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "/mmf [add/remove/reload] mmitemid");
            return true;
        }

        try {

            action = args[0];
            itemname = args[1];

        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "/mmf [add/remove/reload] mmitemid");
            return true;
        }

        try {

            for (MythicItem mythicItem : tansyuku.getItemManager().getItems()) {

                mmitemname = mythicItem.getInternalName();
                String name = mythicItem.getDisplayName();

                try {

                    if (!itemname.equals(mmitemname)) continue;

                    try {

                        switch (action) {
                            case "add":
                                if (config.isSet(mmitemname)) {
                                    sender.sendMessage(ChatColor.RED + mmitemname + ChatColor.RED + "はすでにFixしないアイテムリストに登録されています。。");
                                    break;
                                }
                                MythicMobsFixer.getInstance().getConfig().createSection(mmitemname);
                                config.set(mmitemname, name);
                                MythicMobsFixer.getInstance().saveConfig();
                                sender.sendMessage(ChatColor.AQUA + mmitemname + ChatColor.WHITE + "をFixしないアイテムリストに追加しました。");
                                break;
                            case "remove":
                                config.set(mmitemname, null);
                                MythicMobsFixer.getInstance().saveConfig();
                                sender.sendMessage(ChatColor.AQUA + mmitemname + ChatColor.WHITE + "をFixしないアイテムリストから除外しました。");
                                break;
                            default:
                                sender.sendMessage(ChatColor.RED + "/mmf [add/remove/reload] mmitemid");
                                break;
                        }

                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.RED + "/mmf [add/remove/reload] mmitemid");
                        return true;
                    }

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "/mmf [add/remove/reload] mmitemid");
                    return true;
                }

            }

        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "/mmf [add/remove/reload] mmitemid");
            return true;
        }
        return true;
    }
}
