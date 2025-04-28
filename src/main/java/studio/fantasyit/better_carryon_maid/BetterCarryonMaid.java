package studio.fantasyit.better_carryon_maid;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BetterCarryonMaid.MODID)
public class BetterCarryonMaid {
    public static final String MODID = "better_carryon_maid";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public BetterCarryonMaid(IEventBus modEventBus, ModContainer modContainer) {
    }
}
