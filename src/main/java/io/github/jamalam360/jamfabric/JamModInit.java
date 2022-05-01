/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021 Jamalam360
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.github.jamalam360.jamfabric;

//import io.github.astrarre.itemview.v0.fabric.ItemKey;
// import io.github.foa.stackaware.v0.api.StackAware;

import io.github.jamalam360.jamfabric.config.JamFabricConfig;
import io.github.jamalam360.jamfabric.registry.*;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JamModInit implements ModInitializer {
    public static final String MOD_ID = "jamfabric";
    public static Logger LOGGER = LogManager.getLogger("Jamtastic");

    @Override
    public void onInitialize() {
        LOGGER.log(Level.INFO, "Initializing Jamtastic");

        AutoConfig.register(JamFabricConfig.class, GsonConfigSerializer::new);

        ItemRegistry.init();
        BlockRegistry.init();
        CompatRegistry.init();
        DataRegistry.init();
        NetworkingRegistry.init(false);

        // StackAware.MAX_COUNT_REGISTRY.forExact(ItemKey.of(ItemRegistry.JAM_JAR), (itemKey, count) -> {
        //     if (Jam.fromNbt(itemKey.getCompoundTag().getCompound("Jam")).ingredientsSize() > 0) {
        //         return 1;
        //     } else {
        //         return 16;
        //     }
        // });

        LOGGER.log(Level.INFO, "Jamtastic initialized");
    }
}
