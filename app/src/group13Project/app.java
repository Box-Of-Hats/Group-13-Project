package group13Project;

import java.io.File;
import java.io.IOException;

public class app {
	public static void main(String[] args) throws IOException{
		double timeS = System.nanoTime();
		Config conf = new Config();
		System.out.println(conf.hasConfig());
		if(conf.hasConfig() == false) {
			
			File config = conf.createConfig();
			if(config != null) {
				
				//set up new node
				Node node = new Node(config);
				
				
			}
		} else {
			
		}
		
	}
}
