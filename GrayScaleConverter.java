 
import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
	//I started with the image I wanted (inImage)
	public ImageResource makeGray(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			//compute inPixel's red + inPixel's blue + inPixel's green
			//divide that sum by 3 (call it average)
			int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
			//set pixel's red to average
			pixel.setRed(average);
			//set pixel's green to average
			pixel.setGreen(average);
			//set pixel's blue to average
			pixel.setBlue(average);
		}
		//outImage is your answer
		return outImage;
	}
	
	public void doSaveGray() {
		DirectoryResource dr = new DirectoryResource();//selecting multiple files
		for (File f : dr.selectedFiles()) {
			ImageResource image = new ImageResource(f);//taking image
			String fname = image.getFileName();//getting image's file name
			String newName = "copy-" + fname;//creating new file name
			ImageResource gray = makeGray(image);//creating gray image
			gray.setFileName(newName);//setting file name of gray image
			gray.draw();//just to see whether code work or not
			gray.save();//for saving images in the current folder
		}
	}
	
	public ImageResource makeNegative(ImageResource inImage)
	{
	   ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
	   for(Pixel pixel : outImage.pixels())
	   {
	       Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());//taking pixel
	       pixel.setRed(255-inPixel.getRed());//coverting red value to negative red
	       pixel.setGreen(255-inPixel.getGreen());//coverting green value to negative green
	       pixel.setBlue(255-inPixel.getBlue());//coverting blue value to negative blue
	   }
	   return outImage;//returning inverted image
	}
	
	public void doSaveNegative() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource image = new ImageResource(f);
			String fname = image.getFileName();
			String newName = "negative-" + fname;
			ImageResource gray = makeNegative(image);
			gray.setFileName(newName);
			gray.draw();
			gray.save();
		}
	}
}
