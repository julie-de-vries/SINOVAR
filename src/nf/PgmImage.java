/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Julie
 */
public class PgmImage{
    // image buffer for graphical display
	private BufferedImage img;
	// image buffer for plain gray-scale pixel values
	private int[][] pixels;
	
	// translating raw gray scale pixel values to buffered image for display
	private void pix2img(){
		int g;
		setImg(new BufferedImage( pixels[0].length, pixels.length, BufferedImage.TYPE_INT_ARGB ));
		// copy the pixels values
		for(int row=0; row<pixels.length; ++row)
			for(int col=0; col<pixels[row].length; ++col){
				g = pixels[row][col];
				getImg().setRGB(col, row, ((255<<24) | (g << 16) | (g <<8) | g));		
			}
	}
        
	// default constructor with a 3 by 4 image
	public PgmImage(){
		int[][] defaultPixels = {{0, 1, 2, 3}, {4, 5, 6, 7},{8, 9, 10, 11}};
		pixels = new int[defaultPixels.length][defaultPixels[0].length];
		for(int row=0; row < pixels.length; ++row)
			for(int col=0; col < pixels[0].length; ++col)
				pixels[row][col] = (int)(defaultPixels[row][col] * 255.0/12);
		pix2img();
	}
	
	// constructor that loads pgm image from a file
	public PgmImage(String filename) {
		pixels = null;
		readPGM(filename);
		if (pixels!=null)
			pix2img();
                else
                    System.out.println("image non lue");
	}

	// load gray scale pixel values from a PGM format image
	public void readPGM(String filename){
		try {                        		    
		    Scanner infile = new Scanner(new FileReader(filename));
		    // process the top 4 header lines
		    String filetype=infile.nextLine();
		    if (!filetype.equalsIgnoreCase("p2")) {
		    	System.out.println("[readPGM]Cannot load the image type of "+filetype);
		    	return;
		    }
	   	   	int cols = infile.nextInt();
	   	   	int rows = infile.nextInt();
	   	   	int maxValue = infile.nextInt();	        
	   	   	pixels = new int[rows][cols];	   	       
	   	   	System.out.println("Reading in image from " + filename + " of size " + rows + " by " + cols);
	   	   	// process the rest lines that hold the actual pixel values
	   	   	for (int r=0; r<rows; r++) 
	   	   		for (int c=0; c<cols; c++)
	   	   			pixels[r][c] = (int)(infile.nextInt()*255.0/maxValue);
	   	   	infile.close();
	    } catch(FileNotFoundException fe) {
	    	System.out.println("Had a problem opening a file.");
	    } catch (Exception e) {
	    	System.out.println(e.toString() + " caught in readPPM.");
	    	e.printStackTrace();
	    }
	}
    /**
     * @return the img
     */
    public BufferedImage getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(BufferedImage img) {
        this.img = img;
    }
	
}
    

