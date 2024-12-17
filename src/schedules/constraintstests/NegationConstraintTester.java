package schedules.constraintstests;
import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.*;


public class NegationConstraintTester{
    public NegationConstraintTester(){}

    public boolean testImplements(){
        System.out.println("[Tests][NegationConstraintTests::testImplements] launched ");
        Activity activity1 = new Activity("Se lever", 1);
        Activity activity2 = new Activity("Prendre un petit-déjeuner", 10);
        PrecedenceConstraint pConstraint = new PrecedenceConstraint(activity1, activity2);
        NegationConstraint negPreConstraint = new NegationConstraint(pConstraint);
        if (negPreConstraint instanceof Constraint){
            System.out.println("[Tests][NegationConstraintTests::testImplements] passed ");
            return true;
        }
        System.out.println("[Tests][NegationConstraintTests::testImplements] failed ");
        System.out.println("Class doesn't implement interface");
        return false;


    }
    public boolean testGetConstraint(){
        System.out.println("[Tests][NegationConstraintTests::testGetConstraint] launched ");
        Activity activity1 = new Activity("Se lever", 1);
        Activity activity2 = new Activity("Prendre un petit-déjeuner", 10);
        PrecedenceConstraint pConstraint = new PrecedenceConstraint(activity1, activity2);
        MeetConstraint meetC = new MeetConstraint(activity1, activity2);
        NegationConstraint negPreConstraint = new NegationConstraint(pConstraint);
        NegationConstraint negMeetConstraint = new NegationConstraint(meetC);
        
        if (pConstraint == negPreConstraint.getConstraint() && meetC == negMeetConstraint.getConstraint()){
            System.out.println("[Tests][NegationConstraintTests::testGetConstraint] passed ");
            return true;
   
        }

        else{
            System.out.println("[Tests][NegationConstraintTests::testGetConstraint] failed ");
            System.out.println("Returned constraints don't match\nReturns : " + negPreConstraint.getActivities() + "\nPlutôt que " + pConstraint.getActivities());
            return false;

        }
    }

    public boolean testGetActivities(){
        System.out.println("[Tests][NegationConstraintTests::testGetActivities] launched ");
        Activity a1 = new Activity("Se brosser les dents", 2);
        Activity a2 = new Activity("Aller à l'examen", 20);
        Activity a3 = new Activity("Commencer l'examen", 1);
        PrecedenceConstraint pConstraint = new PrecedenceConstraint(a1, a2);
        NegationConstraint negPreConstraint = new NegationConstraint(pConstraint);
        Set<Activity> activities = new HashSet<> ();
        activities.add(a1); activities.add(a2);
        
        if (negPreConstraint.getActivities() == pConstraint.getActivities()){
            System.out.println("[Tests][NegationConstraintTests::testGetActivities] passed ");
            return true;
        }
        System.out.println("[Tests][NegationConstraintTests::testGetActivities] failed ");
        System.out.println("Activities don't match with expected activities");
        return false;
    }
    
    public boolean testIsSatisfied(){
        System.out.println("[Tests][NegationConstraintTests::testIsSatisfied] launched ");
        Activity activity1 = new Activity("Se lever", 1);
        Activity activity2 = new Activity("Prendre un petit-déjeuner", 10);
        PrecedenceConstraint pConstraint = new PrecedenceConstraint(activity1, activity2);
        NegationConstraint negPreConstraint = new NegationConstraint(pConstraint);
        Map<Activity, Integer> timedActivities = new HashMap<> (); 
        timedActivities.put(activity1, 0);
        timedActivities.put(activity2, 5);
        if(negPreConstraint.isSatisfied(timedActivities) == !pConstraint.isSatisfied(timedActivities)){
            System.out.println("[Tests][NegationConstraintTests::testIsSatisfied] passed ");
            return true;
        }

        else {
            System.out.println("[Tests][NegationConstraintTests::testIsSatisfied] failed ");
            System.out.println("Constraint does not satisfied the test");
            return false;

        }
    }
}