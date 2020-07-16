package org.maven.helper;

public class FileReaderManager {

	private FileReaderManager() {
		
	}
	
	public static FileReaderManager fm = new FileReaderManager();
	public ConfigReader cr = null;
	
	public static FileReaderManager getInstance() {
		return fm;
	}
	
	public ConfigReader getConfigReader() throws Throwable {
		if(cr == null) {
			cr = new ConfigReader();
		}
		return cr;
	}
}
