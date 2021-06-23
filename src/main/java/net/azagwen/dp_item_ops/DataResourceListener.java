package net.azagwen.dp_item_ops;

import com.google.common.collect.HashBasedTable;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class DataResourceListener implements SimpleSynchronousResourceReloadListener {
    public static final Logger LOGGER  = LogManager.getLogger("Item Operations Listener");
    public static HashBasedTable<Item, Block, ItemOperationResult> BTB_OPS = HashBasedTable.create();
    final boolean debug = false;

    @Override
    public void reload(ResourceManager manager) {
        //Item operation data
        //Clear the Table before re-filling it.
        BTB_OPS.clear();
        for(Identifier id : manager.findResources(DpItemOpsMain.nameSpace + "/item_operations", path -> path.endsWith(".json"))) {
            //Try to fill the table for each id in "*/data/atbyw/item_operations/..."
            try {
                InputStream stream = manager.getResource(id).getInputStream();
                ItemOperationDecoder.readBlockToBlock(stream, BTB_OPS);
            } catch (IOException e) {
                LOGGER.error("Error occurred while loading resource json " + id.toString(), e);
            }
        }
        if (debug) {
            for (var cell : BTB_OPS.cellSet()) {
                LOGGER.info(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
            }
        }
        LOGGER.info("Item Opration Data loaded !");
    }

    @Override
    public Identifier getFabricId() {
        return new DpItemOpsIdentifier("data");
    }
}

