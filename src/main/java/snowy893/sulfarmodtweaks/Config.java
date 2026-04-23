package snowy893.sulfarmodtweaks;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An snowy893 config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = SulfarModTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue BURN_TIME = BUILDER
            .comment("Burn time in ticks of <sulfar_mod:sulfar>")
            .defineInRange("burnTime", 800, 0, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static int burnTime;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        burnTime = BURN_TIME.get();
    }
}
