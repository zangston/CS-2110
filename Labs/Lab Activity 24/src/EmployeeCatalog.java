import java.util.*;

public class EmployeeCatalog {

	public LinkedList<Employee> developers;
	
	public EmployeeCatalog (int catalogSize) {
		// initialize a linked list to store employee records
		developers = new LinkedList<Employee>();
		// generate random employee data
		for ( int i = 0; i < catalogSize; i++) {
			// create 1000 random employees
			Employee x = new Employee(i,true);
			developers.add(x);
		}
	}
	
	public static void main(String[] args) {
		
		// create a catalog with n employees and run some timed tests
		// note - the first run is a throw-away run - the JVM will optimize execution
		// behind the scenes for subsequent runs
		int[] testPattern = { 1, 50, 100, 10000, 500000 };
		
		for (int p =0; p< testPattern.length; p++ ) {
			// capture the start time
			long startTime = System.nanoTime();
			// create a catalog
			EmployeeCatalog ec = new EmployeeCatalog(testPattern[p]);
			// record the time after creating the catalog
			long step1Time = System.nanoTime();
			
			System.out.println( "Developer catalog with "+testPattern[p]+" employees created in "+ (step1Time-startTime) );
			System.out.println("Average lines of code per developer is " + ec.averageLinesOfCode() );
			
			long step2Time = System.nanoTime();
			
			System.out.println("LOC averaged in "+(step2Time - step1Time));
			
			// set Quantity rank 
			ec.setQuantityRankings();
			long step3Time = System.nanoTime();
			
			System.out.println("quantity rankings set in "+ (step3Time-step2Time));
			
			// set quality rank
			ec.setQualityGrade();
			long step4Time = System.nanoTime();
			System.out.println("quality grade set in "+ (step4Time-step3Time));
			
			
			//sort!
			Employee[] sortedByValue = ec.sortByValue();
			long step5Time = System.nanoTime();
			System.out.println("Sorted in "+ (step5Time-step4Time));
			
			// uncomment this to show underlying data
			/*System.out.println("Developer Report");
			for ( int q = 0; q<sortedByValue.length; q++) {
				
				System.out.println(sortedByValue[q]);
			}*/
		}
		
		
		System.out.println("Test Complete.");
		
	}
	public Employee[] sortByValue() {
		// value is calculated by hoursBilled * a quality modifier
		// in other words, the more code without errors, the more value an 
		// employee provides to the company
		
		// create an array to hold the sorted, ranked employees
		Employee[] returnArray = new Employee[developers.size()];
		int lastPosition = 0;
		// loop over all the developers
		for (Employee e : developers) {
			// calculate the value this employee provides
			double thisValue = (double) e.getHoursBilled() * ((double) 1 / ((int) e.getQualityGrade()-96) );
			// save the value to the employee object
			e.setValueRanking( thisValue );
			 
			// add the employee to the end of the array you will be returning
			 returnArray[lastPosition]=e;
			 // loop over the employees added to the return array
			 for ( int r = lastPosition; r>0; r--) {
				 // if right is greater than left...
				 // shift the new addition down the returnArray so that it is 
				 // in the proper place
				 if (returnArray[r].getValueRanking() > returnArray[r-1].getValueRanking() ) {
					 	// store left
					 	Employee emp = returnArray[r-1];
					 	// copy right into left
					 	returnArray[r-1]=returnArray[r];
					 	// copy stored left into right
					 	returnArray[r]=emp;
				 }
			 }
			 lastPosition++;
			
		}
		return returnArray;
	}
//	public Employee getEmployeeById(int employeeid)  {
//		for ( Employee e : developers) {
//			if (e.getEmployeeId == employeeid) {
//				return e;
//			}
//		}
//		// if we can't find this record, we return a blank one
//		throw IllegalArgumentException("Employee record not found");
//	}
	public int averageLinesOfCode() {   
		// compute the average of all the developer lines of code values
		int totalLines = 0;
		
		for ( Employee e : developers) {
			totalLines+= e.getLinesOfCode();
		}
		// it is OK we are dropping the decimal
		return totalLines / developers.size();
	}
	public void setQualityGrade() {
		// developers get a grade based on a percentage of bugs per lines of code
		ListIterator<Employee> iter = developers.listIterator();
		while (iter.hasNext()) {
			
			Employee e = iter.next();
			double percentQuality = (double) (e.getLinesOfCode() - e.getBugCount()) / e.getLinesOfCode();
			char grade = 'f'; // default case
			if (percentQuality >= 0.9) {
				grade = 'a';
			} else if ( percentQuality >= 0.8 ) {
				grade = 'b';
			} else if ( percentQuality >= 0.7 ) {
				grade = 'c';
			} else if ( percentQuality >= 0.6 ) {
				grade = 'd';
			}
			e.setQualityGrade(grade);
		}
	}
	public void setQuantityRankings() {
		for ( Employee e : developers ) {
			// quantity ranking is a function of lines of code per hour of billed time
			// compute the efficiency of this developer, then count how many developers
			// were more productive
			
			int rank = 0;
			double efficiency = e.getLinesOfCode() / e.getHoursBilled();
			
			for ( Employee f : developers ) {
				if ( f.getEmployeeId() != e.getEmployeeId()) // don't compare this one!
				{ 
					double fEfficiency = f.getLinesOfCode() / f.getHoursBilled();
					if ( fEfficiency < efficiency ) 
						{ rank++; }
				}
			}
			e.setQuantityRanking(rank);
		}
	}
}
