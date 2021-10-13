package net.dohaw.corelib.holograms;

import net.dohaw.corelib.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class AnimationsConfig extends Config {

    protected AnimationsConfig(JavaPlugin plugin) {
        super(plugin, "holograms/animations.yml");
    }

    protected boolean hasAnimation(String hologramName, int numLine){
        return config.getString("Animations." + hologramName + "." + numLine + ".Lines") != null;
    }

    protected boolean animationIsEnabled(String hologramName, int numLine){
        return config.getBoolean("Animations." + hologramName + "." + numLine + ".Enabled");
    }

    protected void setAnimationStatus(String hologramName, int numLine, boolean isEnabled){
        config.set("Animations." + hologramName + "." + numLine + ".Enabled", isEnabled);
    }

    protected List<String> getAnimationLines(String hologramName, int numLine){
        return config.getStringList("Animations." + hologramName + "." + numLine + ".Lines");
    }

    protected void removeAnimation(String hologramName){
        config.set("Animations." + hologramName, null);
    }

    protected void addAsAnimatable(String hologramName, int numLine){
        HologramsConfig hcm = new HologramsConfig(plugin);
        String hologramLine = hcm.getHologramLine(hologramName, numLine);
        List<String> lines = Arrays.asList(hologramLine.split(" "));
        config.set("Animations." + hologramName + "." + numLine + ".Lines", lines);
    }

    protected void addAnimationLine(String hologramName, String text, int numLine){
        List<String> animationLines = getAnimationLines(hologramName, numLine);
        animationLines.add(text);
        config.set("Animations." + hologramName  + "." + numLine + ".Lines", animationLines);
    }

    protected void setAnimationLines(String hologramName, List<String> lines, int numLine){
        config.set("Animations." + hologramName  + "." + numLine + ".Lines", lines);
    }

}
