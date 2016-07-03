package com.austinv11.peripheralsplusplus.items;

import com.austinv11.peripheralsplusplus.PeripheralsPlusPlus;
import com.austinv11.peripheralsplusplus.reference.Config;
import com.austinv11.peripheralsplusplus.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemPermCard extends ItemPPP {
	public ItemPermCard() {
		super();
		this.setMaxStackSize(1);
	}

	@Override
	public String getName() {
		return "itemPermCard";
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (Config.enablePlayerInterface) {
			NBTTagCompound compound = itemStackIn.getTagCompound();
			if (!playerIn.isSneaking()) {
				if (!worldIn.isRemote) {
					if (compound == null) {
						compound = new NBTTagCompound();
					}

					if (compound.getTag("profile") == null) {
						NBTTagCompound nbt = new NBTTagCompound();
						NBTUtil.writeGameProfile(nbt, playerIn.getGameProfile());
						compound.setTag("profile", nbt);

						compound.setBoolean("getStacks", false);
						compound.setBoolean("withdraw", false);
						compound.setBoolean("deposit", false);
						playerIn.addChatComponentMessage(new TextComponentTranslation("peripheralsplusplus.chat.permCard.set"));
						itemStackIn.setTagCompound(compound);
					} else {
						playerIn.addChatComponentMessage(new TextComponentTranslation("peripheralsplusplus.chat.permCard.alreadySet"));
					}
				}
			} else {
				if (compound == null || itemStackIn.getTagCompound().getTag("profile") == null) {
					if (!worldIn.isRemote) {
						playerIn.addChatComponentMessage(new TextComponentTranslation("peripheralsplusplus.chat.permCard.notSet"));
					}
					return ActionResult.newResult(EnumActionResult.FAIL, itemStackIn);
				}
				if (!NBTUtil.readGameProfileFromNBT((NBTTagCompound) itemStackIn.getTagCompound().getTag("profile")).getId().toString().equals(playerIn.getGameProfile().getId().toString())) {
					if (!worldIn.isRemote) {
						playerIn.addChatComponentMessage(new TextComponentTranslation("peripheralsplusplus.chat.permCard.wrongOwner"));
					}
					return ActionResult.newResult(EnumActionResult.FAIL, itemStackIn);
				}

				playerIn.openGui(PeripheralsPlusPlus.instance, Reference.GUIs.PERM_CARD.ordinal(), worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
			}
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
	}
}
