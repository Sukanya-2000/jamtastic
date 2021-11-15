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

package io.github.jamalam360.jamfabric.util.helper;

import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jamalam360
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
public class NbtHelper {
    //region Item Storage in NBT
    public static NbtCompound writeItems(NbtCompound compound, String baseKey, Item... items) {
        ArrayList<Item> appendedItems = new ArrayList<>(List.of(items));
        appendedItems.addAll(Arrays.asList(readItems(compound, baseKey)));

        compound.putInt(baseKey + "Length", appendedItems.size());
        for (int i = 0; i < appendedItems.size(); i++) {
            compound.putString(baseKey + i, Registry.ITEM.getId(appendedItems.get(i)).toString());
        }

        return compound;
    }

    public static Item[] readItems(NbtCompound compound, String baseKey) {
        ArrayList<Item> items = new ArrayList<>();

        for (int i = 0; i < compound.getInt(baseKey + "Length"); i++) {
            items.add(Registry.ITEM.get(new Identifier(compound.getString(baseKey + i))));
        }

        return items.toArray(new Item[0]);
    }

    public static NbtCompound writeItem(NbtCompound compound, String key, Item item) {
        compound.putString(key, Registry.ITEM.getId(item).toString());
        return compound;
    }

    public static Item readItem(NbtCompound compound, String key) {
        return Registry.ITEM.get(new Identifier(compound.getString(key)));
    }
    //endregion
}