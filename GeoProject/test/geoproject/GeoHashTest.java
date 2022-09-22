/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoproject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author KGJQ6312
 */
public class GeoHashTest {

	public GeoHashTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// Adjacent hash 2 parameters base case (no null values)
	@Test
	public void adjecentHashTestBase() {
		String hash = "wx";
		Direction direction = Direction.RIGHT;
		String expResult = "wz";
		String result = GeoHash.adjacentHash(hash, direction);
		assertEquals(expResult, result);
	}

	// Adjacent hash 2 parameters with null hash
	@Test(expected = IllegalArgumentException.class)
	public void adjecentHashTestNullHash() {
		String hash = "";
		Direction direction = Direction.RIGHT;
		String expResult = "wz";
		String result = GeoHash.adjacentHash(hash, direction);
		assertEquals(expResult, result);
	}

	
	// Adjacent hash 2 parameter with null direction
	@Test(expected = NullPointerException.class)
	public void adjecentHashTestNullDirection() {
		String hash = "wx";
		Direction direction = null;
		String expResult = "wz";
		String result = GeoHash.adjacentHash(hash, direction);
		assertEquals(expResult, result);
	}

	// Adjacent hash 3 parameter base case (no null values)
	@Test
	public void adjecentHashStepsTestBaseCase() {
		String hash = "wx";
		Direction direction = Direction.RIGHT;
		int steps = 10;
		String expResult = "9p";
		String result = GeoHash.adjacentHash(hash, direction, steps);
		assertEquals(expResult, result);
	}

	// Adjacent hash 3 parameter with null hash
	@Test(expected = IllegalArgumentException.class)
	public void adjecentHashStepsTestNullHash() {
		String hash = "";
		Direction direction = Direction.RIGHT;
		int steps = 10;
		String expResult = "9p";
		String result = GeoHash.adjacentHash(hash, direction, steps);
		assertEquals(expResult, result);
	}

	// Adjacent hash 3 parameter with null direction
	@Test(expected = NullPointerException.class)
	public void adjecentHashStepsTestNullDirection() {
		String hash = "wx";
		Direction direction = null;
		int steps = 10;
		String expResult = "9p";
		String result = GeoHash.adjacentHash(hash, direction, steps);
		assertEquals(expResult, result);
	}

	// Adjacent hash 3 parameter with negative steps(moves opposite direction from hash)
	@Test
	public void adjecentHashStepsTestSteps() {
		String hash = "wx";
		Direction direction = Direction.RIGHT;
		int steps = -10;
		String expResult = "sp";
		String result = GeoHash.adjacentHash(hash, direction, steps);
		assertEquals(expResult, result);
	}

	// Right base case (no null values)
	@Test
	public void rightTestBaseCase() {
		String hash = "wx";
		String expResult = "wz";
		String result = GeoHash.right(hash);
		assertEquals(expResult, result);
	}

	// Right with null hash
	@Test(expected = IllegalArgumentException.class)
	public void rightTestNullHash() {
		String hash = "";
		String expResult = "wz";
		String result = GeoHash.right(hash);
		assertEquals(expResult, result);
	}

	// Left base case (no null values)
	@Test
	public void leftTestBaseCase() {
		String hash = "wx";
		String expResult = "wr";
		String result = GeoHash.left(hash);
		assertEquals(expResult, result);
	}

	// Left with null hash
	@Test(expected = IllegalArgumentException.class)
	public void leftTestNullHash() {
		String hash = "";
		String expResult = "wr";
		String result = GeoHash.left(hash);
		assertEquals(expResult, result);
	}

	// Bottom base case (no null values)
	@Test
	public void bottomTestBaseCase() {
		String hash = "wx";
		String expResult = "ww";
		String result = GeoHash.bottom(hash);
		assertEquals(expResult, result);
	}

	// Bottom with null hash
	@Test(expected = IllegalArgumentException.class)
	public void bottomTestNullHash() {
		String hash = "";
		String expResult = "ww";
		String result = GeoHash.bottom(hash);
		assertEquals(expResult, result);
	}

	// Top base case (no null values)
	@Test
	public void topTestBaseCase() {
		String hash = "wx";
		String expResult = "y8";
		String result = GeoHash.top(hash);
		assertEquals(expResult, result);
	}

	// Top with null hash
	@Test(expected = IllegalArgumentException.class)
	public void topTestNullHash() {
		String hash = "";
		String expResult = "y8";
		String result = GeoHash.top(hash);
		assertEquals(expResult, result);
	}

	// Neighbors base case (no null values)
	@Test
	public void neigboursTestBaseCase() {
		String hash = "wx";
		ArrayList<String> expResult = new ArrayList<String>();
		expResult.add("wr");
		expResult.add("wz");
		expResult.add("y8");
		expResult.add("ww");
		expResult.add("y2");
		expResult.add("wq");
		expResult.add("yb");
		expResult.add("wy");

		List<String> result = GeoHash.neighbours(hash);
		assertEquals(expResult, result);
	}

	// Neighbors with null hash
	@Test(expected = IllegalArgumentException.class)
	public void neigboursTestNullHash() {
		String hash = "";
		ArrayList<String> expResult = new ArrayList<String>();
		expResult.add("wr");
		expResult.add("wz");
		expResult.add("y8");
		expResult.add("ww");
		expResult.add("y2");
		expResult.add("wq");
		expResult.add("yb");
		expResult.add("wy");

		List<String> result = GeoHash.neighbours(hash);
		assertEquals(expResult, result);
	}

	// DecodeHash base case (no null values)
	@Test
	public void decoderHashTestBaseCase() {
		String geohash = "wx";
		LatLong expResult = new LatLong(42.1875, 118.125);
		LatLong result = GeoHash.decodeHash(geohash);
		assertEquals(expResult, result);
	}

	// decodeHash with null hash
	@Test(expected = NullPointerException.class)
	public void decoderHashTestNullHash() {
		String geohash = "";
		LatLong expResult = new LatLong(42.1875, 118.125);
		LatLong result = GeoHash.decodeHash(geohash);
		assertEquals(expResult, result);
	}

	// HeightDegree base case (no negative values) 
	@Test
	public void heightDegreeTestCBaseCase() {
        int n = 0;
        double expResult = 180.0;
        double result = GeoHash.heightDegrees(n);
        assertEquals(expResult, result, 0.0);
	}

	// HeightDegree with negative n
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void heightDegreeTestNegativeN() {
        int n = -10;
        double expResult = 180.0;
        double result = GeoHash.heightDegrees(n);
        assertEquals(expResult, result, 0.0);
	}

	// WidthDegree base case (no negative values)
	@Test
	public void WidthDegreeTestCBaseCase() {
        int n = 0;
        double expResult = 360.0;
        double result = GeoHash.widthDegrees(n);
        assertEquals(expResult, result, 0.0);
	}

	// WidthDegree with negative n
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void WidthDegreeTestNegativeN() {
        int n = -10;
        double expResult = 360.0;
        double result = GeoHash.widthDegrees(n);
        assertEquals(expResult, result, 0.0);
	}

}
