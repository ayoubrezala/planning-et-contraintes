package schedules.basicconstraints;
import schedulestests.basicconstraints.PrecedenceConstraintTests;
import schedulestests.basicconstraints.MeetConstraintTests;
import schedulestests.basicconstraints.PrecedenceConstraintWithGapTests;

public class Test{
	public static void main(String[] args){
		boolean ok = true;
		PrecedenceConstraintTests precedenceTester = new PrecedenceConstraintTests();
		MeetConstraintTests meetTester = new MeetConstraintTests();
		PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();

		ok = ok && precedenceTester.testGetFirst();
		ok = ok && precedenceTester.testGetSecond();
		ok = ok && precedenceTester.testIsSatisfiedBy();
		
		ok = ok && meetTester.testGetFirst();
		ok = ok && meetTester.testGetSecond();
		ok = ok && meetTester.testIsSatisfiedBy();
		
		ok = ok && precedenceConstraintWithGapTester.testExtends();
		ok = ok && precedenceConstraintWithGapTester.testGetFirst();
		ok = ok && precedenceConstraintWithGapTester.testGetSecond();
		ok = ok && precedenceConstraintWithGapTester.testIsSatisfiedBy();
		System.out.println(ok ? "All tests passed" : "At least one test failed");
	}
}
