package com.DefineCraft.Proxy;

import java.util.HashMap;
import java.util.Map;

import com.DefineCraft.common.DefineCraftMod;
import com.DefineCraft.models.ModleHellStoneArmorChest;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;

public interface IProxy
{
public abstract void registerKeyBindings();
public void register_renderers();
}
