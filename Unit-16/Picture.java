package classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)	
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue() {
	// TODO Auto-generated method stub
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] x : pixels) {
		  for(Pixel y : x) {
			  if(y.getGreen()!=0  || y.getRed()!=0) {
				  y.setGreen(0);
				  y.setRed(0);
			  }
		  }
	  }
	}
  
  public void keepOnlyRed() {
		// TODO Auto-generated method stub
		  Pixel[][] pixels = this.getPixels2D();
		  for(Pixel[] x : pixels) {
			  for(Pixel y : x) {
				  if(y.getGreen()!=0  || y.getBlue()!=0) {
					  y.setGreen(0);
					  y.setBlue(0);
				  }
			  }
		  }
		}
  
  public void keepOnlyGreen() {
		// TODO Auto-generated method stub
		  Pixel[][] pixels = this.getPixels2D();
		  for(Pixel[] x : pixels) {
			  for(Pixel y : x) {
				  if(y.getBlue()!=0  || y.getRed()!=0) {
					  y.setBlue(0);
					  y.setRed(0);
				  }
			  }
		  }
		}
  
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] x : pixels) {
		  for(Pixel y : x) {
			  y.setRed(255-y.getRed());
			  y.setGreen(255-y.getGreen());
			  y.setBlue(255-y.getBlue());
		  }
	  }
  }
  
  public void grayscale() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] x : pixels) {
		  for(Pixel y : x) {
			  int q = (y.getRed()+y.getGreen()+y.getBlue())/3;
			  y.setRed(q);
			  y.setGreen(q);
			  y.setBlue(q);
		  }
	  }
  }
  
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] x : pixels) {
		  for(Pixel y : x) {
			  if(y.getBlue()>160 && y.getGreen()<=170) {
				  y.setBlue(164);
				  y.setRed(255);
				  y.setGreen(60);
			  }
		  }
	  }
  }
  
  public void mirrorArms() {
	  int mirror = 205;
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
      Pixel rightPixel = null;
      for(int i=159; i<177; i++) {
    	  for(int j=105; j<mirror; j++) {
    		  leftPixel = pixels[i][j];
    		  rightPixel = pixels[i][2*mirror-j];
    		  rightPixel.setColor(leftPixel.getColor());
    	  }
      }
      for(int i=159; i<200; i++) {
    	  for(int j=mirror; j<300; j++) {
    		  rightPixel = pixels[i][j];
    		  leftPixel = pixels[i][2*mirror-j];
    		  leftPixel.setColor(rightPixel.getColor());
    	  }
      }
  }
  
  public void mirrorGull() {
	  int mirror = 344;
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
      Pixel rightPixel = null;
      for(int i=235; i<325; i++) {
    	  for(int j=235; j<mirror; j++) {
    		  leftPixel = pixels[i][j];
    		  rightPixel = pixels[i][2*mirror-j];
    		  rightPixel.setColor(leftPixel.getColor());
    	  }
      }
  }

  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
      Pixel rightPixel = null;
      for(int i=116;i<pixels.length-1;i++) {
    	  for(int j=0;j<i;j++) {
    		  leftPixel = pixels[i][j];
    		  rightPixel = pixels[j][i];
    		  rightPixel.setColor(leftPixel.getColor());	
    	  }
      }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  for(int r=0; r<pixels.length/2; r++) {
		  for(int c=0; c<pixels[0].length; c++) {
			  topPixel = pixels[r][c];
			  botPixel = pixels[pixels.length-1-r][c];
			  botPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy2(Picture fromPic, int startRow, int startCol, int endRow, int endCol) 
  {
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
	for (int fromRow = startRow, toRow = endRow; 
	     fromRow < fromPixels.length &&
	     toRow < toPixels.length; 
	     fromRow++, toRow++)
	{
	  for (int fromCol = startCol, toCol = endCol; 
	       fromCol < fromPixels[0].length &&
	       toCol < toPixels[0].length;  
	       fromCol++, toCol++)
	  {
	    fromPixel = fromPixels[fromRow][fromCol];
	    toPixel = toPixels[toRow][toCol];
	    toPixel.setColor(fromPixel.getColor());
	  }
	}  
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("src/images/flower1.jpg");
    Picture flower2 = new Picture("src/images/flower2.jpg");
    Picture snow = new Picture("src/images/snowman.jpg");
    this.copy(flower1,0,57);
    this.copy(flower2,251,296);
    this.copy(snow, 200, 123);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,323,12);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("src/images/collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
              col < pixels[0].length-1; col++)
         {
           leftPixel = pixels[row][col];
           rightPixel = pixels[row][col+1];
           rightColor = rightPixel.getColor();
           if (leftPixel.colorDistance(rightColor) > 
               edgeDist)
             leftPixel.setColor(Color.BLACK);
           else
             leftPixel.setColor(Color.WHITE);
         }
    }
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
              col < pixels[0].length-1; col++)
         {
    	  topPixel = pixels[row][col];
    	  botPixel = pixels[row+1][col];
           rightColor = botPixel.getColor();
           if (topPixel.colorDistance(rightColor) > 
               edgeDist)
        	   topPixel.setColor(Color.BLACK);
           else
        	   topPixel.setColor(Color.WHITE);
         }
    }
  }
  
  public void edgeDetection3(int edgeDist) {
	  Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    Color rightColor = null;
	    for (int row = 1; row < pixels.length-1; row++)
	    {
	      for (int col = 0; 
	           col < pixels[0].length-1; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][col+1];
	        topPixel = pixels[row-1][col];
	        botPixel = pixels[row+1][col];
	        Color botColor = botPixel.getColor();
	        rightColor = rightPixel.getColor();
	        if (leftPixel.colorDistance(rightColor) > 
	            edgeDist && topPixel.colorDistance(botColor) > edgeDist)
	          leftPixel.setColor(Color.BLACK);
	        else
	          leftPixel.setColor(Color.WHITE);
	      }
	    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("src/images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  
} // this } is the end of class Picture, put all new methods before this
