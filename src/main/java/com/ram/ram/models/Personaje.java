package com.ram.ram.models;

import javax.persistence.*;

@Entity
@Table(name="personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String p1;
    private String p2;
    private String imgprincipal;
    private String img1;
    private String img2;
    private String img3;

    public Personaje(){

    }

        public Personaje(String nombre, String p1, String p2, String imgprincipal, String img1, String img2, String img3) {
            this.nombre = nombre;
            this.p1 = p1;
            this.p2 = p2;
            this.imgprincipal = imgprincipal;
            this.img1 = img1;
            this.img2 = img2;
            this.img3 = img3;
        }

    // constructores, getters y setters
    @Override
    public String toString() {
        return "Personaje{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                ", imgprincipal='" + imgprincipal + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", img3='" + img3 + '\'' +
                '}';
    }


    public String getImg1() {return img1;}
//
//    public void setImg1(String img1) {
//        this.img1 = img1;
//    }
//
    public String getImg2() {
        return img2;
    }
//
//    public void setImg2(String img2) {
//        this.img2 = img2;
//    }
//
    public String getImg3() {
        return img3;
    }
//
//    public void setImg3(String img3) {
//        this.img3 = img3;
//    }
//
public long getId() {
    return id;
}
    public String getImgprincipal() {
        return imgprincipal;
    }
//
//    public void setImgprincipal(String imgprincipal) {
//        this.imgprincipal = imgprincipal;
//    }
//
    public String  getNombre() {
        return nombre;
    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
    public String getP1() {
        return p1;
    }
//
//    public void setP1(String p1) {
//        this.p1 = p1;
//    }
//
    public String getP2() {
        return p2;
    }
//
//    public void setP2(String p2) {
//        this.p2 = p2;
//    }
}
