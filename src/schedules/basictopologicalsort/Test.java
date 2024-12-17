package schedules.basictopologicalsort;
import schedulestests.basictopologicalsort.TopologicalSorterTests;
/*
/src$ java -cp ../build:../lib/schedulestests.jar schedules.activities.Test 

*/
public class Test{
	public static void main(String[] args){
		boolean ok = true;
		TopologicalSorterTests tester = new TopologicalSorterTests();
		ok = ok && tester.testBruteForceSort();
		ok = ok && tester.testSchedule();
		ok = ok && tester.testLinearTimeSort();
		System.out.println(ok ? "All tests OK" : "At least one test KO");

	}
	
}
