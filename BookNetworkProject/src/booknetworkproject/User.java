package booknetworkproject;

import static booknetworkproject.Database.stmt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

    Book[] Books;
    Post[] Posts;
    UserScreen Screen;
    Profile Profile;
    public Database obj;//= new Database();

    public User() {
        try {
            obj = new Database();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    static String username, password, email;
    //GUIBookNetwork objj =new GUIBookNetwork();

    public static void setUserName(String username) {
    }

    public static String getUserName() {
        return username;
    }

    public static void setpassword(String password) {
    }

    public static String getpassword() {
        return password;
    }

    public static void setemail(String email) {
    }

    public static String getemail() {
        return email;
    }

    public static void addReview(String BookName, String username, String Review) throws SQLException {

        stmt.execute("insert into review (bookName, userName, review)"
                + " values ('" + BookName + "' ,'" + username + "' ,'" + Review + "' )");

//        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
//        JOptionPane.showMessageDialog(frame, "Review Added Successfuly !");
        //Compiler.disable();
    }

    public void viewBooks() {
        String name = "";
        try {

            String sql2 = "select * from book ";
            ResultSet rs = stmt.executeQuery(sql2);

            while (rs.next()) {
                //name , author ,category ,review ,rate
                name +=   rs.getString(1) + "\n";
                // System.out.println(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame, "Books: \n"+name);

    }

    public void viewBook(String BookName) throws SQLException {

        String sql2 = "select   *  from  book where name = '" + BookName + "' "; //review ordered by ,  average rate 
//         String sql3 = "select * from review where bookName = '"+BookName+"'  "
//                + " GROUP BY bookName ORDER BY review DESC";

        String name = "", name2 = "";
        ResultSet rs = stmt.executeQuery(sql2);
        System.out.println("after");
        boolean check = false;
        while (rs.next()) {
            name = "Book Name: " + rs.getString(1) + "\nAuthor :" + rs.getString(2) + "\nCategory " + rs.getString(3)
                    + "\nReview :" + rs.getString(4) + "\nRate :" + rs.getString(5);
        }
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame, name + name2);
        // ResultSet rs2 = stmt.executeQuery(sql3);
    }

    // stmt.execute("create table  favorites ( bookName VARCHAR(50) , authorName  VARCHAR(50) ) ");
    public void AddFavorites(String bookName, String authorName) {
        try {
            stmt.execute(" INSERT INTO favorites (bookName ,authorName ) VALUES ( '" + bookName + "' ,'" + authorName + "' )");
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame, " Successfuly !");

    }

    public void AddBook(String name, String author, String category, String review, int rate, String state, String shelve) throws SQLException {
        //Connection conn = null;
        //Statement stmt = null;
        //  conn = DriverManager.getConnection(DB_URL3, USER, PASS);
        // stmt = conn.createStatement();
        //System.out.println("bbbb");
        stmt.execute(" INSERT INTO book (name ,author ,category ,review , rate , bookState , shelveName)"
                + " VALUES ('" + name + "' ,'" + author + "' ,'" + category + "' ,'" + review + "' ,'" + rate + "' ,'"
                + state + "' , '" + shelve + "' )");

        //stmt.executeQuery(sql2);
        //System.out.println("aftrer");
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame, "Book Added Successfuly !");

    }

    public static void AddShelve(String ShelveName) {
    }

    public static void SearchForBook(String BookName) throws SQLException {
        String name = "", output = "";
        boolean check = false;
        String sql2 = "select   *  from book  where name like '" + BookName + "'";
        ResultSet rs = stmt.executeQuery(sql2);
        while (rs.next()) {
            name = rs.getString(1);
            output = "Book Name : " + rs.getString(1) + "\nAuthor : " + rs.getString(2) + "\n "
                    + "Category : " + rs.getString(3) + "\nReview : " + rs.getString(4) + "\nRate : " + rs.getString(5);
            System.out.println(name);
            if (rs.getString(1).compareTo(BookName) == 0) {
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, output);
                // System.exit(0);
                check = true;
                break;
            }
        }
        if (!check) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "This Book Not Exist !");
            // System.exit(0);
        }
    }

    public static void reviewBook(String BookName, String username, String Review) throws SQLException {
		//Connection conn = null;

        // Statement stmt = null;
        //obj.conn = DriverManager.getConnection(DB_URL2, USER, PASS);
        //  stmt = obj.conn.createStatement();
        String sql2 = "Insert into ReviewDB (BookName, username, Review)"
                + " Values (" + BookName + " ," + username + " ," + Review + ")";

        if (stmt.executeQuery(sql2) != null) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Review Added Successfuly !");
        } else {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Review not Added !");
        }

    }

    public void GreatGroup(String groupname, String admin) throws ClassNotFoundException, SQLException {
        //name VARCHAR(50) , adminName VARCHAR(50) , memmbers VARCHAR(50)

        stmt.execute("INSERT INTO Tgroup (name , adminName , memmbers )  "
                + "VALUES (  '" + groupname + "' , '" + admin + "' , '')");
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame, "Group Created  Successfuly ");
        // new GUICreatGroup().setVisible(false);

    }

    public void addFriend(String friendName) throws SQLException {
        stmt.execute("INSERT INTO friends (name) "
                + "VALUES (  '" + friendName + "' )");

        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame, "Friend Added Successfuly ");

//           ALTER TABLE<table name>
//ADD <column name> <data type>
        //System.out.println("gggg");
//            String sql2 = "select   *  from  friends "; //review ordered by , average rate 
//            String name="";
//        ResultSet rs = stmt.executeQuery(sql2);
//        boolean check = false;
//        while (rs.next()) {
//            name = rs.getString(1);
//            System.out.println(name);
//            
//        }
//        
    }

}
