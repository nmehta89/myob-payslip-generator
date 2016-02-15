package test.junit;

import org.junit.Test;
import com.company.myob.*;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestJunit {
	
   String message = "David Rudd,01 March - 31 March,5004.0, 922.0, 4082.0, 450.0";	
   
   public String testEval() {
		File f = new File("");
		String parentLoc = f.getAbsoluteFile().getParent();
	    String testIinput = parentLoc+"//input//testinput.csv";
		String testOutput = "";
		
		List<Employee> list = new ArrayList<Employee>();
		list=StandardIO.evalPayslip(testIinput);
		
		for (int i = 0; i < list.size(); i++) {
			testOutput=testOutput + (list.get(i).toString());
			if (i != list.size()-1)
				testOutput=testOutput+",";
		}
		System.out.println("Out = "+testOutput+"\n");
		return testOutput;
	   }
	
   @Test
   public void testPrintMessage() {	  
      assertEquals(message,testEval());
   }
   
}
