package schedules.constraintstests;
import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.*;

public class TestDemo{
    public static void main(String [] args ){
        boolean ok = true;
        NegationConstraintTester negTester = new NegationConstraintTester();
        DisjunctionConstraintTester disjunctionTester = new DisjunctionConstraintTester();
        ok = ok && negTester.testImplements();
        ok = ok && negTester.testGetConstraint();
        ok = ok && negTester.testIsSatisfied();
        ok = ok && disjunctionTester.testImplements();
        ok = ok && disjunctionTester.testGetConstraint();
        ok = ok && disjunctionTester.testIsSatisfied();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }

    
}