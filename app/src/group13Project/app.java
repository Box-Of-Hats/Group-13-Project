package group13Project;

import group13Project.GUI.*;
import group13Project.security.Cryptography;

import java.io.File;
import java.io.IOException;



public class app {
	public static void main(String[] args) throws Exception{
		
		GUIMainFrame frame = new GUIMainFrame(true);
		
		Internet internetConf = new Internet();
		frame.updateStatus("Checking Internet Connection");
		if(internetConf.hasValidInternetConnection()) {
			frame.updateStatus("Checking Configuration");
			Config conf = new Config();
			
			if(conf.hasConfig() == false) {
				
				/*
				 * 
				 *  A new User joins the network
				 *  
				 *  
				 */
				
				conf.createConfig();
				
				frame.newDeviceView(internetConf.getDeviceIPAddressToString());
				
				// Update config with new device settings
				conf.updateStatus(frame.getNewdeviceSettings());
				
				
			} else if(conf.checkStatus() == true) {
				
				/*
				 * 
				 *  An existing User uses the network
				 *  
				 *  
				 */
				
				
				
				//Where you setup the chord system.
			}
			
			
		
			
		} else {
			frame.updateStatus("No Internget connection available");
		}
	}
}
