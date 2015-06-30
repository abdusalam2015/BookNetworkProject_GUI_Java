package booknetworkproject;
public class Group {

	Book[] Books;
	User[] users;
	Post[] Posts;
	GroupScreen[] Screen;
	static String name,admin;
	static String [] members;
	
	public static void setname (String name){}
	public static String getname (){
		return name;}
	public static void setadmin (String admin){}
	public static String getadmin (){
		return admin;}
	public static void setmembers (String [] members){}
	public static String [] getmembers (){
		return members;}
}
