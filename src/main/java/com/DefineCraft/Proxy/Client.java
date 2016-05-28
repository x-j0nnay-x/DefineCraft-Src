package com.DefineCraft.Proxy;

import java.util.HashMap;
import java.util.Map;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.models.ModleHellStoneArmorChest;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

public class Client extends Common  {
	
public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	public static void NewArrmorRenderer(){
		
		ModleHellStoneArmorChest HellStone_Chest = new ModleHellStoneArmorChest(1F);
		
		armorModels.put(DefineCraftMod.HellStoneChest, HellStone_Chest);

	}
	
	

public void registerRenderInfor(){
		
	}


}
