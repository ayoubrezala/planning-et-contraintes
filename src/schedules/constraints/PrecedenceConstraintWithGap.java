package schedules.constraints;
import schedules.activities.Activity;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
    public Activity firstAct; 
    public Activity secondAct;
    int minDelay;
    int maxDelay;

    public PrecedenceConstraintWithGap(Activity firstAct, Activity secondAct, int minDelay, int maxDelay){
        super(firstAct, secondAct);
        this.minDelay = minDelay;
        this.maxDelay = maxDelay;
    }

    @Override 
    public boolean isSatisfied(int timeAct1, int timeAct2){
        return (timeAct2 >=this.getFirst().getDuration() + timeAct1 + minDelay ) && (this.getFirst().getDuration() + timeAct1 + maxDelay >= timeAct2);

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
