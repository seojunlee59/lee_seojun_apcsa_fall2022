package classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class FinalU16Ext extends SimplePicture{
  public FinalU16Ext ()
  {
    super();  
  }

  public FinalU16Ext(String fileName)
  {
    super(fileName);
  }

  public FinalU16Ext(int height, int width)
  {
    super(width,height);
  }

  public FinalU16Ext(Picture copyPicture)
  {
    super(copyPicture);
  }

  public FinalU16Ext(BufferedImage image)
  {
    super(image);
  }
  
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
  }
  
  //-------------------------------------
//  1 2 3 4 5 6 7 8 9 10 11
  public void encode(Picture message) {
	  Pixel[][] msg = message.getPixels2D();
	  Pixel[][] main = this.getPixels2D();
	  Pixel mainPx = null;
	  Pixel msgPx = null;
	  int rotOne = main[0][0].getRed();//first pixel
	  int rotTwo = main[0][main[0].length-1].getRed();//top right pixel
	  int rotThe = main[main.length-1][main[0].length-1].getRed();//last pixel
	  int rot1 = rotOne%11;
	  int rot2 = rotTwo%11;
	  int rot3 = rotThe%11;
	  boolean flag = true;
	  //instantiate rotor positions
	  int[] rot = {rot1, rot2, rot3};
	  Map<Integer, Integer> reflector = new HashMap<Integer, Integer>();
	  //make reflector
	  for(int i=1; i<=11; i++) {
		  reflector.put(i, 12-i);
	  }
	  for(int r=0; r<msg.length; r++) {
		  for(int c=1; c<msg[0].length; c++) {
			  msgPx = msg[r][c];  
			  if(msgPx.colorDistance(Color.black)<70 && c%2==1) {
				  int colorValInitial = 0;
				  int colorVal = 0;
				  int colorValChange = 0;
				  while(flag) {
				  mainPx = main[r][c];
				  main[r][c-1].setRed(main[r][c].getRed());
				  main[r][c-1].setGreen(main[r][c].getGreen());
				  main[r][c-1].setBlue(main[r][c].getBlue());
				  colorValInitial = mainPx.getRed();//get the green value from main Pixel
				  colorVal = colorValInitial%11;
				  colorValChange = colorVal;//instantiate color values to colorValInit
					  for(int i=0; i<2; i++) {//run two times for the rotor positions
						  for(int j=0; j<rot.length; j++) {//rotor positions
							  if(colorValChange+rot[j]>11) {
								  colorValChange = (colorValChange+rot[j])-11;
							  }
							  else {
								  colorValChange+=rot[j];
							  }
							  if(rot[j]+1==11) {
								  rot[j] = 0;
							  }
							  else {
								  rot[j]+=1;
							  }
						  }
						  if(i==0)
						  colorValChange = reflector.get(colorValChange);//reflector
						  //flip the rotors for the reverse incrementation
						  int temp = rot[0];
						  rot[0] = rot[rot.length-1];
						  rot[rot.length-1] = temp;
					  
					  }
					  if(colorValChange-colorVal!=0) {
						  flag = false;
						  break;
					  }
					  else {
						  mainPx.setColor(new Color((mainPx.getRed()+1)%256, (mainPx.getGreen()+1)%256, (mainPx.getBlue()+1)%256));
					  }
				  }
				  mainPx.setRed(colorValInitial+colorValChange-colorVal);
				  mainPx.setGreen(mainPx.getGreen()+colorValChange-colorVal);
				  mainPx.setBlue(mainPx.getBlue()+colorValChange-colorVal);
				  rotOne = main[0][0].getRed();//first pixel
				  rotTwo = main[0][main[0].length-1].getRed();//top right pixel
				  rotThe = main[main.length-1][main[0].length-1].getRed();//last pixel
				  rot1 = rotOne%11;
				  rot2 = rotTwo%11;
				  rot3 = rotThe%11;
				  //instantiate rotor positions
				  rot = new int[]{rot1, rot2, rot3};
				  flag = true;
			  }
			  else if(!(msgPx.colorDistance(Color.black)<70)){
				  mainPx = main[r][c];
				  mainPx.setRed(mainPx.getRed()-(mainPx.getRed()%10)); 
				  mainPx.setGreen(mainPx.getGreen()-(mainPx.getGreen()%10));
				  mainPx.setBlue(mainPx.getBlue()-(mainPx.getBlue()%10));
			  }
		  }
	  }	  
	  //instead of updating the value after the enigma cipher, 
	  //keep the original values and use the left pixel to the changed pixel to compare and decode
  }
  public void decode() {
	  Pixel[][] main = this.getPixels2D();
	  Pixel keyPx = null;
	  //-----------Main Picture Decode
	  //get rotor positions
	  int[] rotPos = new int[3];
	  rotPos[0] = (main[0][0].getRed())%11;//first pixel
	  rotPos[1] = (main[0][main[0].length-1].getRed())%11;//top right pixel
	  rotPos[2] = (main[main.length-1][main[0].length-1].getRed())%11;//last pixel
	  boolean flag = true;
	  Map<Integer, Integer> reflector = new HashMap<Integer, Integer>();
	  //make reflector
	  for(int i=1; i<=11; i++) {
		  reflector.put(i, 12-i);
	  }
	  //loop through every pixel
	  for(int r=0; r<main.length; r++) {
		  for(int c=0; c<main[0].length-1; c++) {
			  keyPx = main[r][c];  
//			  if(!(keyPx.getRed()-main[r][c+1].getRed()==-1 && keyPx.getGreen()-main[r][c+1].getGreen()==-1 && keyPx.getBlue()-main[r][c+1].getBlue()==-1)) {
			  if(keyPx.getRed()-main[r][c+1].getRed()!=0 && keyPx.getGreen()-main[r][c+1].getGreen()!=0 && keyPx.getBlue()-main[r][c+1].getBlue()!=0) {
				  int colorValInitial = 0;
				  int colorVal = 0;
				  int colorValChange = 0;
				  while(flag) {
					  colorValInitial = keyPx.getRed();//get the green value from main Pixel
					  colorVal = colorValInitial%11;
					  colorValChange = colorVal;//instantiate color values to colorValInit
					  for(int i=0; i<2; i++) {//run two times for the rotor positions
						  for(int j=0; j<rotPos.length; j++) {//rotor positions
							  if(colorValChange+rotPos[j]>11) {
								  colorValChange = (colorValChange+rotPos[j])-11;
							  }
							  else {
								  colorValChange+=rotPos[j];
							  }
							  if(rotPos[j]+1==11) {
								  rotPos[j] = 0;
							  }
							  else {
								  rotPos[j]+=1;
							  }
						  }
						  if(i==0)
						  colorValChange = reflector.get(colorValChange);//reflector
						  //flip the rotors for the reverse incrementation
						  int temp = rotPos[0];
						  rotPos[0] = rotPos[rotPos.length-1];
						  rotPos[rotPos.length-1] = temp;
					  
					  }
					  if(colorValChange-colorVal!=0) {
						  flag = false;
						  break;
					  }
					  else {
						  keyPx.setColor(new Color((keyPx.getRed()+1)%256, (keyPx.getGreen()+1)%256, (keyPx.getBlue()+1)%256));
					  }
				  }
				  flag = true;
				  //colorValChange is made, ready to compare to the encode() value
				  if(keyPx.getRed()+colorValChange-colorVal==main[r][c+1].getRed() && keyPx.getGreen()+colorValChange-colorVal==main[r][c+1].getGreen() && keyPx.getBlue()+colorValChange-colorVal==main[r][c+1].getBlue()) {
					  keyPx.setColor(Color.black);
					  main[r][c+1].setColor(Color.black);
					  c++;
				  }
				  else {
					  keyPx.setColor(Color.white);
					  main[r][c+1].setColor(Color.white);	 	
					  c++;
				  }
				  rotPos = new int[] {(main[0][0].getRed())%11, (main[0][main[0].length-1].getRed())%11, (main[main.length-1][main[0].length-1].getRed())%11};
			  }
			  else {
				  keyPx.setColor(Color.white);
				  main[r][c+1].setColor(Color.white);
				  c++;
			  }
		  }
	  }

  }
  

  
  //-------------------------------------
  
  public static void main(String[] args) {
	  U16Ext3_2_Main2_1 red = new U16Ext3_2_Main2_1("src/images/beach.jpg");	
	  red.explore();
	  Picture test1 = new Picture("src/images/msg.jpg");
	  test1.grayscale();
	  red.encode(test1); 
	  red.explore();
	  U16Ext3_2_Main2_1 blue = new U16Ext3_2_Main2_1(test1);	
	  blue.explore();
//	  uncomment when done with decode---------------
	  red.decode();
	  red.explore();
  }
}