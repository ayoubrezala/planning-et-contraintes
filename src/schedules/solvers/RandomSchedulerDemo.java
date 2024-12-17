package schedules.solvers;
import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class RandomSchedulerDemo{
    public static void main(String [] args){
        //Création d'ensembles pour les activités 
        /*Set<Activity> activities = new HashSet<> ();
        Set<Activity> maxSpanConstraintSet = new HashSet<> ();
        Set<Constraint> constraints = new HashSet<> ();
        //Création d'activités relatives à un concert 
        Activity act1 = new Activity("Commencer le concert", 1);
        Activity act2 = new Activity("Répéter avant le concert", 500);
        Activity act3 = new Activity("Stresser avant de monter sur scène", 10);
        Activity act4 = new Activity("Règler tous les instruments", 200);
        Activity act5 = new Activity("Sonoriser la salle", 300);
        Activity act6 = new Activity("Préparer les chants prévus avant le jour du concert", 750);
        Activity act7 = new Activity("Arriver au lieu du concert", 25);
        Activity act8 = new Activity("Se préparer avant de démarrer de chez soi", 30);
        Activity act9 = new Activity("Rentrer chez soi", 15);
        Activity act10 = new Activity("Se lever et se concentrer", 5);
        
        //Ajout des activités à l'ensemble
        activities.add(act1);
        activities.add(act2);
        activities.add(act3);
        activities.add(act4);
        activities.add(act5);
        activities.add(act6);
        activities.add(act7);
        activities.add(act8);
        activities.add(act9);
        activities.add(act10);
        

        //Ajout des activités dans maxSpanConstraintSet
        maxSpanConstraintSet.add(act10);
        maxSpanConstraintSet.add(act8);
        maxSpanConstraintSet.add(act7);

        //Contraintes sur les activités
        Constraint constraint1 = new PrecedenceConstraint(act10, act8);
        Constraint constraint2 = new PrecedenceConstraint(act6, act10);
        Constraint constraint3 = new PrecedenceConstraint(act5, act1);
        Constraint constraint4 = new PrecedenceConstraint(act2, act1);
        Constraint constraint5 = new PrecedenceConstraint(act5, act4);
        Constraint constraint6 = new MeetConstraint(act7, act2);
        Constraint constraint7 = new PrecedenceConstraint(act1, act9);
        Constraint constraint8 = new PrecedenceConstraint(act5, act9);
        Constraint constraint9 = new PrecedenceConstraint(act2, act4);
        Constraint constraint10 = new PrecedenceConstraint(act2, act1);
        Constraint constraint11= new PrecedenceConstraint(act1, act6);
        Constraint constraint12 = new PrecedenceConstraint(act8, act7);
        Constraint constraint13 = new PrecedenceConstraint(act2, act1);
        Constraint maxSpanConstraint = new MaxSpanConstraint(maxSpanConstraintSet, 100);
        Constraint unaryConstraint1 = new UnaryConstraint(act9, 1000, 2000);
        Constraint unaryConstraint2 = new UnaryConstraint(act3, 100, 440);

        //Ajout des contraintes à l'ensemble des contraintes
        constraints.add(constraint1);
        constraints.add(constraint2);
        constraints.add(constraint3);
        constraints.add(constraint4);
        constraints.add(constraint5);
        constraints.add(constraint6);
        constraints.add(constraint7);
        constraints.add(constraint8);
        constraints.add(constraint9);
        constraints.add(constraint10);
        constraints.add(constraint11);
        constraints.add(constraint12);
        constraints.add(constraint13);
        constraints.add(maxSpanConstraint);
        constraints.add(unaryConstraint1);
        constraints.add(unaryConstraint2);

    //Génération des emplois du temps les plus cohérents

        List<Map<Activity, Integer>> schedules = new ArrayList<> ();
        Random random = new Random();
        int randomSelection = 1000;
        RandomScheduler randomScheduler = new RandomScheduler(random);
        System.out.println("Voici les emplois du temps respectant le plus de contraintes : ");
        for (int i = 1; i < randomSelection + 1; i++){
            schedules.add(randomScheduler.generateSchedule(activities, constraints, 0, 2000, 20*i));
            System.out.println("Emploi du temps numéro " + i + ", généré avec " + 20*i + " échantillons : " +   schedules.get(i-1) + "\n");
            //System.out.println("Nombre d'activités : " + schedules.get(i-1).size() + '\n');
        }
        */        //Initialisation des activités
        Activity activity1 = new Activity("Se lever", 1);
        Activity activity2 = new Activity("Prendre un petit-déjeuner", 10);
        Activity activity3 = new Activity("Prendre une douche", 5);
        Activity activity4 = new Activity("Se brosser les dents", 2);
        Activity activity5 = new Activity("Aller à l'examen", 20);
        Activity activity6 = new Activity("Commencer l'examen", 1);
        Set<Activity> activities = new HashSet<> ();
        Map<Activity,Integer> activitiesStart = new HashMap<> ();
        activities.add(activity1); activities.add(activity2); activities.add(activity3); 
        activities.add(activity4); activities.add(activity5); activities.add(activity6);
        
        //Affichage des activités
        Integer time = 0;
        System.out.println("Affichage des activités");
        for(Activity a : activities){
            time = new Random().nextInt(400);
            activitiesStart.put(a, time);
            System.out.println("Activité : " + a.getDescription() + " - " + a.getDuration());
        }
        //--

        //Initialisation des contraintes sur les activités afin de générer un emploi du temps
        PrecedenceConstraint precedenceC1 = new PrecedenceConstraint(activity1, activity2);
        PrecedenceConstraint precedenceC2 = new PrecedenceConstraint(activity2, activity3);
        Constraint precedenceC3 = new PrecedenceConstraint(activity3, activity4);
        Constraint precedenceC4 = new PrecedenceConstraint(activity4, activity5);
        Constraint precedenceC5 = new PrecedenceConstraint(activity5, activity6);
        MeetConstraint meetC1 = new MeetConstraint(activity2, activity3);
        MeetConstraint meetC2 = new MeetConstraint(activity3, activity4);
        PrecedenceConstraintWithGap precedenceCWithGap1 = new PrecedenceConstraintWithGap(activity5, activity6, 5, 20);
        PrecedenceConstraintWithGap precedenceCWithGap2 = new PrecedenceConstraintWithGap(activity1, activity2, 1, 10);
        Constraint maxSpanConstraint = new MaxSpanConstraint(activities, 500); 

        Set<Constraint> constraints = new HashSet<> ();
        constraints.add(precedenceC1);constraints.add(precedenceC2);constraints.add(precedenceC3);constraints.add(precedenceC4);
        constraints.add(meetC1); constraints.add(meetC2);
        constraints.add(precedenceC5);constraints.add(precedenceCWithGap1);constraints.add(precedenceCWithGap2);
        constraints.add(maxSpanConstraint);
        //System.out.println("Nombre d'activités : " + schedules.size());

        System.out.println("Génération de plusieurs emplois du temps différents : ");
        System.out.println("------------------------------------------------------\n");
        List<Map<Activity, Integer>> schedules = new ArrayList<> ();
        Random random = new Random();
        int randomSelection = 5;
        RandomScheduler randomScheduler = new RandomScheduler(random);
        System.out.println("Voici les emplois du temps respectant le plus de contraintes : ");
        System.out.println("----------------------------------------------------------------\n");
        for (int i = 1; i < randomSelection + 1; i++){
            schedules.add(randomScheduler.generateSchedule(activities, constraints, 0, 500, 20*i));
            System.out.println("Emploi du temps numéro " + i + ", généré avec " + 20*i + " échantillons : " +   schedules.get(i-1) + "\n");
            //System.out.println("Nombre d'activités : " + schedules.get(i-1).size() + '\n');
        }
        
    }
}