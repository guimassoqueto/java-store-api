package com.guimassoqueto.storeapi.storeapi.domain.enums;

public enum TipoCliente {
  PESSOAFISICA(1, "Pessoa Física"),
  PESSOAJURIDICA(2, "Pessoa Jurídica");

  private Integer cod;
  private String descricao;

  private TipoCliente(Integer cod, String descricao) {
    this.cod = cod;
    this.descricao = descricao;
  }

  public Integer getCod() {
    return this.cod;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public static TipoCliente toEnum(Integer cod) {
    if (cod == null) return null;

    for (TipoCliente c: TipoCliente.values()) {
      if (cod.equals(c.getCod())) {
        return c;
      }
    }

    throw new IllegalArgumentException("Id inválido: " + cod);
  }
}
