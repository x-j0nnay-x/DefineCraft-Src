package com.DefineCraft.Proxy;

import java.util.HashMap;
import java.util.Map;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.common.DefineCraftModItems;
import com.DefineCraft.models.ModleHellStoneArmorChest;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy  {
	


	@Override
	public void registerKeyBindings() {
		// TODO Auto-generated method stub
		
	}

public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	public void register_renderers(){
		
		ModleHellStoneArmorChest HellStone_Chest = new ModleHellStoneArmorChest(1F);
		
		armorModels.put(DefineCraftModItems.HellStoneChest, HellStone_Chest);

	}
}
