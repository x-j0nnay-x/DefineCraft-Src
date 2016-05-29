package com.DefineCraft.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModleHellStoneArmorChest extends ModelBiped
{
	//fields
    
    ModelRenderer wingAttatch0;
    ModelRenderer Wing2;
    ModelRenderer Wing1;
  
  public ModleHellStoneArmorChest(float expand)
  {
	 super(expand, 0, 128, 64);
    textureWidth = 128;
    textureHeight = 64;
    
      
      wingAttatch0 = new ModelRenderer(this, 22, 35);
      wingAttatch0.addBox(-2F, 0F, 2F, 4, 4, 1, expand);
      wingAttatch0.setRotationPoint(0F, 0F, 0F);
      wingAttatch0.setTextureSize(128, 64);
      wingAttatch0.mirror = true;
      setRotation(wingAttatch0, 0F, 0F, 0F);
      Wing2 = new ModelRenderer(this, 70, 19);
      Wing2.addBox(-34F, -4F, 0.6333333F, 32, 17, 0, expand);
      Wing2.setRotationPoint(0F, 0F, 0F);
      Wing2.setTextureSize(128, 64);
      Wing2.mirror = true;
      setRotation(Wing2, 0F, 0.837758F, 0F);
      Wing1 = new ModelRenderer(this, 38, 39);
      Wing1.addBox(2F, -3F, 0.6333333F, 32, 17, 0, expand);
      Wing1.setRotationPoint(0F, 0F, 0F);
      Wing1.setTextureSize(128, 64);
      Wing1.mirror = true;
      setRotation(Wing1, 0F, -0.837758F, 0F);
      
      this.bipedBody.addChild(wingAttatch0);
      wingAttatch0.addChild(Wing1);
      wingAttatch0.addChild(Wing2);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
   
    wingAttatch0.render(f5);
    Wing2.render(f5);
    Wing1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
