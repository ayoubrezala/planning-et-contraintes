package schedules.activities;

public class Activity {
	public String  description;
        public int duration; 
	
	public Activity(String description, int duration){
		this.description = description;
		this.duration = duration;
		
	}
	public String getDescription(){
	return this.description;

	}
	public int getDuration(){
	return this.duration;

	}
	
	@Override
	public String toString(){
	return this.description  + "(" + this.duration + ")";
	}

	
} 
