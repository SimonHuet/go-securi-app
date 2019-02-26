package DAL;

import Model.ConfigBdd;
import Model.user;

import java.sql.*;

public class UserDAL {

    public user selectByFaceId(String faceId){
        String sql = "SELECT * FROM User where FaceId = ? ";

        try {
            Connection conn = ConfigBdd.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             pstmt.setString(1,faceId);
             ResultSet rs = pstmt.executeQuery(sql);
             user user = null;
             while (rs.next()){
                user =  createUser(rs);
             }
                return user;
        } catch (SQLException e) {
            throw new Error(e.getMessage());
        }
    }

    private user createUser(ResultSet rs){
        try{
            user user = new user();
            user.setFaceId(rs.getString("FaceId"));
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            user.setDeleted(rs.getBoolean("Deleted"));
            return  user;
        } catch (SQLException e){
            throw new Error(e.getMessage());
        }
    }
}
