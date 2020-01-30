/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.awt.image.BufferedImage;

/**
 *
 * @author Julie
 */
public class ImageProcessing {
    private BufferedImage img;
    
    public ImageProcessing(String imageFileName){
        PgmImage pgm = new PgmImage(imageFileName);
        img=pgm.getImg();
    }
    /*l'image est tournée de 90° vers la gauche*/
    public void rotate(){
        int         height  = img.getWidth();
        int         width = img.getHeight();
        BufferedImage   newImage = new BufferedImage( height, width, img.getType() );

        for( int i=0 ; i < width ; i++ )
            for( int j=0 ; j < height ; j++ )
                newImage.setRGB( j, i, img.getRGB(i,j) );

        img=newImage;
    }
    /*l'image est retournée verticalement*/
    public void flipVertically(){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        BufferedImage   newImage = new BufferedImage( height, width, img.getType() );

        for( int i=0 ; i < width ; i++ )
            for( int j=0 ; j < height ; j++ )
                newImage.setRGB( height-1-j, i, img.getRGB(j,i) );

        img=newImage;
    }
    
    public void flipHorizontally(){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        BufferedImage   newImage = new BufferedImage( height, width, img.getType() );

        for( int i=0 ; i < width ; i++ )
            for( int j=0 ; j < height ; j++ )
                newImage.setRGB( j, width-1-i, img.getRGB(j,i) );

        img=newImage;
    }
    /*éclaircissement de l'image au pourcentage p*/
    public void brighten(double p){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        
        for( int i=0 ; i < height ; i++ ){
            for( int j=0 ; j < width ; j++ ){
                String R=String.valueOf((int)(Integer.parseInt(String.valueOf(img.getRGB(i,j)).subSequence(0,3).toString())*(1+p/100)));
                String G=String.valueOf((int)(Integer.parseInt(String.valueOf(img.getRGB(i,j)).subSequence(3,6).toString())*(1+p/100)));
                String B=String.valueOf((int)(Integer.parseInt(String.valueOf(img.getRGB(i,j)).subSequence(6,7).toString())*(1+p/100)));
                int RGB=Integer.parseInt(R+G+B);
                img.setRGB(i, j,RGB);
            }
        }
    }
    /*inversement des niveaux de gris*/
    public void greyLevels(){
        int         width  = img.getWidth();
        int         height = img.getHeight();
        
        for( int i=0 ; i < height ; i++ ){
            for( int j=0 ; j < width ; j++ ){
                img.setRGB(i, j,255255255-img.getRGB(i, j));
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
