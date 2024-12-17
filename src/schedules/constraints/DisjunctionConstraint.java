package schedules.constraints;
import schedules.activities.Activity;
import java.util.*;

public class DisjunctionConstraint implements Constraint{
    Constraint constraint1;
    Constraint constraint2;

    public DisjunctionConstraint(Constraint constraint1, Constraint constraint2){
        this.constraint1 = constraint1;
        this.constraint2 = constraint2;
    }

    public Set<Activity> getActivities(){
        Set<Activity> disjunctionActivities =  new HashSet<> ();
       
        for(Activity a1 : this.constraint1.getActivities()){
            disjunctionActivities.add(a1);
        }

        for(Activity a2 : this.constraint2.getActivities()){
            disjunctionActivities.add(a2);
        }   
        /*disjunctionActivitiesList.add(disjunctionActivities1);
        disjunctionActivitiesList.add(disjunctionActivities2);
        */
        
        return disjunctionActivities;  
    }

    Constraint getFirstConstraint(){
        return this.constraint1;
    }

    Constraint getSecondConstraint(){
        return this.constraint2;
    }

    public boolean isSatisfied(Map<Activity, Integer> activities){
        if (this.constraint1.isSatisfied(activities) || this.constraint2.isSatisfied(activities)){
            return true;
        }

        else if(this.constraint1.isSatisfied(activities) && this.constraint2.isSatisfied(activities)){
            return true;
        }

        return false;
    }
}