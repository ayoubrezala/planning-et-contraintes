package schedules.constraints;
import schedules.activities.Activity;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public interface Constraint{
    public Set<Activity> getActivities();
    public boolean isSatisfied(Map<Activity, Integer> activities);
}