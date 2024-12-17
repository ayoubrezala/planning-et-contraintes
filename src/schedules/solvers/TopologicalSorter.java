package schedules.solvers;
import schedules.activities.Activity;
import schedules.constraints.PrecedenceConstraint;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;


public class TopologicalSorter{
	public TopologicalSorter(){}

	public List<Activity> bruteForceSort(Set<Activity> activities, Set<PrecedenceConstraint> precedenceConstraints){
		Set<Activity> activitiesCopy = new HashSet<> ();
		for(Activity act : activities){
			activitiesCopy.add(act);
		}
		List<Activity> res = new ArrayList<Activity> ();
		while(activitiesCopy.size() != 0){
			Activity avalaibleObject = searchAvalaibleObject(activitiesCopy, res, precedenceConstraints);
			if (avalaibleObject == null){
				return null;
			}
			
			else{
				res.add(avalaibleObject);
				activitiesCopy.remove(avalaibleObject);
			}
		}
		
		return res;
	}
	
	public Activity  searchAvalaibleObject(Set<Activity> activities,  List<Activity> res, Set<PrecedenceConstraint> precedenceConstraints){
		for (Activity currentActivity : activities){
			boolean ok = true;
			for (PrecedenceConstraint constraint :  precedenceConstraints){
				if (currentActivity  == constraint.getSecond() && !res.contains(constraint.getFirst())){
					ok = false;
					break;
				}
			}
			if (ok){
				return currentActivity;
			}

		}
	return null;
	}

	public Map<Activity, Integer> schedule(Set<Activity> activities, Set<PrecedenceConstraint> precedenceConstraints, int date){
		Map<Activity, Integer> activitiesMap  = new HashMap<> ();
		
		if (bruteForceSort(activities, precedenceConstraints) == null){
			return null;
		}

		else{
			List<Activity> mesActivites = bruteForceSort(activities, precedenceConstraints); 
			int currentDate = date;
			for(Activity act : mesActivites){
				activitiesMap.put(act, currentDate);
				currentDate += act.getDuration();
			}
		
			return activitiesMap;
		}
	}

	public List<Activity> linearTimeSort(Set<Activity> activities, Set<PrecedenceConstraint> constraints){
		Map<Activity, Integer> nbPredecesseurs = new HashMap<>();
		Map<Activity, List<Activity>> successeurs = new HashMap<>();
		for (Activity i:activities){
			nbPredecesseurs.put(i,0);
			List<Activity> nouv = new ArrayList<>();
			successeurs.put(i,nouv);
		}
			
		for (PrecedenceConstraint c:constraints){
			nbPredecesseurs.put(c.getSecond(),nbPredecesseurs.get(c.getSecond())+1);
			List<Activity> nouv = successeurs.get(c.getFirst());
			nouv.add(c.getSecond());
			successeurs.put(c.getFirst(),nouv);
		}
			
		List<Activity> L =  new ArrayList<>();
		List<Activity> res = new ArrayList<>();
		for (Activity i:activities){
			if (nbPredecesseurs.get(i) == 0){
				L.add(i);
			}
		}
			
		while (L.size() != 0){
			Activity o = L.get(0);
			res.add(o);
			L.remove(0);
			for (Activity i: successeurs.get(o)){
				nbPredecesseurs.put(i,nbPredecesseurs.get(i)-1);
				if (nbPredecesseurs.get(i) == 0){
					L.add(i);
				}
			}
				
				
		}
		if (res.size() == activities.size()){
			return res;
		}
			return null;
	}
	

	
	


}
