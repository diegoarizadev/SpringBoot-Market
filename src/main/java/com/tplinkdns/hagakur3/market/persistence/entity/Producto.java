package com.tplinkdns.hagakur3.market.persistence.entity;

import javax.persistence.*;

@Entity //Mapea una tabla en un modelo de datos de java
@Table(name = "productos") //Nombre de la tabla.
public class Producto {

    @Id //Clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Llave de la clave primaria.
    @Column(name = "id_producto") //Nombre de la columna en la base de datos.
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria") //Nombre de la columna en la base de datos.
    private Integer idCategoria;

    @Column(name = "codigo_barras") //Nombre de la columna en la base de datos.
    private String codigoBarras;


    @Column(name = "precio_venta") //Nombre de la columna en la base de datos.
    private double precioVenta;


    @Column(name = "cantidad_stock") //Nombre de la columna en la base de datos.
    private Integer cantidadStock;

    private Boolean estado;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
