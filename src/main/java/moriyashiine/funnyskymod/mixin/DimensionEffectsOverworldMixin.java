package moriyashiine.funnyskymod.mixin;

import moriyashiine.funnyskymod.util.FunnySkyModUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.DimensionEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Environment(EnvType.CLIENT)
@Mixin(DimensionEffects.Overworld.class)
public class DimensionEffectsOverworldMixin {
	@ModifyVariable(method = "adjustFogColor", at = @At("HEAD"), argsOnly = true)
	private float funnyskymod$changeFogColor(float value) {
		return (float) (value * FunnySkyModUtil.getMultiplier());
	}
}
