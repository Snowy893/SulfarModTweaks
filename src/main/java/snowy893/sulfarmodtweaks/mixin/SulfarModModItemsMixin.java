package snowy893.sulfarmodtweaks.mixin;

import net.cursedwarrior.sulfarmod.init.SulfarModModBlocks;
import net.cursedwarrior.sulfarmod.init.SulfarModModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import snowy893.sulfarmodtweaks.Config;
import snowy893.sulfarmodtweaks.item.FuelBlockItem;
import snowy893.sulfarmodtweaks.item.FuelItem;

@Mixin(SulfarModModItems.class)
abstract class SulfarModModItemsMixin {
    @Mutable @Final @Shadow
    public static DeferredRegister<Item> REGISTRY;
    @Mutable @Final @Shadow
    public static RegistryObject<Item> SULFAR;
    @Mutable @Final @Shadow
    public static RegistryObject<Item> NETHER_SULFAR_ORE;
    @Mutable @Final @Shadow
    public static RegistryObject<Item> SULFAR_BLOCK;
    
    @Inject(method = "<clinit>", at = @At("HEAD"), cancellable = true, remap = false)
    private static void init(CallbackInfo ci) {
        REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "sulfar_mod");
        SULFAR = REGISTRY.register("sulfar", () ->
                new FuelItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON), Config.burnTime));
        NETHER_SULFAR_ORE = REGISTRY.register(SulfarModModBlocks.NETHER_SULFAR_ORE.getId().getPath(), () ->
                new BlockItem(SulfarModModBlocks.NETHER_SULFAR_ORE.get(), new Item.Properties()));
        SULFAR_BLOCK = REGISTRY.register(SulfarModModBlocks.SULFAR_BLOCK.getId().getPath(), () ->
                new FuelBlockItem(SulfarModModBlocks.SULFAR_BLOCK.get(), new Item.Properties(), Config.blockBurnTime));
        ci.cancel();
    }
}
