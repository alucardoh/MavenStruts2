/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.maven.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author rodrigo
 */
public class UploadAction extends ActionSupport {

    private String nombre, ext, size, archivo, user, name, delete;

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    ArrayList<BeanArchivo> list = new ArrayList<BeanArchivo>();

    public ArrayList<BeanArchivo> getList() {
        return list;
    }

    public void setList(ArrayList<BeanArchivo> list) {
        this.list = list;
    }

//setters and getters  
    public String execute() {
        int i = UploadDao.save(this);;

        Desplegar();

        if (i > 0) {
            return "success";
        }

        return "error";
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
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

}
