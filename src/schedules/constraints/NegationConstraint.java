package schedules.constraints;
import schedules.activities.Activity;
import java.util.*;

public class NegationConstraint implements Constraint{
    Constraint constraint;

    public NegationConstraint(Constraint constraint){
        this.constraint = constraint;
    }

    public Constraint getConstraint(){
        return this.constraint;
    }

    public Set<Activity> getActivities(){
        Set<Activity> activities = new HashSet<> ();
        for (Activity act : this.constraint.getActivities()){
            activities.add(act);
        }
        return activities;
    }

    public boolean isSatisfied(Map<Activity, Integer> activities){
        return !this.constraint.isSatisfied(activities);
    } 
}