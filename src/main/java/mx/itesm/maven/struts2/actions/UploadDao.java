/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.maven.struts2.actions;

import java.sql.*;

public class UploadDao {

    public static int save(UploadAction r) {
        int status = 0;
        try {
            String URL = "jdbc:mysql://localhost/struts_tutorial";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, "root", "");
            PreparedStatement ps = con.prepareStatement("insert into archivos values(?,?,?,?,?)");
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getExt());
            ps.setString(3, r.getSize());
            ps.setString(4, r.getArchivo());
            ps.setString(5, r.getUser());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}

