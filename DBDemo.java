public class DBDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://101.34.47.44:3306/Study", "jsp", "jsp123");
        System.out.println(conn);
    }
}
