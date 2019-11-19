package Lesson_2;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static boolean logout = true;

    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://mysql.kek.local:3306";
    private static final String DATABASE = "kek";
    private static final String USER = "kek";
    private static final String PASSWORD = "keker";
    private static final String TABLENAME = "PRICE";
    private static final int allProduct = 10_000;

    private static final Scanner scanner = new Scanner(System.in);
    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args) throws SQLException {
        try {
            connection();
            catalogDrop();
            tableCreator();
            catalogGenerator(allProduct);
            if (logout) System.out.println ("Можно начинать работать!");
            while (true) {
                String command = scanner.nextLine ();
                String[] tokens = command.split (" ");
                if (command.isEmpty ()) continue;
                if (command.equals ("exit")) break;
                if (command.equals ("help")) {
                    helpMenu ();
                }else if (command.startsWith("logout ")) {
                    if (tokens.length != 2) {
                        if (logout) System.err.println ("Формат команды не верный.");
                        continue;
                    }
                    if (tokens[1].equals ("true")){
                        logout = true;
                        System.err.println("logout true!");
                    }else{
                        logout = false;
                        System.err.println("logout false!");

                    }
                }else if (command.startsWith("price ")) {
                    if (tokens.length != 2) {
                        if (logout) System.err.println("Формат команды не верный.");
                        continue;
                    }
                    searchPrice (tokens[1]);
                } else if (command.startsWith("changeprice ")) {
                    if (tokens.length != 3) {
                        if (logout) System.err.println("Формат команды не верный.");
                        continue;
                    }
                    changePrice(tokens[1], Double.parseDouble(tokens[2]));
                } else if (command.startsWith("searchrangeprice ")) {
                    if (tokens.length != 3) {
                        if (logout) System.err.println("Формат команды не верный.");
                        continue;
                    }
                    searchRangePrice(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                } else {
                    System.err.println("Не удалось распознать команду. Воспользуйтесь командой \"help\".");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                scanner.close();
                disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void connection() throws ClassNotFoundException, SQLException {
        if (logout) System.out.println("Registering JDBC driver...");
        Class.forName(DRIVERNAME);

        if (logout) System.out.println("Connecting to DB...");
        conn = DriverManager.getConnection(URL + "/" + DATABASE, USER, PASSWORD);
        stmt = conn.createStatement();
    }

    public static void disconnect() throws SQLException {
        if (logout) System.out.println("Disconnect DB.");
        conn.close();
    }

    public static void tableCreator() throws SQLException {
        if (logout) System.out.print("CREATE TABLE...\n");
        String myTableName = ("create TABLE " + TABLENAME + " (" +
                "id int(3) not null auto_increment primary KEY, " +
                "name VARCHAR(255) NULL DEFAULT NULL, " +
                "price DOUBLE UNSIGNED NULL DEFAULT NULL" +
                ");");
        try{
            stmt.executeUpdate(myTableName);
            if (logout) System.out.println("Table Created!\n");
        }
        catch (SQLException e ) {
            if (logout) System.err.println("An error has occurred on Table Creation: " + e);
        }

    }

    public static void catalogGenerator(int product) throws SQLException {
        if (product == 0 || product < 0) return;
        if (logout) System.out.print("GENERATED TABLE...\n");
        try{
        conn.setAutoCommit(false);
        for (int i = 0; i < product; i++) {
            int rnd = rnd(10, 20000);
            stmt.addBatch("INSERT  INTO PRICE (name, price) VALUES ('Product_id_" + i + "', " + rnd + ")");
        }
        stmt.executeBatch();
        conn.setAutoCommit(true);
            if (logout) System.out.print("Table Created!\n");
        }
            catch (SQLException e ) {
                if (logout) System.out.println("An error has occurred on Table Creation: " + e);
        }
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static void catalogDrop() throws SQLException {
        if (logout) System.out.print("DROP TABLE...\n");
        try{
        stmt.executeUpdate("DROP TABLE " + TABLENAME);
        }
        catch (SQLException e ) {
            System.out.println("An error has occurred on Table Creation: " + e);
        }
        if (logout) System.out.println("Table drop\n");
    }

    public static void searchPrice(String name) throws SQLException {
        Product product = getProductByName(name);
        if (product == null) {
            if (logout) System.err.println("Такого товара нет.");
            return;
        }
        product.showInfo();
    }

    public static void changePrice(String name, double newPrice) throws SQLException {
        Product product = getProductByName(name);
        if (product == null) {
            if (logout) System.err.println("Такого товара нет.");
            return;
        }
        if (newPrice <= 0) {
            if (logout) System.err.println("Цена на товар должна быть не равна нулю.");
            return;
        }
        if (product.getPrice() == newPrice) {
            if (logout) System.err.println("Цена на товар \"" + product.getName() + "\" уже равна " + newPrice);
            return;
        }
        stmt.executeUpdate("UPDATE " + TABLENAME + " SET price = " + newPrice + " WHERE name = '" + name + "';");
        if (logout) System.out.println("Цена для товара \"" + name + "\" изменена с " + product.getPrice() + " на " + newPrice);
    }

    public static void searchRangePrice(double start, double end) throws SQLException {
        System.out.println (start);
        System.out.println (end);
//        ResultSet result = stmt.executeQuery("SELECT * FROM " + TABLENAME + " WHERE price BETWEEN " + start + " AND " + end +";");
        ResultSet result = stmt.executeQuery(String.format("SELECT * FROM %s WHERE price BETWEEN %g AND %g;", TABLENAME, start, end));

        int count = 0;
        while (result.next()) {
            count++;
            Product product  = new Product(result.getString(2), result.getInt(3));
            product.showInfo();
        }
        if (count == 0) System.err.println ("Нет результатов поиска.");;
    }

    private static Product getProductByName(String name) throws SQLException {
        ResultSet result = stmt.executeQuery(String.format("SELECT * FROM %s WHERE name = '%s'", TABLENAME, name));
        if (result.next()) {
            return new Product(result.getString(2), result.getInt(3));
        }
        return null;
    }

    public static void helpMenu(){
        System.out.println ("price <имя товара> - узнать цену товара.\n" +
                "changeprice <имя товара> <новая цена> - изменить цену товара.\n" +
                "searchrangeprice <цена> <цена> - вывести товары в заданном ценовом диапазоне.\n" +
                "logout <true/false> - вывод логов процесса.\n" +
                "exit - Выход." +
                "help - Вывод этого меню.");
    }
}