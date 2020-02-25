/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author Julie
 */
public class ImageProcessing {
    private BufferedImage imgInit;
    private BufferedImage img;
    
    
    public ImageProcessing(String imageFileName){
        if(imageFileName.endsWith("pgm")){
            PgmImage pgm = new PgmImage(imageFileName);
            img=pgm.getImg();
            imgInit=img;
        }
        else{
            try {
                img = ImageIO.read(new File(imageFileName));
                imgInit=img;
            } catch (IOException ex) {
                Logger.getLogger(ImageProcessing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ImageProcessing(BufferedImage bi){
        
                img = bi;
                imgInit = img;
            
        
    }
    /*l'image est tournée de 90° vers la droite*/
    public void rotateToRight(){
        int         height  = img.getWidth();
        int         width = img.getHeight();
        BufferedImage   newImage = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );

        for( int i=0 ; i < width ; i++ )
            for( int j=0 ; j < height ; j++ )
                newImage.setRGB( width-1-i, j, img.getRGB(j,i) );

        img=newImage;
    }
    /*l'image est tournée de 90° vers la gauche*/
    public void rotateToLeft(){
        int         height  = img.getWidth();
        int         width = img.getHeight();
        BufferedImage   newImage = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );

        for( int i=0 ; i < width ; i++ )
            for( int j=0 ; j < height ; j++ )
                newImage.setRGB( i, height-1-j, img.getRGB(j,i) );

        img=newImage;
    }
    /*l'image est retournée verticalement*/
    public void flipVertically(){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        BufferedImage   newImage = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );

        for( int i=0 ; i < width ; i++ )
            for( int j=0 ; j < height ; j++ )
                newImage.setRGB( width-1-i,j,  img.getRGB(i,j) );

        img=newImage;
    }
    /*l'image est retournée horizontalement*/
    public void flipHorizontally(){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        BufferedImage   newImage = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
        for( int i=0 ; i < width ; i++ )
            for( int j=0 ; j < height ; j++ )
                newImage.setRGB(  i,height-1-j, img.getRGB(i,j) );

        img=newImage;
    }
    /*éclaircissement de l'image d'un facteur f*/
    public void brighten(float f){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        BufferedImage   newImage = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
        for( int i=0 ; i < height ; i++ ){
            for( int j=0 ; j < width ; j++ ){
                Color c=new Color(imgInit.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                float[] h=new float[3];
                Color.RGBtoHSB(r, g, b, h);
                if(h[2]*(1+f/100)>1)
                    h[2]=1;
                else{
                    h[2]=h[2]*(1+(f/100));
                }
                newImage.setRGB(i, j,Color.HSBtoRGB(h[0],h[1],h[2]));
            }
        }
        img=newImage;
    }
    /*inversement des niveaux de gris*/
    public void greyLevels(){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        
        for( int i=0 ; i < height ; i++ ){
            for( int j=0 ; j < width ; j++ ){
                Color c1=new Color(img.getRGB(i, j));
                int r = 255-c1.getRed();
                int g = 255-c1.getGreen();
                int b = 255-c1.getBlue();
                Color c= new Color(r,g,b);
                img.setRGB(i,j,c.getRGB());
            }
        }
    }
    /*ajouter des anotations*/
    public void addNotes(String notes, float cursorX, float cursorY){
        img.createGraphics().drawString(notes, cursorX, cursorY);
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
