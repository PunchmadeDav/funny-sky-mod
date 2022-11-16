package moriyashiine.funnyskymod.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class FunnySkyModUtil {
	public static double getMultiplier() {
		if (MinecraftClient.getInstance().getCameraEntity() == null) {
			return 1;
		}
		return MathHelper.clamp((300 - MinecraftClient.getInstance().getCameraEntity().getY()) / 10, 0, 1);
	}
}
