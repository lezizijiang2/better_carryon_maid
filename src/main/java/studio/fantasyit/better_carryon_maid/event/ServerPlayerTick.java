package studio.fantasyit.better_carryon_maid.event;


import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import studio.fantasyit.better_carryon_maid.BetterCarryonMaid;
import tschipp.carryon.common.carry.CarryOnData;
import tschipp.carryon.common.carry.CarryOnDataManager;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = BetterCarryonMaid.MODID)
public class ServerPlayerTick {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) {
            return;
        }
        CarryOnData data = CarryOnDataManager.getCarryData(event.getEntity());
        if (data.isCarrying(CarryOnData.CarryType.ENTITY)) {
            Entity carried = data.getEntity(event.getEntity().level());
            Entity passenger = event.getEntity().getFirstPassenger();
            if (carried instanceof EntityMaid && !(passenger instanceof EntityMaid)) {
                data.clear();
                CarryOnDataManager.setCarryData(event.getEntity(), data);
            }
        }
    }
}
