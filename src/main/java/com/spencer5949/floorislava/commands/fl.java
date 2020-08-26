package com.spencer5949.floorislava.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;


public class fl implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("create")) {
                    if (args.length == 2) {


                        Inventory gui = Bukkit.createInventory(player, 27, ChatColor.RED + "Creating Floor is lava map " + args[1]);

                        ItemStack boundaries = new ItemStack(Material.WOODEN_AXE);
                        ItemStack rise_rate = new ItemStack(Material.LAVA_BUCKET);
                        ItemStack grace_period = new ItemStack(Material.WHITE_TULIP);
                        ItemStack rise_limit = new ItemStack(Material.RED_WOOL);
                        ItemStack filler = new ItemStack(Material.LIME_STAINED_GLASS_PANE);

                        ItemMeta boundaries_meta = boundaries.getItemMeta();
                        boundaries_meta.setDisplayName("" + ChatColor.DARK_RED + ChatColor.BOLD + "Map Boundaries");
                        ArrayList<String> boundaries_lore = new ArrayList<>();
                        boundaries_lore.add(ChatColor.DARK_GRAY + "- " + ChatColor.DARK_AQUA + "Use this option to define the boundaries for the map");
                        boundaries_meta.setLore(boundaries_lore);
                        boundaries.setItemMeta(boundaries_meta);

                        ItemMeta rise_rate_meta = rise_rate.getItemMeta();
                        rise_rate_meta.setDisplayName("" + ChatColor.DARK_RED + ChatColor.BOLD + "Rise Speed");
                        ArrayList<String> rise_rate_lore = new ArrayList<>();
                        rise_rate_lore.add(ChatColor.DARK_GRAY + "- " + ChatColor.DARK_AQUA + "Use this option to set the speed the lava rises");
                        rise_rate_meta.setLore(rise_rate_lore);
                        rise_rate.setItemMeta(rise_rate_meta);

                        ItemMeta grace_period_meta = grace_period.getItemMeta();
                        grace_period_meta.setDisplayName("" + ChatColor.DARK_RED + ChatColor.BOLD + "Grace Period");
                        ArrayList<String> grace_period_lore = new ArrayList<>();
                        grace_period_lore.add(ChatColor.DARK_GRAY + "- " + ChatColor.DARK_AQUA + "Use this option to set the time before the lava starts to rise");
                        grace_period_meta.setLore(grace_period_lore);
                        grace_period.setItemMeta(grace_period_meta);


                        ItemStack[] menu_items = {filler, filler, filler, filler, filler, filler, filler, filler, filler,
                                filler, boundaries, filler, filler, rise_rate, filler, filler, grace_period, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler};
                        gui.setContents(menu_items);
                        player.openInventory(gui);
                    }else{
                        player.sendMessage("Please provide a name for ");
                    }

                } else if (args[0].equalsIgnoreCase("list")) {


                    player.sendMessage(ChatColor.RED + "There currently isn't any floor is lava maps. Create one by typing /fl create");
                }


            } else {
                player.sendMessage(ChatColor.GOLD + "FloorIsLava plugin by Spencer5949#6603");

            }

        }
        return true;
    }
}
