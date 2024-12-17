package schedules.basictopologicalsort;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
import schedules.activities.Activity;
import schedules.basicconstraints.PrecedenceConstraint;


public class TopologicalSorter{
	public TopologicalSorter(){}

	public ArrayList<Activity> bruteForceSort(HashSet<Activity> activities, HashSet<PrecedenceConstraint> precedenceConstraints){
		HashSet<Activity> activitiesCopy = new HashSet<> (activities);
		ArrayList<Activity> res = new ArrayList<Activity> ();
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
	
	public Activity  searchAvalaibleObject(HashSet<Activity> activities,  ArrayList<Activity> res, HashSet<PrecedenceConstraint> precedenceConstraints){
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

	public HashMap<Activity, Integer> schedule(HashSet<Activity> activities, HashSet<PrecedenceConstraint> precedenceConstraints, int date){
		HashMap<Activity, Integer> activitiesMap  = new HashMap<> ();
		
		if (bruteForceSort(activities, precedenceConstraints) == null){
			return null;
		}

		else{
			ArrayList<Activity> mesActivites = bruteForceSort(activities, precedenceConstraints); 
			int currentDate = date;
			for(Activity act : mesActivites){
				activitiesMap.put(act, currentDate);
				currentDate += act.getDuration();
			}
		
			return activitiesMap;
		}
	}

		public ArrayList<Activity> linearTimeSort(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints){
			HashMap<Activity, Integer> nbPredecesseurs = new HashMap<>();
			HashMap<Activity, ArrayList<Activity>> successeurs = new HashMap<>();
			for (Activity i:activities){
				nbPredecesseurs.put(i,0);
				ArrayList<Activity> nouv = new ArrayList<>();
				successeurs.put(i,nouv);
			}
			
			for (PrecedenceConstraint c:constraints){
				nbPredecesseurs.put(c.getSecond(),nbPredecesseurs.get(c.getSecond())+1);
				ArrayList<Activity> nouv = successeurs.get(c.getFirst());
				nouv.add(c.getSecond());
				successeurs.put(c.getFirst(),nouv);
			}
			
			ArrayList<Activity> L =  new ArrayList<>();
			ArrayList<Activity> res = new ArrayList<>();
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
