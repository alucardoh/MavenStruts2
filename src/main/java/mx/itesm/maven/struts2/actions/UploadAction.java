/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.maven.struts2.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author rodrigo
 */
public class UploadAction extends ActionSupport {

    private String nombre, ext, size, archivo, user;

//setters and getters  
    public String execute() {
        int i = UploadDao.save(this);
        if (i > 0) {
            return "success";
        }
        return "error";
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

    

}
