package com.pg.ws.service.mtom.hellomtom;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

/*
 * wsgen -cp . com.pg.ws.service.mtom.hellomtom.HelloMTOMServiceImpl -wsdl -r ../../src/main/resources/wsdl/HelloMTOM -keep -s ../../src/main/java -Xnocompile -verbose
 * 
 */


@MTOM
@WebService(endpointInterface = "com.pg.ws.service.mtom.hellomtom.HelloMTOMService")
public class HelloMTOMServiceImpl {

	public boolean uploadImg(Image imgSrc) {
		if (null == imgSrc) {
			return false;
		}

		Integer randNum = new Random().nextInt(1000);
		String imgFilePath = "A:\\projects\\pgworkspacejee\\WS_SOAP_Service\\src\\main\\resources\\mtom\\upload\\";
		File imgFile = new File(imgFilePath + randNum);
		while (!imgFile.exists()) {
			randNum = new Random().nextInt(1000);
			imgFile = new File(imgFilePath + randNum);
		}
System.out.println("file going to be uploaded to "+imgFilePath);
		try {
			ImageIO.write(toBufferedImage(imgSrc), "jpg", imgFile);
			System.out.println("Successfully uploaded");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/** 
	 *  Utility to convert Image to BufferedImage in order to save it to a file
	 *  From : https://code.google.com/p/game-engine-for-java/source/browse/src/com/gej/util/ImageTool.java#31
	 */
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
}
