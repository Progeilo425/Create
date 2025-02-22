package com.simibubi.create.content.schematics.item;

import com.simibubi.create.foundation.utility.NBTHelper;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;

public class SchematicAndQuillItem extends Item {

	public SchematicAndQuillItem(Properties properties) {
		super(properties);
	}

	public static void replaceStructureVoidWithAir(CompoundTag nbt) {
		String air = Blocks.AIR.getRegistryName()
			.toString();
		String structureVoid = Blocks.STRUCTURE_VOID.getRegistryName()
			.toString();

		NBTHelper.iterateCompoundList(nbt.getList("palette", 10), c -> {
			if (c.contains("Name") && c.getString("Name")
				.equals(structureVoid)) {
				c.putString("Name", air);
			}
		});
	}

}
