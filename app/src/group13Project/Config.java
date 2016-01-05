package group13Project;
import java.io.File;
import java.io.IOException;

public class Config {
	
	private boolean hasConfig = false;
	private String configFolderDir;
	private File config = null;
	
	
	
	public Config() {
		
		//check if config file exist on local system
		setConfigFolderDir(System.getProperty("user.home") + File.separator+ "Desktop/group13ProjectFolder");
		File configFile = new File(System.getProperty("user.home"), "Desktop"+ File.separator+ "group13ProjectFolder" + File.separator +"config.properties");
		setHasConfig(configFile.exists());
		
		
	}
	private void setConfigFolderDir(String dir) {
		this.configFolderDir = dir;
	}
	private void setHasConfig(Boolean hasConfig) {
		this.hasConfig = hasConfig;
	}
	public File createConfig() throws IOException {
		if(this.hasConfig == false) {
			
			File dir = new File(this.configFolderDir);
			File config = new File(dir ,  File.separator+"config.properties");
			
			//Check if folder is created
			if(!dir.exists()) {
				
				//make new directory
				dir.mkdirs();
				
				try {
					setHasConfig(config.createNewFile());
					setConfig(config);
					
				} catch(IOException e) {
					e.printStackTrace();
				}
			} else if(!config.exists()) {
				try {
					setHasConfig(config.createNewFile());
					setConfig(config);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return this.config;
	}
	private void setConfig(File f) {
		this.config = f;
	}
	public boolean hasConfig(){
		return hasConfig;
	}
}
