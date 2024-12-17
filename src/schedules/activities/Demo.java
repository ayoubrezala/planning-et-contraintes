package schedules.activities;
/*javac -d ../build/ schedules/activities/Demo.java
java -cp ../build/ schedules.activities.Demo
*/

public class Demo{

	public static void main (String[] args){
		/*Création des deux activités*/
		Activity act1 = new Activity("Dormir", 60);
		Activity act2 = new Activity("Manger", 200);
		System.out.println("Activité 1 : " + act1.getDescription() + " pendant " + act1.getDuration()); 
		System.out.println("Activité 2 : " + act2.getDescription() + " pendant " + act2.getDuration()); 
		
	}
}
