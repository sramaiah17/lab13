package lab13;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class lab13Test
{
	lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";

	@BeforeEach
	public void setUp() throws Exception 
	{
		lab = new lab13();
		lab.readData(inputFilename);
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
			
			// put code here to populate expectedResult1 with the values in testData.get(0)
			// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
			expectedResult1 = new Integer[testData.get(0).size()];
			for(int i=0;i<testData.get(0).size();i++)
			{
				expectedResult1[i]=testData.get(0).get(i);
			}
			
			// put code here to populate expectedResult2 with the values in testData.get(1)
			// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
			expectedResult2 = new Integer[testData.get(1).size()];
			for(int i=0;i<testData.get(1).size();i++)
			{
				expectedResult2[i]=testData.get(1).get(i);
			}
			
			// put code here to populate expectedResult3 with the values in testData.get(2)
			// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
			expectedResult3 = new Integer[testData.get(2).size()];
			for(int i=0;i<testData.get(2).size();i++)
			{
				expectedResult3[i]=testData.get(2).get(i);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}		
	}

	@Test 
	public void testTotalCount()
	{
	
		assertEquals(lab.getTotalCount(),1000);
	}
	
	@Test 
	public void testOddCount()
	{
		assertEquals(lab.getOddCount(),507);
	}
	
	@Test 
	public void testEvenCount()
	{
	
		assertEquals(lab.getEvenCount(),493);
	}
	
	@Test 
	public void testDistinct()
	{
	
		assertEquals(lab.getDistinctGreaterThanFiveCount(),94);
	}
	
	@Test 
	public void testResult1()
	{
	
		assertArrayEquals(expectedResult1,lab.getResult1());
	}
	
	@Test 
	public void testResult2()
	{
	
		assertArrayEquals(expectedResult2,lab.getResult2());
	}
	
	@Test 
	public void testResult3()
	{
		assertArrayEquals(expectedResult3,lab.getResult3());
	}

	
}