package schedules.solvers;
import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;

public class Verifier{
    Set<Constraint> constraints;

    public Verifier(Set<Constraint> constraints){
        this.constraints = constraints;
    }

    public Set<Constraint> unsatisfied(Map<Activity, Integer> activities){
        Set<Constraint> unsatisfiedConstraints = new HashSet<> ();
        for (Constraint constraint : this.constraints){
            if(constraint.isSatisfied(activities) == false){
                unsatisfiedConstraints.add(constraint);
            }
        }

        return unsatisfiedConstraints;
    }

    

}