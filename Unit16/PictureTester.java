package classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("src/images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("src/images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("src/images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("src/images/640x480.jpg");
    canvas.explore();
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("src/images/swan.jpg");
    swan.explore();
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("src/images/swan.jpg");
    swan.explore();
    swan.edgeDetection2(20);
    swan.explore();
  }
  
  public static void testEdgeDetection3()
  {
    Picture swan = new Picture("src/images/swan.jpg");
    swan.explore();
    swan.edgeDetection3(10);
    swan.explore();
  }
  
  private static void testKeepOnlyBlue() {
		// TODO Auto-generated method stub
	  Picture blue = new Picture("src/images/karl.jpg");
	  blue.keepOnlyBlue();
	  blue.explore();
	}
  
  private static void testKeepOnlyRed() {
		// TODO Auto-generated method stub
	  Picture red = new Picture("src/images/karl.jpg");
	  red.keepOnlyRed();
	  red.explore();
	}
  
  private static void testKeepOnlyGreen() {
		// TODO Auto-generated method stub
	  Picture green = new Picture("src/images/karl.jpg");
	  green.keepOnlyGreen();
	  green.explore();
	}
  
  private static void testNegate() {
	  Picture ngt = new Picture("src/images/karl.jpg");
	  ngt.negate();
	  ngt.explore();
  }
  
  private static void testGrayscale() {
	  Picture gryscl = new Picture("src/images/karl.jpg");
	  gryscl.grayscale();
	  gryscl.explore();
  }
  
  private static void testMirrorArms() {
	  Picture undH2O = new Picture("src/images/snowman.jpg");
	  undH2O.mirrorArms();
	  undH2O.explore();	
  }
  
  private static void testMirrorGull() {
	  Picture undH2O = new Picture("src/images/seagull.jpg");
	  undH2O.mirrorGull();
	  undH2O.explore();	
  }
  
  private static void testMirrorDiagonal() {
	  Picture undH2O = new Picture("src/images/beach.jpg");
	  undH2O.mirrorDiagonal();
	  undH2O.explore();	
  }
  
  private static void testMirrorHorizontal() {
	  Picture re = new Picture("src/images/redMotorcycle.jpg");re.mirrorHorizontal();re.explore();
  }
  
  private static void testCopy2() {
	  Picture re = new Picture("src/images/collage.jpg");re.copy2(new Picture("src/images/flower1.jpg"), 3, 7, 5, 100);re.explore();
	}
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
//    testKeepOnlyBlue();
//    testKeepOnlyRed();
//    testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testFixUnderwater();
//    testMirrorVertical();
//    testMirrorHorizontal();
//    testMirrorTemple();
//    testMirrorArms();
//    testMirrorGull();
//    testMirrorDiagonal();
//    testCollage();
//    testCopy();
//    testCopy2();
//    testEdgeDetection();
    testEdgeDetection3();
//    testChromakey();
//    testEncodeAndDecode();
//    testGetCountRedOverValue(250);
//    testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
//    testGetAverageForColumn(0);
  }



}