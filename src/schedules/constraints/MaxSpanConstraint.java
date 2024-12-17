package schedules.constraints;
import schedules.activities.Activity;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class MaxSpanConstraint implements Constraint {
    public Set<Activity> activities;
    public int activitiesDuration;
    

    public MaxSpanConstraint(Set<Activity> activities, int activitiesDuration){
        this.activities = activities;
        this.activitiesDuration = activitiesDuration;
        
    }

    public Set<Activity> getActivities(){
        
        return new HashSet<> (activities);
	}


    
     public boolean isSatisfied(Map<Activity, Integer> coupleActivityDate) {
        if (this.activities.isEmpty()) {
            return true;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Activity activity : this.activities) {
            if (coupleActivityDate.containsKey(activity)) {
                min = Math.min(min, coupleActivityDate.get(activity));
                max = Math.max(max, coupleActivityDate.get(activity) + activity.getDuration());
            }
        }

        return max - min <= this.activitiesDuration;
    }

   
}