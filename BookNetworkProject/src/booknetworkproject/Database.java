package booknetworkproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

//    public Book[] books;
//   public  User[] users;
//    public Profile[] profiles;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/SoftWareDB";//database name
    static final String USER = "root";
    static final String PASS = "root";

    public Connection conn = null;
    public  static  Statement stmt = null;
    boolean check = false;
    public static void AddToDatabase(User[] u, Profile[] p, Book[] book) {
   }

    public Database() throws SQLException{
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //stmt = conn.createStatement();
//            stmt.execute("INSERT INTO book (name , author ,category ,review ,rate ) "
//                        + "VALUES (  'Network' , 'Kamal Al-Housam' , 'internetWorking'  , 'poor' , 5)");
//            stmt.execute("INSERT INTO book (name , author ,category ,review ,rate ) "
//                        + "VALUES (  'Math' , 'Hamed' , 'Mathmetices'  , 'good' , 4)");
//            stmt.execute("INSERT INTO book (name , author ,category ,review ,rate ) "
//                        + "VALUES (  'Ipv32' , 'Abdussalam' , 'IT'  , 'poor' , 5)");
//            stmt.execute("INSERT INTO book (name , author ,category ,review ,rate ) "
//                        + "VALUES (  'Java11' , 'Kamal Al-Housam' , 'programming'  , 'exclant'  , 5)");    
         
           //stmt.execute(" ALTER TABLE book ADD shelveName  VARCHAR(50)");
//          stmt.execute("create table  profile  (name VARCHAR(50) , gender VARCHAR(50) , dateOfBirth VARCHAR(50),"
//                    + " school VARCHAR(50) ,  coloage VARCHAR(50) )");
              //System.out.println("is here !");
               // System.out.println("exe");
            
           //  stmt.execute("create table  group  ( name VARCHAR(40) , adminName VARCHAR (40) ) ");
             
                     //System.out.println("is here !");
             }catch (Exception e){
                System.out.println("is cdd !");
             }
         //BookName,String username,String Review
         // stmt.execute("create table  review ( bookName VARCHAR(50) , userName  VARCHAR(50) , review  VARCHAR(50)) ");
           //stmt.executeUpdate(table);
          // System.out.println("Is createsd");
      //   stmt.execute("create table  profile  (name VARCHAR(50) , admainName VARCHAR(50) , memmberes VARCHAR(50) ");
         // stmt.execute(" create table  group(name VARCHAR(50) , adminName VARCHAR(50) , memmbers VARCHAR(50))");
            //System.out.println("is here !");
//            String sql2 = "select   *  from  book ";
//            String name="";
//        ResultSet rs = stmt.executeQuery(sql2);
//        boolean check = false;
//        while (rs.next()) {
//            name = rs.getString(1)+"    "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"     "+rs.getString(5);
//            System.out.println(name);
//            
//        }
        }
    public static void DeleteFromDatabase(User u) {
    }
}
