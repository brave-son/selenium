package selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Snippet {
	public void downloadImage(String address) {
	  try {
	    URL imageURL = new URL(address);
	    BufferedImage saveImage = ImageIO.read(imageURL);
	
	    ImageIO.write(saveImage, "jpg", new File("저장경로"));
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	}
}

