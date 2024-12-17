package schedules.solvers;
import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.*;
import java.util.Random;

public class VerifierDemo{
    public static void main(String [] args){
        
        //Création d'ensembles pour les activités 
        Set<Activity> activitiesSatisfied = new HashSet<> ();
        Set<Activity> activitiesUnsatisfied = new HashSet<> ();
        Set<Constraint> constraintsSatisfied = new HashSet<> ();
        Set<Constraint> constraintUnsatisfied = new HashSet<> ();
        Map<Activity, Integer> constraintsSatisfiedMap = new HashMap<> ();
        Map<Activity, Integer> constraintUnsatisfiedMap = new HashMap<> ();
        Random random = new Random();
        //Création d'activités relatives à un concert 
        Activity act1 = new Activity("Commencer le concert", 1);
        Activity act2 = new Activity("Répéter avant le concert", 500);
        Activity act3 = new Activity("Stresser avant de monter sur scène", 10);
        Activity act4 = new Activity("Règler tous les instruments", 200);
        Activity act7 = new Activity("Arriver au lieu du concert", 25);
        Activity act8 = new Activity("Se préparer avant de démarrer de chez soi", 30);
        Activity act9 = new Activity("Rentrer chez soi", 15);
        Activity act10 = new Activity("Se lever et se concentrer", 5);

        //Ajout des activités à l'ensemble
        activitiesSatisfied.add(act1);
        activitiesSatisfied.add(act2);
        activitiesSatisfied.add(act3);
        activitiesSatisfied.add(act4);
        activitiesSatisfied.add(act7);

        activitiesUnsatisfied.add(act2);
        activitiesUnsatisfied.add(act3);
        activitiesUnsatisfied.add(act7);
        activitiesUnsatisfied.add(act8);
        activitiesUnsatisfied.add(act9);
        activitiesUnsatisfied.add(act10);

        //
        Constraint constraint1 = new PrecedenceConstraint(act3, act1);
        Constraint constraint2 = new PrecedenceConstraint(act2, act4);
        Constraint constraint3 = new PrecedenceConstraint(act7, act4);
        Constraint constraint4 = new PrecedenceConstraint(act4, act3);
        constraintsSatisfied.add(constraint1);
        constraintsSatisfied.add(constraint2);
        constraintsSatisfied.add(constraint3);
        constraintsSatisfied.add(constraint4);
        constraintsSatisfiedMap.put(act7, 15);
        constraintsSatisfiedMap.put(act2, 50);
        constraintsSatisfiedMap.put(act4, 575);
        constraintsSatisfiedMap.put(act3, 785);
        constraintsSatisfiedMap.put(act1, 799);

        //
        Set<Activity> maxSpanConstraintSet = new HashSet<> ();
        Constraint constraint6 = new MeetConstraint(act7, act2);
        Constraint maxSpanConstraint = new MaxSpanConstraint(maxSpanConstraintSet, 100);
        Constraint unaryConstraint1 = new UnaryConstraint(act9, 1000, 2000);
        Constraint unaryConstraint2 = new UnaryConstraint(act3, 100, 440);

        maxSpanConstraintSet.add(act10);
        maxSpanConstraintSet.add(act8);
        maxSpanConstraintSet.add(act7);

        constraintUnsatisfied.add(constraint6);
        constraintUnsatisfied.add(maxSpanConstraint);
        constraintUnsatisfied.add(unaryConstraint1);
        constraintUnsatisfied.add(unaryConstraint2);
        constraintUnsatisfiedMap.put(act2, random.nextInt(50));
        constraintUnsatisfiedMap.put(act3, random.nextInt(50));
        constraintUnsatisfiedMap.put(act7, random.nextInt(50));
        constraintUnsatisfiedMap.put(act8, random.nextInt(50));
        constraintUnsatisfiedMap.put(act9, random.nextInt(50));
        constraintUnsatisfiedMap.put(act10, random.nextInt(50));

        //Activités dont aucune contrainte non satisfaite
        System.out.println("\nActivités dont aucune contrainte non satisfaite");
        System.out.println("--------------------------------------------------------");
        Verifier verifier = new Verifier(constraintsSatisfied);
        System.out.println("Pour les activités : ");
        for (Activity act : activitiesSatisfied){
            System.out.println("    '" + act.getDescription() + "'");
        }
        System.out.println(verifier.unsatisfied(constraintsSatisfiedMap) + " : Il n'y a aucune contrainte non satisfaite");

        //Activités avec contraintes non satisfaites
        System.out.println("\nActivités avec contraintes non satisfaites");
        System.out.println("--------------------------------------------------------");
        System.out.println("Pour les activités : ");
        for (Activity act : activitiesUnsatisfied){
            System.out.println("    '" + act.getDescription() + "'");
        }
        System.out.println("Il y a : " + verifier.unsatisfied(constraintUnsatisfiedMap).size() + " contraintes non satisfaites");
    }


}