package com.spencer5949.floorislava.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class ClickEvent implements Listener {

    String input = "0";

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();



        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Create Floor Is Lava Map"))
        {

            switch (e.getCurrentItem().getType()) {
                case WOODEN_AXE:
                    player.closeInventory();
                    player.sendMessage(ChatColor.GOLD + "Use the Map Selector Tool to select the area wanted for the Floor Is Lava minigame");
                    player.getInventory().addItem(new ItemStack(Material.STICK));
                    break;
                case LAVA_BUCKET:
                    player.closeInventory();
                    player.sendMessage(ChatColor.GOLD + "Type in chat the interval that you would like the lava to rise in seconds. Or type 'exit'");
                    input = "1";
                    break;


                case WHITE_TULIP:
                    player.closeInventory();
                    player.sendMessage(ChatColor.GOLD + "Type in chat how long you want betweeen the start of the game and before the lava starts to rise. Or type 'exit'");
                    input = "2";

            }


            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        if(input == "1"){
            System.out.println("Input: " + event.getMessage());
            player.sendMessage("Input " + event.getMessage());
            event.setCancelled(true);
            input = "0";

        }
        if(input == "2"){
            System.out.println("Input2 " + event.getMessage());
            player.sendMessage("Input2 " + event.getMessage());
            event.setCancelled(true);
            input = "0";

        }
        if(input == "exit"){
            input = "0";
            event.setCancelled(true);
        }




    }
}
