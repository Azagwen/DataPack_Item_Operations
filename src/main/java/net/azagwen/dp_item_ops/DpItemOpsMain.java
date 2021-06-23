package net.azagwen.dp_item_ops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DpItemOpsMain implements ModInitializer {
	public static final Logger LOGGER  = LogManager.getLogger("Datapack Item Operations Main");
	public static final String nameSpace = "dp_item_ops";

	@Override
	public void onInitialize() {
		ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new DataResourceListener());

		LOGGER.info("Datapack Item Operations initialized!");
	}
}
