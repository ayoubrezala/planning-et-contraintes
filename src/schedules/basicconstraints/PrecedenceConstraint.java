package schedules.basicconstraints;
import schedules.activities.Activity;

public class PrecedenceConstraint{
	public Activity activity1;
	public Activity activity2;

	public PrecedenceConstraint(Activity activity1, Activity activity2){
		this.activity1 = activity1;
		this.activity2 = activity2;
	}

	public Activity getFirst(){
		return this.activity1;
	}

	public Activity getSecond(){ 
                return this.activity2;
        }

	public boolean isSatisfied(int timeAct1, int timeAct2){
		return getFirst().getDuration() + timeAct1  <= timeAct2;
	}
}
