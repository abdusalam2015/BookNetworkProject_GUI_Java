package booknetworkproject;

/**
 * @author Abdussalam AbduHelal
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BookNetwork {

    Database obj;

    public BookNetwork() throws ClassNotFoundException, SQLException {
        this.obj = new Database();
    }

    public void signIn(String email, String password) throws ClassNotFoundException, SQLException {
        String name = "";
        boolean check = false;
        String sql2 = "select   *  from users   where emails like '" + email + "' and passwords like '" + password + "' ";
        ResultSet rs = obj.stmt.executeQuery(sql2);
        while (rs.next()) {
            name = rs.getString(1);
          //  System.out.println(name);
            if (rs.getString(1).compareTo(email) == 0 ) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new HomePage().setVisible(true);
                    }
                });
                check = true;
                break;
            }
        }
        if (!check) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Not Exist You must  Sign Up First");

        }
    }

    public void signUp(String email, String password) throws ClassNotFoundException, SQLException {

        String name = "";
        String sql2 = "select   *  from users   where emails like '" + email + "' ";
        ResultSet rs = obj.stmt.executeQuery(sql2);
        boolean check = false;
        while (rs.next()) {
            name = rs.getString(1);
            if (rs.getString(1).compareTo(email) == 0) {
                check = true;
                break;
            }
        }

        if (check) {
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "This email is eleardy exist");

        } else {
            try {
                obj.stmt = obj.conn.createStatement();
                obj.stmt.execute("INSERT INTO users (emails , passwords) "
                        + "VALUES ('" + email + "' ,'" + password + "' )");
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Success SignUp");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    obj.stmt.close();
                    obj.conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
