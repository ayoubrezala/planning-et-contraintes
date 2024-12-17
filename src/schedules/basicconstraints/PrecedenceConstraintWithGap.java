package schedules.basicconstraints;
import schedules.activities.Activity;

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
        return (timeAct2 >= this.getFirst().getDuration() + timeAct1 + minDelay ) && (this.getFirst().getDuration() + timeAct1 + maxDelay >= timeAct2);

    } 


}
