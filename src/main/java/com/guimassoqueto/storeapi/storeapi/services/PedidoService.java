package com.guimassoqueto.storeapi.storeapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimassoqueto.storeapi.storeapi.domain.Pedido;
import com.guimassoqueto.storeapi.storeapi.exceptions.ObjectNotFoundException;
import com.guimassoqueto.storeapi.storeapi.repositories.PedidoRepository;

@Service
public class PedidoService {
  
  @Autowired
  private PedidoRepository repository;

  public Pedido buscar(Integer id) {
    Optional<Pedido> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Not Found: " + id));
  }
}