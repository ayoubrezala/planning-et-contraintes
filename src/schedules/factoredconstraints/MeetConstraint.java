package schedules.factoredconstraints;
import schedules.activities.Activity;

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
}