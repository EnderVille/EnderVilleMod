package com.enderville.mod.client.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import com.enderville.mod.common.lib.ModInfo;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.Loader;

/**
 * EventSkinRender.java
 * 
 * EnderVille
 *
 * @author DylanGore
 * @license DylanGore Mod License (http://mods.dylangore.info/license.txt)
 * 
 */

public class EventSkinRender {
	private final String serverLocation = "https://raw.github.com/EnderVille/EnderVilleMod/master/files/skins.txt";
    private final int timeout = 1000;

    private static final Graphics TEST_GRAPHICS = new BufferedImage(64, 32, BufferedImage.TYPE_INT_RGB).getGraphics();
    private HashMap<String, String> skins = new HashMap<String, String>();
    public static ArrayList<AbstractClientPlayer> skinPlayers = new ArrayList<AbstractClientPlayer>();

    public static EventSkinRender instance;

    public EventSkinRender()
    {
        buildSkinURLDatabase();
        instance = this;
    }

    @ForgeSubscribe
    public void onPreRenderSpecials (RenderPlayerEvent.Specials.Pre event)
    {
        if (Loader.isModLoaded("shadersmod") || (Loader.isModLoaded("Optifine")))
        {
            return;
        }
        if (event.entityPlayer instanceof AbstractClientPlayer)
        {
            AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer) event.entityPlayer;

            if (!skinPlayers.contains(abstractClientPlayer))
            {
                String skinUrl = skins.get(event.entityPlayer.username);

                if (skinUrl == null)
                {
                    return;
                }

                skinPlayers.add(abstractClientPlayer);

                abstractClientPlayer.getTextureSkin().textureUploaded = false;
                new Thread(new SkinThread(abstractClientPlayer, skinUrl)).start();
                event.renderCape = true;
            }
        }
    }

    public void buildSkinURLDatabase ()
    {
        URL url;
        try
        {
            url = new URL(serverLocation);
            URLConnection con = url.openConnection();
            con.setConnectTimeout(timeout);
            con.setReadTimeout(timeout);
            InputStream io = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(io));

            String str;
            int linetracker = 1;
            while ((str = br.readLine()) != null)
            {
                if (!str.startsWith("--"))
                {
                    if (str.contains(":"))
                    {
                        String nick = str.substring(0, str.indexOf(":"));
                        String link = str.substring(str.indexOf(":") + 1);
                        new Thread(new SkinPreload(link)).start();
                        skins.put(nick, link);
                    }
                    else
                    {
                        System.err.println("[" + ModInfo.ID + "]" + " [skins.txt] Syntax error on line " + linetracker + ": " + str);
                    }
                }
                linetracker++;
            }

            br.close();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private class SkinThread implements Runnable
    {

        AbstractClientPlayer abstractClientPlayer;
        String skinUrl;

        public SkinThread(AbstractClientPlayer player, String skin)
        {
            abstractClientPlayer = player;
            skinUrl = skin;
        }

        @Override
        public void run ()
        {
            try
            {
                Image skin = new ImageIcon(new URL(skinUrl)).getImage();
                BufferedImage bo = new BufferedImage(skin.getWidth(null), skin.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                bo.getGraphics().drawImage(skin, 0, 0, null);
                abstractClientPlayer.getTextureSkin().bufferedImage = bo;
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }
    }

    private class SkinPreload implements Runnable
    {
        String skinUrl;

        public SkinPreload(String link)
        {
            skinUrl = link;
        }

        @Override
        public void run ()
        {
            try
            {
                TEST_GRAPHICS.drawImage(new ImageIcon(new URL(skinUrl)).getImage(), 0, 0, null);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void refreshSkins ()
    {
        skins.clear();
        skinPlayers.clear();
        buildSkinURLDatabase();
    }
}
