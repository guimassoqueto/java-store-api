package com.guimassoqueto.storeapi.storeapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.guimassoqueto.storeapi.storeapi.domain.enums.TipoCliente;
import java.util.Objects;

@Entity
public class Cliente implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String email;
  private String cpfOuCnpj;
  private Integer tipo;
  
  @JsonManagedReference
  @OneToMany(mappedBy = "cliente")
  private List<Endereco> enderecos = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "telefone")
  private Set<String> telefones = new HashSet<>();

  @JsonBackReference
  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedidos = new ArrayList<>();

  public Cliente() {}

  public Cliente(Integer id, String name, String email, String cpfOuCnpj, TipoCliente tipo) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.cpfOuCnpj = cpfOuCnpj;
    this.tipo = tipo.getCod();
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpfOuCnpj() {
    return this.cpfOuCnpj;
  }

  public void setCpfOuCnpj(String cpfOuCnpj) {
    this.cpfOuCnpj = cpfOuCnpj;
  }

  public TipoCliente getTipo() {
    return TipoCliente.toEnum(this.tipo);
  }

  public void setTipo(TipoCliente tipo) {
    this.tipo = tipo.getCod();
  }

  public List<Endereco> getEnderecos() {
    return this.enderecos;
  }

  public void setEnderecos(List<Endereco> enderecos) {
    this.enderecos = enderecos;
  }

  public Set<String> getTelefones() {
    return this.telefones;
  }

  public void setTelefones(Set<String> telefones) {
    this.telefones = telefones;
  }

  public List<Pedido> getPedidos() {
    return this.pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  @Override
    public boolean equals(Object o) {
    if (o == this)
        return true;
    if (!(o instanceof Cliente)) {
        return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(id, cliente.id) && Objects.equals(name, cliente.name) && Objects.equals(email, cliente.email) && Objects.equals(cpfOuCnpj, cliente.cpfOuCnpj) && Objects.equals(tipo, cliente.tipo) && Objects.equals(enderecos, cliente.enderecos) && Objects.equals(telefones, cliente.telefones);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
