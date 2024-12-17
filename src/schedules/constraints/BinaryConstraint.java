package schedules.constraints;
import schedules.activities.Activity;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public abstract class BinaryConstraint implements Constraint{
	public Activity activity1;
	public Activity activity2;

	public BinaryConstraint(Activity activity1, Activity activity2){
		this.activity1 = activity1;
		this.activity2 = activity2;
	}

	public Activity getFirst(){
		return this.activity1;
	}

	public Activity getSecond(){ 
                return this.activity2;
        }

	public abstract boolean isSatisfied(int timeAct1, int timeAct2);
    public boolean isSatisfied(Map<Activity, Integer> activities){
		//HashSet setActivities = this.getActivities();
		for (HashMap.Entry<Activity, Integer> act1 : activities.entrySet()){
			for (HashMap.Entry<Activity, Integer> act2 : activities.entrySet()){
				if (this.getFirst() == act1.getKey() && this.getSecond() == act2.getKey()){
					if (this.isSatisfied(act1.getValue(), act2.getValue()) == true){
						return true;
					}

				

				}
			}
		}

		return false;
		
	}

	public HashSet<Activity> getActivities(){
		HashSet<Activity> activities = new HashSet<>();
		activities.add(this.activity1);
		activities.add(this.activity2);

		return activities;
	}
}
