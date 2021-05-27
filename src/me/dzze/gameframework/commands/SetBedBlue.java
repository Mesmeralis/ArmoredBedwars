package me.dzze.gameframework.commands;

import me.dzze.gameframework.Main;
import me.dzze.gameframework.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class SetBedBlue implements SubCommand {
    Main main;
    public SetBedBlue(Main main){
        this.main = main;
    }
    public Set<Player> settingBed = new HashSet<>();

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player p = (Player) sender;
        main.getConfig().set("Blue.world", p.getWorld().getName());
        main.getConfig().set("Blue.x", p.getLocation().getX());
        main.getConfig().set("Blue.y", p.getLocation().getY());
        main.getConfig().set("Blue.z", p.getLocation().getZ());
        main.saveConfig();
        p.sendMessage(MessageUtils.color("&6BEDWARS &8| &aSet blue bed location."));
    }

    @Override
    public String[] getAliases() {
        return new String[]{"setbluebed", "setblue"};
    }

    @Override
    public String getPermission() {
        return "bedwars.blue";
    }

    @Override
    public String getName() {
        return "blue";
    }
}