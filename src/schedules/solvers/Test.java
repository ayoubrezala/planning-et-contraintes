package schedules.solvers;
import java.util.Random;
import schedulestests.solvers.TopologicalSorterTests;
import schedulestests.solvers.VerifierTests;
import schedulestests.solvers.RandomSchedulerTests;

/*
/src$ java -cp ../build:../lib/schedulestests.jar schedules.activities.Test 

*/
public class Test{
	public final static String USAGE = "Expected 1 argument: seed for random generation";
	public final static String WRONG_SEED = "Expected long as argument but found: %s";
	
	public static void main(String[] args){
		/*
		*Prend en argument un nombre 
		*Qui fixera la graine de notre générateur
		*/ 
		if (args.length != 1) {
			System.err.println(USAGE);
			System.exit(1);
		}
		Long seed = null;
		String seedString = args[0];
		try {
			seed = Long.parseLong(seedString);
		} catch (NumberFormatException e) {
			System.err.println(String.format(WRONG_SEED, seedString));
			System.exit(1);
		}

		Random random = new Random(seed);
		boolean ok = true;
		TopologicalSorterTests topologicalSortTester = new TopologicalSorterTests();
		ok = ok && topologicalSortTester.testBruteForceSort();
		ok = ok && topologicalSortTester.testSchedule();
		ok = ok && topologicalSortTester.testLinearTimeSort();
		VerifierTests verifierTester = new VerifierTests();
		ok = ok && verifierTester.testUnsatisfied();
		RandomSchedulerTests randomSchedulerTester = new RandomSchedulerTests(random);
		ok = ok && randomSchedulerTester.testGenerateSchedule();
		System.out.println(ok ? "All tests passed" : "At least one test failed");

	}



	
}
