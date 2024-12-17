package schedules.constraints;
import schedules.activities.Activity;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class UnaryConstraint implements Constraint {
    public Activity activity;
    public int t1;
    public int t2;

    public UnaryConstraint(Activity activity, int t1, int t2){
        this.activity = activity;
        this.t1 = t1;
        this.t2 = t2;
    }

    public Set<Activity> getActivities(){
        HashSet<Activity>  activities = new HashSet<> ();
		activities.add(this.activity);
        return activities;
	}

    public Activity getActivity(){
        return this.activity;
    }

    public boolean isSatisfied(int start){
        return (start >= this.t1) && (start <= this.t2);
    }

	@Override
    public boolean isSatisfied(Map<Activity, Integer> activities){
		//HashSet setActivities = this.getActivities();
		for (HashMap.Entry<Activity, Integer> act : activities.entrySet()){
			if (this.getActivity() == act.getKey()){
				if (this.isSatisfied(act.getValue()) == true){
						return true;
				}

			}
			
		}

		return false;
		
	}
}