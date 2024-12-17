package schedules.basictopologicalsort;
import schedules.activities.Activity;
import schedules.basicconstraints.PrecedenceConstraint;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Demo{
	public static void main(String[] args){
		TopologicalSorter sorter = new TopologicalSorter();
		
		//Série d'activités cohérentes
		Activity act1 = new Activity("Se lever", 1);
		Activity act2 = new Activity("Aller au travail",15 );
		Activity act3 = new Activity("Prendre une douche", 10);
		Activity act4 = new Activity("Se brosser les dents", 3);
		Activity act5 = new Activity("S'habiller", 2);
		Activity act6 = new Activity("Prendre un petit déjeuner", 5);
		
		//Série d'activités incohérentes
		Activity act1b = new Activity("Réviser", 30);
		Activity act2b = new Activity("Aller en salle d'examen", 15);
		Activity act3b = new Activity("Prendre connaissance du sujet", 250);
		
		//Contraintes sur les 4 premières activités
		PrecedenceConstraint constraint1 = new PrecedenceConstraint(act1, act6);
        PrecedenceConstraint constraint2 = new PrecedenceConstraint(act1, act5);
        PrecedenceConstraint constraint3 = new PrecedenceConstraint(act4, act2);
        PrecedenceConstraint constraint4 = new PrecedenceConstraint(act5, act2);
		PrecedenceConstraint constraint5 = new PrecedenceConstraint(act6, act4);
		PrecedenceConstraint constraint6 = new PrecedenceConstraint(act3, act5);
		PrecedenceConstraint constraint7 = new PrecedenceConstraint(act1, act3);
		PrecedenceConstraint constraint8 = new PrecedenceConstraint(act6, act2);


        	//Contraintes incohérentes sur les 3 dernières activités 
        	PrecedenceConstraint constraint1b = new PrecedenceConstraint(act1b, act2b);
        	PrecedenceConstraint constraint2b = new PrecedenceConstraint(act3b, act1b);
        	PrecedenceConstraint constraint3b = new PrecedenceConstraint(act3b, act2b);

		HashSet<PrecedenceConstraint> constraints = new HashSet<> ();
		HashSet<Activity> activities = new HashSet<> (); 
		constraints.add(constraint1);
		constraints.add(constraint2);
		constraints.add(constraint3);
		constraints.add(constraint4);
		constraints.add(constraint5);
		constraints.add(constraint6);
		constraints.add(constraint7);
		constraints.add(constraint8);
		activities.add(act1);
		activities.add(act2);
		activities.add(act3);
		activities.add(act4);
		activities.add(act5);
		activities.add(act6);
		
		HashSet<PrecedenceConstraint> constraintsb = new HashSet<> ();
		HashSet<Activity> activitiesb = new HashSet<> (); 
		constraintsb.add(constraint1b);
		constraintsb.add(constraint2b);
		constraintsb.add(constraint3b);
		activitiesb.add(act1b);
		activitiesb.add(act2b);
		activitiesb.add(act3b);
		
		ArrayList<Activity> res = new ArrayList<> ();
		//Activity sorted = sorter.searchAvalaibleObject(activities, res, constraints);
		ArrayList<Activity> sorterList = sorter.bruteForceSort(activities, constraints);
		ArrayList<Activity> sorterListb = sorter.bruteForceSort(activitiesb, constraintsb);
		HashMap<Activity, Integer> scheduledAct = sorter.schedule(activities, constraints, 0);
		System.out.println("Activités ordonnées");
		System.out.println(sorterList + "\n");
		System.out.println("Activités et contraintes incohérentes");
		System.out.println(sorterListb + "\n");
		System.out.println("Test de la fonction schedule() \n" + scheduledAct);
		

		//Création des 2000 activités 
		HashSet<PrecedenceConstraint> c = new HashSet<> ();
		ArrayList<Activity> a = new ArrayList<> ();
		HashSet<Activity> b = new HashSet<> ();

		for (int i = 1; i <= 2000; i++){
			Activity act = new Activity("Activite " + i, i);
			b.add(act);
			a.add(act);
		}

		
		for (int i = 0; i < a.size()- 2; i++){
			PrecedenceConstraint co = new PrecedenceConstraint(a.get(i), a.get(i+1));
			c.add(co);
		}

		//Temps d'excution LinearSort et bruteForceSort avec les 2000 activités de test
		long startLinearTime = System.currentTimeMillis();
		sorter.linearTimeSort(b, c);
		long durationLinear = System.currentTimeMillis() - startLinearTime;
		
		long startbruteForceSort = System.currentTimeMillis();
		sorter.bruteForceSort(b, c);
		long durationbruteForceSort = System.currentTimeMillis() - startbruteForceSort;
		System.out.println("La fonction linearTimesort() le programme met : " + durationLinear +  " ms");
		System.out.println("La fonction bruteForceSort() le programme met : " + durationbruteForceSort +  " ms");
		


		

	}
}
