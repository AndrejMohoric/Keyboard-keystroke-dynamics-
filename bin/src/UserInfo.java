//USER INFO

public class UserInfo {

	public  String gender; 
	public  String userBirthYear;
	public  String userShoolLevel; 
	public  String userLivingPlace; 
	public  String userSpendTimeOnPC; 
	public  String userBlindTyping; 
	public  String userNumHands; 
	public  String userHandOrientation; 
	public  String userAng; 

			
	public  UserInfo(String gender, String userBirthYear, String userShoolLevel, String userLivingPlace, String userSpendTimeOnPC, String userBlindTyping, String userNumHands,String userHandOrientation, String userAng) {
		this.gender = gender;
		this.userBirthYear = userBirthYear;
		this.userShoolLevel = userShoolLevel;
		this.userLivingPlace = userLivingPlace;
		this.userSpendTimeOnPC = userSpendTimeOnPC;
		this.userBlindTyping  = userBlindTyping;
		this.userNumHands = userNumHands;
		this.userHandOrientation  = userHandOrientation;
		this.userAng = userAng;
	}
	
	public String getUserGender() {return this.gender;}
	public String userBlindTyping() {return this.userBirthYear;}
	public String getUserShoolLevel() {return this.userShoolLevel;}
	public String getUserLivingPlace() {return this.userLivingPlace;}
	public String getUserSpendTimeOnPC() {return this.userSpendTimeOnPC;}
	public String getUserBlindTyping() {return this.userBlindTyping;}
	public String getUserNumHands() {return this.userNumHands;}
	public String getUserHandOrientation() {return this.userHandOrientation;}
	public String getUserAng() {return this.userAng;}
}
