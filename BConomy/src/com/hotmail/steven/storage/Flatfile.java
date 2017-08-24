package com.hotmail.steven.storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.hotmail.steven.bconomy.BConomy;

public class Flatfile {

	/**
	 * The config file
	 */
	private File cfgFile;
	
	/**
	 * The config fileconfiguration
	 */
	private FileConfiguration cfg;
	
	/**
	 * If using a resource, the resource name
	 */
	private String resourceName;
	
	/**
	 * The instance of BConomy plugin
	 */
	private BConomy plugin;
	
	/**
	 * Create an instance of a flatfile database
	 * 
	 * @param plugin BConomy plugin instance
	 * @param cfgName The config name e.g test.yml
	 * @param path The path on disk where we want the cfg to be located
	 * @param resourceName The resource name from BConomy jar. Set to null if not needed
	 */
	public Flatfile(BConomy plugin, String cfgName, File path, String resourceName) {

		this.plugin = plugin;
		
		if(!path.exists()) path.mkdirs();
		
		cfgFile = new File(path.getAbsolutePath() + File.separator + cfgName);
		
		if(!cfgFile.exists()) {
			
			try {

				cfgFile.createNewFile();

				Bukkit.getLogger().info("[BConomy] Generating " + cfgName + " flatfile");
				
			} catch (IOException e) {

				e.printStackTrace();
				
			}
			
		}
		
		cfg = YamlConfiguration.loadConfiguration(cfgFile);
		
		if(resourceName != null && !cfgFile.exists()) {
			
			copyDefaults();
			
		}
		
	}
	
	public void save() {
		
		try {
			
			cfg.save(cfgFile);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}
	
	public void copyDefaults() {
		
		InputStream in = plugin.getResource(resourceName);
		
		if(in == null) return;
		
		try {
			
			OutputStream out = new FileOutputStream(cfgFile);
			
			byte[] buf = new byte[1024];
			
			int len;
			
			while ((len = in.read(buf)) > 0) {
				
				out.write(buf, 0, len);
			
			}
			
			out.close();
			
			in.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	public long getLong(String path) {
		
		return cfg.getLong(path);
		
	}
	
	public void setLong(String path, long value) {
		
		cfg.set(path, value);
		
		save();
		
	}
	
	public int getInt(String path) {
		
		return cfg.getInt(path);
		
	}
	
	public void setInt(String path, int value) {
		
		cfg.set(path, value);
		
		save();
		
	}
	
	public List<String> getList(String path) {
		
		return cfg.getStringList(path);
		
	}
	
	public void setList(String path, List<String> value) {
		
		cfg.set(path, value);
		
		save();
		
	}
	
}
