package com.enderville.mod.common.lib;

import com.enderville.mod.EnderVille;

/**
 * MainMenuInfo.java
 * 
 * EnderVille
 *
 * @author DylanGore (http://github.com/DylanGore)
 * @license LGPL v3 (https://github.com/EnderVille/EnderVilleMod/blob/master/LICENSE)
 * 
 */

public class MainMenuInfo {

	public static String versionFileURL; 
	public static String noticeFileURL; 
	
	public static boolean enabled;
	
	public static String serverIP;
	public static String serverName;
	public static String serverButtonText;
	
	public static final String noticeText = EnderVille.getWebFile("http://enderville.com/emf/notice.txt");
	
	public static final String modpackVersion = EnderVille.getWebFile("http://enderville.com/emf/version.txt");
	
	public static String splashText;
	
	
	
}
