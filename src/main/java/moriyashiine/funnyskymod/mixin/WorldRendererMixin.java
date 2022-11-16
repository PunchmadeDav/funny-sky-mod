package moriyashiine.funnyskymod.mixin;

import moriyashiine.funnyskymod.util.FunnySkyModUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
	@ModifyVariable(method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/math/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/world/ClientWorld;getSkyColor(Lnet/minecraft/util/math/Vec3d;F)Lnet/minecraft/util/math/Vec3d;"))
	private Vec3d funnyskymod$changeSkyColor(Vec3d value) {
		double multiplier = FunnySkyModUtil.getMultiplier();
		if (multiplier < 1) {
			return value.multiply(multiplier);
		}
		return value;
	}
}
