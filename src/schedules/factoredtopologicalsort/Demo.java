package schedules.factoredtopologicalsort;
import schedules.activities.Activity;
import schedules.factoredconstraints.PrecedenceConstraint;
import java.util.HashSet;
import java.util.ArrayList;

public class Demo{
	public static void main(String[] args){
		TopologicalSorter sorter = new TopologicalSorter();
		Activity act1 = new Activity("Manger", 50);
		Activity act2 = new Activity("Dormir", 100);
		Activity act3 = new Activity("Réviser", 250);
		Activity act4 = new Activity("Rentrer à la maison", 15);
		PrecedenceConstraint constraint1 = new PrecedenceConstraint(act1, act3);
                PrecedenceConstraint constraint2 = new PrecedenceConstraint(act3, act2);
                PrecedenceConstraint constraint3 = new PrecedenceConstraint(act2, act4);

		HashSet<PrecedenceConstraint> constraints = new HashSet<> ();
		HashSet<Activity> activities = new HashSet<> (); 
		constraints.add(constraint1);
		constraints.add(constraint2);
		constraints.add(constraint3);
		activities.add(act1);
		activities.add(act2);
		activities.add(act3);
		activities.add(act4);
		ArrayList<Activity> res = new ArrayList<> ();
		//Activity sorted = sorter.searchAvalaibleObject(activities, res, constraints);
		ArrayList<Activity> sorterList = sorter.bruteForceSort(activities, constraints);
		System.out.println(sorterList);

	}
}
