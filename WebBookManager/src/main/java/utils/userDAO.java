package utils;

import java.sql.*;
public class userDAO {
  private static final String DB_URL = "jdbc:sqlite:BookManager.db";

  //新規登録
  static public void insert(userBean user) {
    String sql = "INSERT INTO users VALUES (?, ?, ?)";

    String salt = GenerateHash.getSalt();
    String hashedPw = GenerateHash.getHashPw(user.getPw(), salt);

    try (
            Connection con = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = con.prepareStatement(sql);
    ) {
      pstmt.setInt(1, user.getId());
      pstmt.setString(2, user.getName());
      pstmt.setString(3, hashedPw);

      pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  //ユーザー情報を取得
  static public userBean selectById(int id) {
    String sql = "SELECT * FROM users WHERE id = ?";
    userBean result = null;

    try (
            Connection con = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = con.prepareStatement(sql);
    ) {
      pstmt.setInt(1, id);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          result = new userBean(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("pw")
          );
        }
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return result;
  }
  static public void update(userBean user){
    String sql = "UPDATE users SET name = ?, pw = ? WHERE id = ?";

    String salt = GenerateHash.getSalt();
    String hashedPw = GenerateHash.getHashPw(user.getPw(),salt);

    try (
            Connection con = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = con.prepareStatement(sql);
    ){
      pstmt.setString(1, user.getName());
      pstmt.setString(2, hashedPw);
      pstmt.setInt(3, user.getId());


      pstmt.executeUpdate();

    }catch (SQLException e){
      throw new RuntimeException(e);
    }
  }

}


