package schedules.solvers;
import schedules.activities.Activity;
import schedules.constraints.*;
import java.util.Random;
import java.util.*;

public class RandomScheduler{
    protected Random chance;
    public RandomScheduler(Random chance){
        this.chance =  chance;
    }

    public Map<Activity, Integer> generateOneSchedule(Set<Activity> activities, int minTime, int maxTime){
        if (activities.size() == 0){
            return null;
        }

        Map<Activity, Integer> scheduledActivities = new HashMap<>();
        for (Activity activity : activities){         
            int randomStart = this.chance.nextInt(maxTime - minTime + 1);
            scheduledActivities.put(activity, minTime + randomStart);
        }

        return scheduledActivities;
    }

    public Map<Activity, Integer> generateSchedule(Set<Activity> activities, Set<Constraint> constraints,  int minTime, int maxTime, int randomSelection){
        //Set<Set<Constraint>> unsatisfiedConstraints = new HashSet<> ();
        Set<Map<Activity, Integer>> schedules = new HashSet<> ();
        Verifier verifier = new Verifier(constraints);
        int unsatisfiedConstraints = -1;
        Map<Activity, Integer> selectedSchedule = new HashMap<> ();
        // Génération de plusieurs emplois du temps à partir de la fonction generateOneSchedule() précédemment écrite
        for (int i = 0; i < randomSelection; i++){
            Map<Activity, Integer> scheduledActivities = this.generateOneSchedule(activities, minTime, maxTime); 
            schedules.add(scheduledActivities); //Ajout des emplois du temps dans l'ensemble de maps schedules
        }
	/*
	On initialise une instance de Verifier 
	Sur laquelle est appelé la fonction unsatisfied et on retourne la map
	Pour laquelle il y a le moins d'activités non satisfaites et cette map qui est renvoyée 
	*/
        for (Map<Activity, Integer> currentSchedule : schedules){
        	Set<Constraint> verified = verifier.unsatisfied(currentSchedule);
            if (verified.size() < unsatisfiedConstraints || unsatisfiedConstraints == -1){
                unsatisfiedConstraints = verified.size();
                selectedSchedule = currentSchedule;

            }
        }

        return selectedSchedule;
    }
}
