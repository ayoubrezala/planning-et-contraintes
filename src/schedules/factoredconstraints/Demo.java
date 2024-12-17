package schedules.factoredconstraints;
import schedules.activities.Activity;
//import schedules.basicconstraints.PrecedenceConstraint;

public class Demo{

	public static void main(String[] args){
		Activity act1 = new Activity("Dormir", 60);
		Activity act2 = new Activity("Manger", 260);
		PrecedenceConstraintWithGap contrainte; 
		contrainte= new PrecedenceConstraintWithGap(act1, act2, 0, 1);
		MeetConstraint meetCont = new MeetConstraint(act1, act2);
		System.out.println("La contrainte avec délai n'est pas satisfaite pour des durées de 0 et 65");
		System.out.println(contrainte.isSatisfied(0,65)); 
	}
}
