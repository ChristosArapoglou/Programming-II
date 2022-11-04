import java.sql.Date;

class Post {
	
	public Date creation_date;
	public int likes = 0;
	public String text;
	public User creator;
	
	public Post(Date creation_date, String text, User creator) {
		super();
		this.creation_date = creation_date;
		this.text = text;
		this.creator = creator;
	}
	
	public String create_Post() {
		return "User " +creator.getUser_name()+ " has posted: " +text+ "." + " Posted at: " +creation_date;
	}
	public void display_Post() {
		System.out.println(this.create_Post());
	}
	public void react() {
		this.likes++;
	}
	
}


