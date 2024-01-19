package utils;
import java.sql.*;
import java.util.ArrayList;
public class bookDAO {
    private static final String DB_URL = "jdbc:sqlite:BookManager.db";
    //登録
    static public void insert(String isbn, int user_id) {
        String sql = "INSERT INTO books VALUES (?,?)";
        try (
                Connection con = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1,isbn);
            pstmt.setInt(2,user_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //全件検索
    static public ArrayList<String> select(int user_id) {
        String sql = "SELECT isbn FROM books WHERE user_id = ?";
        ArrayList<String> result = new ArrayList<>();

        try (
                Connection con = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = con.prepareStatement(sql);

        ) {
            pstmt.setInt(1, user_id);
            try (ResultSet rs = pstmt.executeQuery()){


            while (rs.next()) {
                result.add(rs.getString("isbn"));
            }
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    //削除
    static public void delete(String isbn) {
        String sql = "DELETE FROM books WHERE isbn = ?";
        try (
                Connection con = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setString(1,isbn);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //サインアウト
    static public void Signout(int user_id) {
        String sql = "DELETE FROM books WHERE user_id = ?";
        try (
                Connection con = DriverManager.getConnection(DB_URL);
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}