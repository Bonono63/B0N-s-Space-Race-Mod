package net.MrBonono63.bsr;

import blue.endless.jankson.Comment;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name="BSRConfig")
public class BSRConfig {
    @Comment(value = "Is the Space Toilet Enabled")
    public boolean isToiletEnabled = true;
}
