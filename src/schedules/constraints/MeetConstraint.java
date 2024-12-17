package schedules.constraints;
import schedules.activities.Activity;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class MeetConstraint extends BinaryConstraint{
	public Activity activity1;
	public Activity activity2;

	public MeetConstraint(Activity activity1, Activity activity2){
		super(activity1, activity2);
		this.activity1 = activity1;
		this.activity2 = activity2;
	}

	
	public Activity getFirst(){
		return this.activity1;
	}

	public Activity getSecond(){ 
                return this.activity2;
        }

	

	@Override
	public boolean isSatisfied(int timeAct1, int timeAct2){
		return timeAct1 + getFirst().getDuration() == timeAct2;
	}


	@Override
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
}