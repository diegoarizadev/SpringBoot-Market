package com.tplinkdns.hagakur3.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity //Mapea una tabla en un modelo de datos de java
@Table(name = "compras") //Nombre de la tabla.
public class Compra {

    @Id //Clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Llave de la clave primaria.
    @Column(name = "id_compra") //Nombre de la columna en la base de datos.
    private Integer idCompra;

    @Column(name = "id_cliente") //Nombre de la columna en la base de datos.
    private String idCliente;

    private LocalDate fecha;

    @Column(name = "medio_pago") //Nombre de la columna en la base de datos.
    private String medioPago;

    private String comentario;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //cascade = {CascadeType.ALL} : Todos los procesos que s ehagan en la BD van a incluir en casacada los productos.
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<ComprasProducto> productos;
    //Acceder a todos los productos de una compra

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
