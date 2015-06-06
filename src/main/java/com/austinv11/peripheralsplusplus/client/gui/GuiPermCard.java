package com.austinv11.peripheralsplusplus.client.gui;

import com.austinv11.collectiveframework.minecraft.utils.NBTHelper;
import com.austinv11.peripheralsplusplus.reference.Reference;
import com.austinv11.peripheralsplusplus.tiles.containers.ContainerEmpty;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiPermCard extends GuiContainer
{
    private ItemStack permCard;
    private ResourceLocation backgroundimage = new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/gui/guiPermCard.png");
    private int sizeX, sizeY;

    public GuiPermCard(ItemStack card)
    {
        super(new ContainerEmpty());
        this.permCard = card;
        sizeX = 132;
        sizeY = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(backgroundimage);
        int x = (width - sizeX) / 2;
        int y = (height - sizeY) / 2;
        drawTexturedModalRect(x, y, 0, 0, sizeX, sizeY);
        // Have to draw the buttons before the text because mojang
        drawTexturedModalRect(x + 10, y + 40, permCard.getTagCompound().getBoolean("getStacks") ? 0 : 9, 166, 9, 9);
        drawTexturedModalRect(x + 10, y + 60, permCard.getTagCompound().getBoolean("withdraw") ? 0 : 9, 166, 9, 9);
        drawTexturedModalRect(x + 10, y + 80, permCard.getTagCompound().getBoolean("deposit") ? 0 : 9, 166, 9, 9);
        fontRendererObj.drawString(StatCollector.translateToLocal("peripheralsplusplus.inv.permCard"), x + 22, y + 5, 0x313131);
        fontRendererObj.drawString(StatCollector.translateToLocal("peripheralsplusplus.inv.permCard.perms"), x + 32, y + 20, 0x313131);
        fontRendererObj.drawString(StatCollector.translateToLocal("peripheralsplusplus.inv.permCard.get"), x + 25, y + 40, 0x313131);
        fontRendererObj.drawString(StatCollector.translateToLocal("peripheralsplusplus.inv.permCard.withdraw"), x + 25, y + 60, 0x313131);
        fontRendererObj.drawString(StatCollector.translateToLocal("peripheralsplusplus.inv.permCard.deposit"), x + 25, y + 80, 0x313131);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int par3)
    {
        int x = (width - sizeX) / 2;
        int y = (height - sizeY) / 2;
        if (mouseX >= x + 10 && mouseX < x + 20)
        {
            if (mouseY >= y + 40 && mouseY < y + 50)
            {
                NBTHelper.setBoolean(permCard, "getStacks", !NBTHelper.getBoolean(permCard, "getStacks"));
            }

            if (mouseY >= y + 60 && mouseY < y + 70)
            {
                NBTHelper.setBoolean(permCard, "withdraw", !NBTHelper.getBoolean(permCard, "withdraw"));
            }

            if (mouseY >= y + 80 && mouseY < y + 90)
            {
                NBTHelper.setBoolean(permCard, "deposit", !NBTHelper.getBoolean(permCard, "deposit"));
            }
        }
    }
}
