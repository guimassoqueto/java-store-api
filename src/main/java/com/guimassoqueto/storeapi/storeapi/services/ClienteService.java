package com.guimassoqueto.storeapi.storeapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimassoqueto.storeapi.storeapi.domain.Cliente;
import com.guimassoqueto.storeapi.storeapi.exceptions.ObjectNotFoundException;
import com.guimassoqueto.storeapi.storeapi.repositories.ClienteRepository;

@Service
public class ClienteService {
  
  @Autowired
  private ClienteRepository repository;

  public Cliente buscar(Integer id) {
    Optional<Cliente> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Not Found: " + id));
  }
}