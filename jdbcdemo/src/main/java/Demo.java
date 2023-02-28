import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String query = "select * from ebookshop.books where qty < 30";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                System.out.println(rs.getInt("id")+", "
                + rs.getString("title")+" ,"
                + rs.getString("author")+","
                + rs.getFloat("price")+","
                + rs.getInt("qty"));
            }
        
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
