package com.enderville.mod.client.gui.mainmenu;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;

import org.lwjgl.opengl.GL11;

/**
 * GuiLinks.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class GuiLinks extends GuiScreen{
	
	/**
     * A reference to the screen object that created this. Used for navigating between screens.
     */
    @SuppressWarnings("unused")
	private final GuiScreen parentScreen;
	
    /** The title string that is displayed in the top-center of the screen. */
    protected String screenTitle = "Links";
    
	public GuiLinks(GuiScreen screen)
    {
        this.parentScreen = screen;
    }
	
	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @SuppressWarnings({ "unchecked", "unused" })
	public void initGui()
    {
        int i = 0;
        this.screenTitle = I18n.getString("Links");

        this.buttonList.add(new GuiButton(101, this.width / 2 - 152, this.height / 6 + 24 - 6, 150, 20, "EnderVille Website"));
        this.buttonList.add(new GuiButton(102, this.width / 2 + 2, this.height / 6 + 24 - 6, 150, 20, "EnderWiki"));
        this.buttonList.add(new GuiButton(103, this.width / 2 - 152, this.height / 6 + 48 - 6, 150, 20, "Teamspeak"));
        this.buttonList.add(new GuiButton(104, this.width / 2 + 2, this.height / 6 + 48 - 6, 150, 20, "PlugDJ"));
        this.buttonList.add(new GuiButton(105, this.width / 2 - 152, this.height / 6 + 72 - 6, 150, 20, "Twitter"));
        this.buttonList.add(new GuiButton(106, this.width / 2 + 2, this.height / 6 + 72 - 6, 150, 20, "Youtube"));
        this.buttonList.add(new GuiButton(107, this.width / 2 - 100, this.height / 6 + 120, "The EnderNet"));
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, "Back"));
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
            if (par1GuiButton.id == 101)
            {
            	try {
					java.awt.Desktop.getDesktop().browse(new URI("http://enderville.com"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            }
            
            if (par1GuiButton.id == 102)
            {
            	try {
					java.awt.Desktop.getDesktop().browse(new URI("http://wiki.enderville.com"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            }
            
            if (par1GuiButton.id == 103)
            {
            	try {
					java.awt.Desktop.getDesktop().browse(new URI("https://dl.dropboxusercontent.com/u/64420696/Minecraft/EnderVille/enderville_ts.html"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            }
            
            if (par1GuiButton.id == 104)
            {
            	try {
					java.awt.Desktop.getDesktop().browse(new URI("http://plug.dj/enderville-1/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            }
            
            if (par1GuiButton.id == 105)
            {
            	try {
					java.awt.Desktop.getDesktop().browse(new URI("http://twitter.com/enderville/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            }
            
            if (par1GuiButton.id == 106)
            {
            	try {
					java.awt.Desktop.getDesktop().browse(new URI("http://youtube.com/EnderVilleOfficial/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            }
            if (par1GuiButton.id == 107)
            {
            	try {
					java.awt.Desktop.getDesktop().browse(new URI("http://endernet.info"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
            }
            
            if (par1GuiButton.id == 200)
            {
            	this.mc.displayGuiScreen(new MenuBaseEnderVille());
            }
    }
    
    @Override
    public void drawBackground(int par1)
    {
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator tessellator = Tessellator.instance;
        this.mc.getTextureManager().bindTexture(optionsBackground);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(4210752);
        tessellator.addVertexWithUV(0.0D, (double)this.height, 0.0D, 0.0D, (double)((float)this.height / f + (float)par1));
        tessellator.addVertexWithUV((double)this.width, (double)this.height, 0.0D, (double)((float)this.width / f), (double)((float)this.height / f + (float)par1));
        tessellator.addVertexWithUV((double)this.width, 0.0D, 0.0D, (double)((float)this.width / f), (double)par1);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, (double)par1);
        tessellator.draw();
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 15, 16777215);
        super.drawScreen(par1, par2, par3);
    }
}
