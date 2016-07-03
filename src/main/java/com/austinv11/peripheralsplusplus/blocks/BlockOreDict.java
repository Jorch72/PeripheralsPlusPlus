package com.austinv11.peripheralsplusplus.blocks;

import com.austinv11.peripheralsplusplus.PeripheralsPlusPlus;
import com.austinv11.peripheralsplusplus.reference.Reference;
import com.austinv11.peripheralsplusplus.tile.TileOreDict;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockOreDict extends BlockPPP implements ITileEntityProvider {
	public BlockOreDict() {
		super(Material.IRON);
	}

	@Override
	public String getName() {
		return "blockOreDict";
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileOreDict();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (!worldIn.isRemote) {
			if (tile != null) {
				playerIn.openGui(PeripheralsPlusPlus.instance, Reference.GUIs.ORE_DICT.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}
}
