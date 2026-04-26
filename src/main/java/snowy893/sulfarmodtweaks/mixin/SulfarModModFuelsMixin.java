package snowy893.sulfarmodtweaks.mixin;

import net.cursedwarrior.sulfarmod.init.SulfarModModFuels;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import snowy893.sulfarmodtweaks.SulfarModTweaks;

@Mixin(SulfarModModFuels.class)
abstract class SulfarModModFuelsMixin {
    @Inject(method = "furnaceFuelBurnTimeEvent", at = @At("HEAD"), cancellable = true, remap = false)
    private static void sulfarModTweaks$furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event, CallbackInfo ci) {
        SulfarModTweaks.LOGGER.warn("Burn time mixin method invoked");
        ci.cancel();
    }
}
