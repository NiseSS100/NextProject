import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    public static Connection conn = null;
    static String useThis;
    public static Connection getConnection() {
        //C:\Users\Niki\Desktop\salonDB//
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/" + useThis, "sa", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return conn;
        }
    }
    public static void LoadConfig(){
        ArrayList<String> server = null ;
        try {
        Path toFile = Paths.get("D:\\Uni\\Практикум\\Salon\\config.txt");
            server =(ArrayList<String>) Files.readAllLines(toFile);
            useThis = server.get(0).replace("database=", "").replace(";", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(useThis);
    }
}