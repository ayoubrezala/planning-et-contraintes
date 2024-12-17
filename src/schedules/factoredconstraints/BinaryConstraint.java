package schedules.factoredconstraints;
import schedules.activities.Activity;

public abstract class BinaryConstraint{
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
}
