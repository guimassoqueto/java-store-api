package com.guimassoqueto.storeapi.storeapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guimassoqueto.storeapi.storeapi.domain.enums.EstadoPagamento;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private Integer id;
  private Integer estado;

  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "pedido_id")
  @MapsId
  private Pedido pedido;

  public Pagamento() {
  }

  public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
    this.id = id;
    this.estado = estado.getCod();
    this.pedido = pedido;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EstadoPagamento getEstado() {
    return EstadoPagamento.toEnum(estado);
  }

  public void setEstado(EstadoPagamento estado) {
    this.estado = estado.getCod();
  }

  public Pedido getPedido() {
    return this.pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Pagamento)) {
      return false;
    }
    Pagamento pagamento = (Pagamento) o;
    return Objects.equals(id, pagamento.id) && Objects.equals(estado, pagamento.estado)
        && Objects.equals(pedido, pagamento.pedido);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
