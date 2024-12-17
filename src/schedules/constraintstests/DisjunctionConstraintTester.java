package schedules.constraintstests;
import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.*;

public class DisjunctionConstraintTester{

    public DisjunctionConstraintTester(){}

    public boolean testImplements(){
        System.out.println("[Tests][DisjunctionConstraintTests::testImplements] launched ");
        Activity activity1 = new Activity("Se lever", 1);
        Activity activity2 = new Activity("Prendre un petit-déjeuner", 10);
        Activity activity3 = new Activity("Prendre une douche", 5);
        Activity activity4 = new Activity("Se brosser les dents", 2);
        PrecedenceConstraint pConstraint = new PrecedenceConstraint(activity1, activity2);
        MeetConstraint mConstraint =  new MeetConstraint(activity3, activity4);
        DisjunctionConstraint disConstraint = new DisjunctionConstraint(pConstraint, mConstraint);
        if (disConstraint instanceof Constraint){
            System.out.println("[Tests][DisjunctionConstraintTests::testImplements] passed ");
            return true;
        }
        System.out.println("[Tests][DisjunctionConstraintTests::testImplements] failed ");
        System.out.println("Class doesn't implement interface");
        return false;


    }

    public boolean testGetConstraint(){
        System.out.println("[Tests][DisjunctionConstraintTests::testGetConstraint] launched ");
        Activity activity1 = new Activity("Se lever", 1);
        Activity activity2 = new Activity("Prendre un petit-déjeuner", 10);
        Activity activity3 = new Activity("Prendre une douche", 5);
        Activity activity4 = new Activity("Se brosser les dents", 2);
        PrecedenceConstraint pConstraint = new PrecedenceConstraint(activity1, activity2);
        MeetConstraint mConstraint =  new MeetConstraint(activity3, activity4);
        DisjunctionConstraint disConstraint = new DisjunctionConstraint(pConstraint, mConstraint);

        if (disConstraint.getActivities().contains(activity1) && disConstraint.getActivities().contains(activity2) && disConstraint.getActivities().contains(activity3) && disConstraint.getActivities().contains(activity4)){ 
            System.out.println("[Tests][DisjunctionConstraintTests::testGetConstraint] passed ");
            return true;
   
        }

        else{
            System.out.println("[Tests][DisjunctionConstraintTests::testGetConstraint] failed ");
            System.out.println("Returned constraints don't match\nReturns : " + disConstraint.getActivities() + "\nPlutôt que " + disConstraint.getActivities());
            return false;

        }
    }
    public boolean testIsSatisfied(){
        System.out.println("[Tests][DisjunctionConstraintTests::testIsSatisfied] launched ");
        Activity activity1 = new Activity("Se lever", 1);
        Activity activity2 = new Activity("Prendre un petit-déjeuner", 10);
        Activity activity3 = new Activity("Prendre une douche", 5);
        Activity activity4 = new Activity("Se brosser les dents", 2);
        PrecedenceConstraint pConstraint = new PrecedenceConstraint(activity1, activity2);
        MeetConstraint mConstraint =  new MeetConstraint(activity3, activity4);
        DisjunctionConstraint disConstraint = new DisjunctionConstraint(pConstraint, mConstraint);
        Map<Activity, Integer> timedActivities = new HashMap<> (); 
        timedActivities.put(activity1, 0);
        timedActivities.put(activity2, 5);
        timedActivities.put(activity3, 9);
        timedActivities.put(activity4, 7);
        if ((disConstraint.isSatisfied(timedActivities) == pConstraint.isSatisfied(timedActivities) || disConstraint.isSatisfied(timedActivities) == pConstraint.isSatisfied(timedActivities)) && disConstraint.isSatisfied(timedActivities) == true){
        System.out.println("[Tests][DisjunctionConstraintTests::testIsSatisfied] passed ");
            return true;
        }

        else if ((disConstraint.isSatisfied(timedActivities) == pConstraint.isSatisfied(timedActivities) && disConstraint.isSatisfied(timedActivities) == pConstraint.isSatisfied(timedActivities)) && disConstraint.isSatisfied(timedActivities) == true){
        System.out.println("[Tests][DisjunctionConstraintTests::testIsSatisfied] passed ");
            return true;
        }

        else {
        System.out.println("[Tests][DisjunctionConstraintTests::testIsSatisfied] failed ");
        System.out.println("Not expected output");

            return false;
        }
    }
}