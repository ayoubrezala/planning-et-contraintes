package schedules.basicconstraints;
import schedules.activities.Activity;
//import schedules.basicconstraints.PrecedenceConstraint;

public class Demo{

	public static void main(String[] args){
		//Precedence Constraint
		Activity act1 = new Activity("Aller à l'université", 15);
		Activity act2 = new Activity("Attacher le vélo", 1);
		PrecedenceConstraint precedenceC = new PrecedenceConstraint(act1, act2);
		MeetConstraint meetC = new MeetConstraint(act1, act2);
		PrecedenceConstraintWithGap precedenceG = new PrecedenceConstraintWithGap(act1, act2, 5, 10);
		
		//Tests sur les contraintes
		System.out.println("Contrainte de Précédence : ");
		System.out.println(precedenceC.isSatisfied(0, 20) +  " Pour timeAct1 = 0 et timeAct2 = 20, la contrainte est bien satisfaite");
		System.out.println("=====================================================");
		System.out.println(precedenceC.isSatisfied(0, 14) + " Pour timeAct1 = 0 et timeAct2 = 14, la contrainte n'est pas satisfaite");

		System.out.println("Contrainte concourantes : ");
		System.out.println(meetC.isSatisfied(0, 15) + " Pour timeAct1 = 0 et timeAct2 = 15, la contrainte est bien satisfaite");
		System.out.println("=====================================================");
		System.out.println(meetC.isSatisfied(0, 16) +  " Pour timeAct1 = 0 et timeAct2 = 16, la contrainte n'est pas satisfaite");

		System.out.println("Contrainte avec Délai : ");
		System.out.println(precedenceG.isSatisfied(0, 20) + " Pour timeAct1 = 0 et timeAct2 = 20, la contrainte est bien satisfaite");
		System.out.println("=====================================================");
		System.out.println(precedenceG.isSatisfied(0, 31) + " Pour timeAct1 = 0 et timeAct2 = 31, la contrainte n'est pas satisfaite");
		
		
	}
}
