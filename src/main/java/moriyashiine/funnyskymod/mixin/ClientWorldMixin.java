package moriyashiine.funnyskymod.mixin;

import moriyashiine.funnyskymod.util.FunnySkyModUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(ClientWorld.class)
public class ClientWorldMixin {
	@Inject(method = "method_23787", at = @At("RETURN"), cancellable = true)
	private void funnyskymod$changeStarOpacity(float f, CallbackInfoReturnable<Float> cir) {
		float multiplier = (float) FunnySkyModUtil.getMultiplier();
		if (multiplier < 1) {
			cir.setReturnValue(Math.max(cir.getReturnValueF(), (1 - multiplier) / 2));
		}
	}
}
