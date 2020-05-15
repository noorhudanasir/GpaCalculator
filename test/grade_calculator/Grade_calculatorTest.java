/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_calculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Assert;
import jxl.read.biff.BiffException;

/**
 *
 * @author Noor Huda
 */
@RunWith(Parameterized.class)
public class Grade_calculatorTest {
   private final int ass;
	private int mid ;
	private int finals;
	private String ExpResult;
      
                
        Grade_calculator object;
	
	public Grade_calculatorTest(String b,int a,int m,int f)
	{
		
		ExpResult=b;
                this.mid=m;
		this.ass=a;
		
		this.finals=f;
                
                
                
                
	}
	@Before
    public void setup()
    {
        object=new Grade_calculator();
       
    }
	
	@Parameterized.Parameters
	public static Collection<Object[]> Testdata() throws BiffException, IOException, IllegalArgumentException
	{ 
		
			FileInputStream file;
			int j=0;
				file = new FileInputStream("test.xls");
				Workbook wbk = Workbook.getWorkbook(file);
				  Sheet sheet = wbk.getSheet(0);
				  Object Data[][] = new Object[sheet.getRows()][sheet.getColumns()];
				  for(int i=0;i<(sheet.getRows());i++)
				  {
				   String r=sheet.getCell(0,i).getContents();
				   int l=Integer.parseInt(sheet.getCell(1,i).getContents());
				   int ll=Integer.parseInt(sheet.getCell(2,i).getContents());
				   int lll=Integer.parseInt(sheet.getCell(3,i).getContents());
				    Data[i][0] = r;
				    Data[i][1] = l;
				   Data[i][2] = ll;
				  Data[i][3] = lll;
				    
				    
				  }
				    
			
			 return Arrays.asList(Data);
	    
	}
	
	@Test
	public void testgrades() {
      Assert.assertEquals(ExpResult,object.marks(ass,mid,finals));
      
	}
    
}
