package com.enderville.mod.client.gui.mainmenu;

import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

import com.enderville.mod.common.lib.MainMenuInfo;

/**
 * MenuBaseEnderVille.java
 * 
 * EnderVille
 * 
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class MenuBaseEnderVille extends GuiScreen {

	/** Define Buttons **/
	GuiButton sspButton = null;
	GuiButton smpButton = null;
	GuiButton serverConnectButton = null;
	GuiButton enderDonateButton = null;
	GuiButton webLinksButton = null;
	GuiButton optionsButton = null;
	GuiButton quitButton = null;
	GuiButton langButton = null;
	
	public void updateScreen()
    {
        ++this.panoramaTimer;
    }

	private float updateCounter = 0.0F;

	private String splashText = "\u00a75" +  MainMenuInfo.splashText;
	private int panoramaTimer = 0;
	private DynamicTexture viewportTexture;
	private String field_92025_p;
	
	private static final ResourceLocation minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");

	private static final ResourceLocation[] titlePanoramaPaths = {
			new ResourceLocation("textures/gui/title/background/panorama_0.png"),
			new ResourceLocation("textures/gui/title/background/panorama_1.png"),
			new ResourceLocation("textures/gui/title/background/panorama_2.png"),
			new ResourceLocation("textures/gui/title/background/panorama_3.png"),
			new ResourceLocation("textures/gui/title/background/panorama_4.png"),
			new ResourceLocation("textures/gui/title/background/panorama_5.png") };

	private int field_92022_t;
	private int field_92021_u;
	private int field_92020_v;
	private int field_92019_w;
	private ResourceLocation viewportTextureLocation;
	
	public ServerData serverData = new ServerData(MainMenuInfo.serverName, MainMenuInfo.serverIP);

	public String getVersion() {
		return "EnderPack: " + MainMenuInfo.modpackVersion;
	}
	
	public MenuBaseEnderVille(){
		this.field_92025_p = "" + EnumChatFormatting.RESET + MainMenuInfo.noticeText;
	}

	private void connectToServer(ServerData par1ServerData)
    {
        this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, par1ServerData));
    }
	
	@SuppressWarnings("unchecked")
	public void initGui() {
		super.initGui(); 
		
		this.viewportTexture = new DynamicTexture(256, 256);
		this.viewportTextureLocation = this.mc.renderEngine
				.getDynamicTextureLocation("mc_background",
						this.viewportTexture);
		
		/** Add Buttons **/
		
		sspButton = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 24, "Singleplayer");
		sspButton.width = 98;
		this.buttonList.add(sspButton);
		
		smpButton = new GuiButton(1, this.width / 2 - 100, this.height / 4 + 24, "Multiplayer");
		smpButton.width = 98;
		smpButton.xPosition = this.width / 2 + 2;
		this.buttonList.add(smpButton);
		
		serverConnectButton = new GuiButton(2, this.width / 2 - 100, this.height / 4 + 48, MainMenuInfo.serverButtonText);
		this.buttonList.add(serverConnectButton);

		enderDonateButton = new GuiButton(3, this.width / 2 - 100, this.height / 4 + 72, "Donate");
		enderDonateButton.width = 98;
		enderDonateButton.xPosition = this.width / 2 + 2;
		this.buttonList.add(enderDonateButton);
		
		webLinksButton = new GuiButton(4, this.width / 2 - 100, this.height / 4 + 72, "Links");
		webLinksButton.width = 98;
		this.buttonList.add(webLinksButton);
		
		optionsButton = new GuiButton(5, this.width / 2 - 100, this.height / 4 + 96, "Options");
		optionsButton.width = 98;
		this.buttonList.add(optionsButton);
		
		quitButton = new GuiButton(6, this.width / 2 - 100, this.height / 4 + 96, "Quit");
		quitButton.width = 98;
		quitButton.xPosition = this.width / 2 + 2;
		this.buttonList.add(quitButton);
		
		langButton = new GuiButtonLanguage(7, this.width / 2 - 125, this.height / 4 + 96);
		this.buttonList.add(langButton);
		
	}
	
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id == 0) {
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if (par1GuiButton.id == 1) {
			this.mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if (par1GuiButton.id == 2) {
			this.connectToServer(serverData);
		}
		if (par1GuiButton.id == 3) {
			try {
				java.awt.Desktop.getDesktop().browse(new URI("http://enderville.com/account/upgrades"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		if (par1GuiButton.id == 4) {
			this.mc.displayGuiScreen(new GuiLinks(this));
		}
		if (par1GuiButton.id == 5) {
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
		}
		if (par1GuiButton.id == 6) {
			this.mc.shutdown();
		}
		if (par1GuiButton.id == 7) {
            this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
        }
		
	}
	private void drawPanorama(int par1, int par2, float par3)
    {
        Tessellator tessellator = Tessellator.instance;
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        byte b0 = 8;

        for (int k = 0; k < b0 * b0; ++k)
        {
            GL11.glPushMatrix();
            float f1 = ((float)(k % b0) / (float)b0 - 0.5F) / 64.0F;
            float f2 = ((float)(k / b0) / (float)b0 - 0.5F) / 64.0F;
            float f3 = 0.0F;
            GL11.glTranslatef(f1, f2, f3);
            GL11.glRotatef(MathHelper.sin(((float)this.panoramaTimer + par3) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-((float)this.panoramaTimer + par3) * 0.1F, 0.0F, 1.0F, 0.0F);

            for (int l = 0; l < 6; ++l)
            {
                GL11.glPushMatrix();

                if (l == 1)
                {
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (l == 2)
                {
                    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (l == 3)
                {
                    GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (l == 4)
                {
                    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                }

                if (l == 5)
                {
                    GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                }

                this.mc.getTextureManager().bindTexture(titlePanoramaPaths[l]);
                tessellator.startDrawingQuads();
                tessellator.setColorRGBA_I(16777215, 255 / (k + 1));
                float f4 = 0.0F;
                tessellator.addVertexWithUV(-1.0D, -1.0D, 1.0D, (double)(0.0F + f4), (double)(0.0F + f4));
                tessellator.addVertexWithUV(1.0D, -1.0D, 1.0D, (double)(1.0F - f4), (double)(0.0F + f4));
                tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, (double)(1.0F - f4), (double)(1.0F - f4));
                tessellator.addVertexWithUV(-1.0D, 1.0D, 1.0D, (double)(0.0F + f4), (double)(1.0F - f4));
                tessellator.draw();
                GL11.glPopMatrix();
            }

            GL11.glPopMatrix();
            GL11.glColorMask(true, true, true, false);
        }

        tessellator.setTranslation(0.0D, 0.0D, 0.0D);
        GL11.glColorMask(true, true, true, true);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    /**
     * Rotate and blurs the skybox view in the main menu
     */
    private void rotateAndBlurSkybox(float par1)
    {
        this.mc.getTextureManager().bindTexture(this.viewportTextureLocation);
        GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        byte b0 = 3;

        for (int i = 0; i < b0; ++i)
        {
//            tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float)(i + 1));
            int j = this.width;
            int k = this.height;
            float f1 = (float)(i - b0 / 2) / 256.0F;
            tessellator.addVertexWithUV((double)j, (double)k, (double)this.zLevel, (double)(0.0F + f1), 0.0D);
            tessellator.addVertexWithUV((double)j, 0.0D, (double)this.zLevel, (double)(1.0F + f1), 0.0D);
            tessellator.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(1.0F + f1), 1.0D);
            tessellator.addVertexWithUV(0.0D, (double)k, (double)this.zLevel, (double)(0.0F + f1), 1.0D);
        }

        tessellator.draw();
        GL11.glColorMask(true, true, true, true);
    }

    /**
     * Renders the skybox in the main menu
     */
    private void renderSkybox(int par1, int par2, float par3)
    {
        GL11.glViewport(0, 0, 256, 256);
        this.drawPanorama(par1, par2, par3);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        this.rotateAndBlurSkybox(par3);
        GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        float f1 = this.width > this.height ? 120.0F / (float)this.width : 120.0F / (float)this.height;
        float f2 = (float)this.height * f1 / 256.0F;
        float f3 = (float)this.width * f1 / 256.0F;
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
//        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        int k = this.width;
        int l = this.height;
        tessellator.addVertexWithUV(0.0D, (double)l, (double)this.zLevel, (double)(0.5F - f2), (double)(0.5F + f3));
        tessellator.addVertexWithUV((double)k, (double)l, (double)this.zLevel, (double)(0.5F - f2), (double)(0.5F - f3));
        tessellator.addVertexWithUV((double)k, 0.0D, (double)this.zLevel, (double)(0.5F + f2), (double)(0.5F - f3));
        tessellator.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(0.5F + f2), (double)(0.5F + f3));
        tessellator.draw();
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.renderSkybox(par1, par2, par3);
        Tessellator tessellator = Tessellator.instance;
        short short1 = 274;
        int k = this.width / 2 - short1 / 2;
        byte b0 = 30;
        this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
        this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
        this.mc.getTextureManager().bindTexture(minecraftTitleTextures);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if ((double)this.updateCounter < 1.0E-4D)
        {
            this.drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 99, 44);
            this.drawTexturedModalRect(k + 99, b0 + 0, 129, 0, 27, 44);
            this.drawTexturedModalRect(k + 99 + 26, b0 + 0, 126, 0, 3, 44);
            this.drawTexturedModalRect(k + 99 + 26 + 3, b0 + 0, 99, 0, 26, 44);
            this.drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
        }
        else
        {
            this.drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 155, 44);
            this.drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
        }

        tessellator.setColorOpaque_I(16777215);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.width / 2 + 90), 70.0F, 0.0F);
        GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
        float f1 = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
        f1 = f1 * 100.0F / (float)(this.fontRenderer.getStringWidth(this.splashText) + 32);
        GL11.glScalef(f1, f1, f1);
        this.drawCenteredString(this.fontRenderer, this.splashText, 0, -8, 0x8A0868);
        GL11.glPopMatrix();
		String s = "Minecraft 1.6.4";
		this.drawString(this.fontRenderer, s, 2, this.height - ( 10 + 0 * (this.fontRenderer.FONT_HEIGHT + 1)), Color.YELLOW.getRGB());

		if (this.mc.isDemo()) {
			s = s + " Demo";
		}

		String s1 = this.getVersion();
		drawString(this.fontRenderer, s1, this.width - this.fontRenderer.getStringWidth(s1) - 2, this.height - 10, 0x8A0868);

		if ((this.field_92025_p != null) && (this.field_92025_p.length() > 0)) {
			drawRect(this.field_92022_t - 2, this.field_92021_u - 2,
					this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
			drawString(this.fontRenderer, this.field_92025_p,
					this.field_92022_t, this.field_92021_u, 16777215);
		}

		super.drawScreen(par1, par2, par3);
	}
}
