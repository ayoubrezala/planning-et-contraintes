package schedules.constraints;
import schedules.activities.Activity;
import java.util.*;

public class Demo{
    public static void main(String [] args){
        //Initialisation des activités
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
        Constraint unaryConstraint  = new UnaryConstraint(activity1, 20, 200);
        Constraint unaryConstraint2  = new UnaryConstraint(activity2, 10, 50);
        Map<Activity, Integer> unaryConstraintMap = new HashMap<> ();
        unaryConstraintMap.put(activity1, 36);
        unaryConstraintMap.put(activity2, 7);

        Set<Constraint> constraints = new HashSet<> ();
        constraints.add(precedenceC1);constraints.add(precedenceC2);constraints.add(precedenceC3);constraints.add(precedenceC4);
        constraints.add(meetC1); constraints.add(meetC2);
        constraints.add(precedenceC5);constraints.add(precedenceCWithGap1);constraints.add(precedenceCWithGap2);
        constraints.add(maxSpanConstraint);

        //Différents tests sur les exemples de contraintes générées
        System.out.println("1. Exemples sur les contraintes de précédence\n");
        System.out.println("Contrainte de précédence sur les activités : '" + activity1.getDescription() + "' et '" + activity2.getDescription() + "'");
        System.out.println("Début de l'activité '" + activity1.getDescription() + "' : 0 " );
        System.out.println("Début de l'activité '" + activity2.getDescription() + "' : 15 " );
        System.out.println("La contrainte est satisfaite pour ces durées : " + precedenceC1.isSatisfied(0, 15) + "\n");
        System.out.println("Essayons maintenant avec des durées qui ne satisfont pas la contrainte");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Contrainte de précédence sur les activités : '" + activity2.getDescription() + "' et '" + activity3.getDescription() + "'");
        System.out.println("Début de l'activité '" + activity1.getDescription() + "' : 5 " );
        System.out.println("Début de l'activité '" + activity2.getDescription() + "' : 12 " );
        System.out.println("La contrainte est non satisfaite pour ces durées : " + precedenceC2.isSatisfied(5, 12));
        
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("2. Exemples sur les contraintes concourantes\n");
        System.out.println("Contrainte concourantes sur les activités : '" + activity2.getDescription() + "' et '" + activity3.getDescription() + "'");
        System.out.println("Début de l'activité '" + activity2.getDescription() + "' : 8 " );
        System.out.println("Début de l'activité '" + activity3.getDescription() + "' : 18 " );
        System.out.println("La contrainte est satisfaite pour ces durées : " + meetC1.isSatisfied(8, 18) + "\n");
        System.out.println("Essayons maintenant avec des durées qui ne satisfont pas la contrainte");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Contrainte concourantes sur les activités : '" + activity3.getDescription() + "' et '" + activity4.getDescription() + "'");
        System.out.println("Début de l'activité '" + activity3.getDescription() + "' : 5 " );
        System.out.println("Début de l'activité '" + activity4.getDescription() + "' : 2 " );
        System.out.println("La contrainte est satisfaite pour ces durées : " + meetC2.isSatisfied(5, 2) + "\n");

        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("3. Exemples sur les contraintes de précedence avec délai\n");
        System.out.println("Contrainte de précedence avec Gasur les activités : '" + activity5.getDescription() + "' et '" + activity6.getDescription() + "'");
        System.out.println("Début de l'activité '" + activity5.getDescription() + "' : 10 " );
        System.out.println("Début de l'activité '" + activity6.getDescription() + "' : 36 " );
        System.out.println("La contrainte est satisfaite pour ces durées : " + precedenceCWithGap1.isSatisfied(10, 36) + "\n");
        System.out.println("Essayons maintenant avec des durées qui ne satisfont pas la contrainte");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Contrainte concourantes sur les activités : '" + activity1.getDescription() + "' et '" + activity2.getDescription() + "'");
        System.out.println("Début de l'activité '" + activity1.getDescription() + "' : 5 " );
        System.out.println("Début de l'activité '" + activity2.getDescription() + "' : 2 " );
        System.out.println("La contrainte est satisfaite pour ces durées : " + precedenceCWithGap2.isSatisfied(5, 2) + "\n"); 


        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("4. Exemples sur les MaxSpanConstraints\n");
        System.out.println("Contrainte de temps sur les activités :");
        for (HashMap.Entry<Activity, Integer> act : activitiesStart.entrySet()){
            System.out.println("'" + act.getKey().getDescription() + "' : " + act.getValue());    
        }
        System.out.println("La contrainte est satisfaite pour ces durées : " + maxSpanConstraint.isSatisfied(activitiesStart)); 
        
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("5. Exemples sur les Contraintes unaires\n");
        System.out.println("Contrainte de précedence avec sur l'activité : '" + activity1.getDescription() + "'");
        System.out.println("Début de l'activité '" + activity1.getDescription() + "' : 36 " );
        System.out.println("La contrainte est satisfaite pour ces durées : " + unaryConstraint.isSatisfied(unaryConstraintMap) + "\n");
        System.out.println("Essayons maintenant avec des durées qui ne satisfont pas la contrainte");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Contrainte concourantes sur les activités : '" + activity1.getDescription());
        System.out.println("Début de l'activité '" + activity2.getDescription() + "' : 7 " );
        System.out.println("La contrainte est satisfaite pour ces durées : " + unaryConstraint2.isSatisfied(unaryConstraintMap) + "\n"); 


    }
} 