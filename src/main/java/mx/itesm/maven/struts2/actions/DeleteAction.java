/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.maven.struts2.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

/**
 *
 * @author rodrigo
 */
public class DeleteAction extends ActionSupport {

    private String user, name, delete;
    
    ArrayList<BeanArchivo> list = new ArrayList<BeanArchivo>();

    public ArrayList<BeanArchivo> getList() {
        return list;
    }

    public void setList(ArrayList<BeanArchivo> list) {
        this.list = list;
    }

    public DeleteAction() {
    }

    public String execute() {
        
        try {
            String URL = "jdbc:mysql://localhost/struts_tutorial";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, "root", "");
            PreparedStatement ps = con.prepareStatement("delete from archivos where user='" + user
                    + "' and nombre = '" + delete + "'");
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Desplegar();
            return ERROR;
        }
        Desplegar();
        return SUCCESS;
    }

    void Desplegar() {
        try {
            String URL = "jdbc:mysql://localhost/struts_tutorial";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, "root", "");

            PreparedStatement ps = con.prepareStatement("select * from archivos where user='" + user + "'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BeanArchivo archivo = new BeanArchivo();
                archivo.setNombre(rs.getString(1));
                archivo.setExt(rs.getString(2));
                archivo.setSize(rs.getString(3));
                archivo.setArchivo(rs.getString(4));
                archivo.setUser(rs.getString(5));
                list.add(archivo);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

}
