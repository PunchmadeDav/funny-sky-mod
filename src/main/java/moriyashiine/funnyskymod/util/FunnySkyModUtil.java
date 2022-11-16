package moriyashiine.funnyskymod.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class FunnySkyModUtil {
	public static double getMultiplier() {
		Entity cameraEntity = MinecraftClient.getInstance().getCameraEntity();
		if (cameraEntity == null) {
			return 1;
		}
		return MathHelper.clamp((300 - cameraEntity.getY()) / 10, 0, 1);
	}
}
