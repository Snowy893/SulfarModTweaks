package snowy893.sulfarmodtweaks;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = SulfarModTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue BURN_TIME = BUILDER
            .comment("Burn time in ticks for sulfar item.")
            .defineInRange("burnTime", 800, 0, Integer.MAX_VALUE);
    
    private static final ForgeConfigSpec.IntValue BLOCK_BURN_TIME = BUILDER
            .comment("Burn time in ticks for sulfar block item.")
            .defineInRange("blockBurnTime", 8000, 0, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static int burnTime;
    public static int blockBurnTime;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        burnTime = BURN_TIME.get();
        blockBurnTime = BLOCK_BURN_TIME.get();
    }
}
