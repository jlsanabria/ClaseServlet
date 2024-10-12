package tech.icei.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "icei_factura", schema = "core")
public class Factura {
    @Id
    @Column(name = "codigo_facturacion")
    private String codFactura;

    @Column(name = "tipo_factura", length = 100, nullable = false)
    private String tipoFactura;

    @Column(name = "numero_factura", nullable = false)
    private Integer numeroFactura;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_factura", nullable = false)
    private Date fechaFactura;
}
