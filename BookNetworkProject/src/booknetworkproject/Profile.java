package booknetworkproject;

import static booknetworkproject.Database.stmt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Profile {

	Book[] Books;
	User user;
	ProfileScreen Screen;
	static int shelveSize;
	static String shelveName;
	static String []FavoriteBook,CurrentlyReading,FavoriteAuthors,FavoriteGenres;
        public Database database ;//= new Database();

    public Profile() {
            try {
                database=new Database();
            } catch (SQLException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
	
	public static void setShaveName (String shelveName){}
	public static String gettShaveName (){
		return shelveName;}
	public static void setShelveSize (int shelveSize){}
	public static int getShelveSize (){
		return shelveSize;}
	public static void setFavoriteBook (String [] FavoriteBook){}
	public static String [] getFavoriteBook (){
		return FavoriteBook;}
	public static void setCurrentlyReading (String [] CurrentlyReading){}
	public static String [] getCurrentlyReading (){
		return CurrentlyReading;}
	public static void setFavoriteAuthors (String [] FavoriteAuthors){}
	public static String [] getFavoriteAuthors (){
		return FavoriteAuthors;}
	public static void setFavoriteGenres (String [] FavoriteGenres){}
	public static String [] getFavoriteGenres (){
		return FavoriteGenres;}
        public void viewProfile () throws SQLException{
            //select 
          //  System.out.println(" begin  fun  ");
            String sql2 = "select   *  from  profile  "; //review ordered by , average rate 
            String name="";
        ResultSet rs = stmt.executeQuery(sql2);
        boolean check = false;
            System.out.println(" inter  fun1 ");
        while (rs.next()) {
            System.out.println(" inter  fun2 ");
            name ="Name :"+ rs.getString(1) +"\nGender :"+rs.getString(2)+"\nDate Of Birth:"+rs.getString(3)+
                    "\nSchool :"+rs.getString(4)+"\nCollage"+rs.getString(5);
            
           // JOptionPane.showInternalInputDialog(frame, frame, name, shelveSize, null, FavoriteGenres, shelveSize);
        
           // System.out.println(name);
            
        }
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame,name);
            
            
        }
        
         public void updateProfile (String name , String gender , String date , String school , String collage) throws SQLException{
            // System.out.println("befor");
             stmt.execute("UPDATE profile SET name = '"+name+"' , gender = '"+gender+"'  , dataOfBirth = '"+date+"' , "
                     + " school  =  '"+school+"',  coloage = '"+collage+"' ");
             System.out.println("after");
              JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame,"Updated Successfully ");
            
        }

	
}
