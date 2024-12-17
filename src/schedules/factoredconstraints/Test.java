package schedules.factoredconstraints;
import schedulestests.factoredconstraints.AbstractionTests;
import schedulestests.factoredconstraints.PrecedenceConstraintTests;
import schedulestests.factoredconstraints.MeetConstraintTests;
import schedulestests.factoredconstraints.PrecedenceConstraintWithGapTests;

public class Test{
	public static void main(String[] args){
		boolean ok = true;
		// Abstract class
		AbstractionTests abstracttionTester = new AbstractionTests();
		ok = ok && abstracttionTester.test();
		PrecedenceConstraintTests precedenceTester = new PrecedenceConstraintTests();
		MeetConstraintTests meetConstraintTester = new MeetConstraintTests();
		PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester = new PrecedenceConstraintWithGapTests();

		ok = ok && precedenceTester.testGetFirst();
		ok = ok && precedenceTester.testGetSecond();
		ok = ok && precedenceTester.testIsSatisfiedBy();
		
		ok = ok && meetConstraintTester.testGetFirst();
		ok = ok && meetConstraintTester.testGetSecond();
		ok = ok && meetConstraintTester.testIsSatisfiedBy();
		
		ok = ok && precedenceConstraintWithGapTester.testExtends();
		ok = ok && precedenceConstraintWithGapTester.testGetFirst();
		ok = ok && precedenceConstraintWithGapTester.testGetSecond();
		ok = ok && precedenceConstraintWithGapTester.testIsSatisfiedBy();
		System.out.println(ok ? "All tests passed" : "At least one test failed");
	}
}
