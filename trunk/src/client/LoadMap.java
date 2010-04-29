package client;

//import java.awt.Image;
import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LoadMap {

	private static BufferedReader bf;
	private static String path;
	//private static final String sgmnt1 = "1-1.dat";
	private static ArrayList<String> tiles = new ArrayList<String>();
	
	public LoadMap() {
		loadMap();
	}
	
	private static int loadMap(/*String segment*/) {
		String currentLine;
		
		//Load Map-file  
		try {
			URL url = new URL("http://utterfanskap.se/zincgull/includes/maps/1-1.dat");
			
			bf = new BufferedReader(
				new InputStreamReader(
				url.openStream()));
			
		} catch (FileNotFoundException e1) {
			System.out.println("Unable to Load: "+path);
			e1.printStackTrace();
			return -1;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {			
			while(bf.ready()) {
				//Read Line
				currentLine = bf.readLine();
				
				//If != comment
				if(!currentLine.startsWith("//")) tiles.add(currentLine);			
			}
			
			bf.close();
			
		} catch (IOException e) {
			System.out.println("Failed to Read map");
			e.printStackTrace();
			return -1;
		}	
		return 0;
	}
	
	public static ArrayList<String> getMapSegment() {
		return tiles;
	}
	
	public static void main(String[] args) {
		new LoadMap();
	}
	
	public static char getTile(int x, int y) {
		return (tiles.get(y).charAt(x));
	}
	
}
