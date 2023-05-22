package com.guimassoqueto.storeapi.storeapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guimassoqueto.storeapi.storeapi.domain.Categoria;
import com.guimassoqueto.storeapi.storeapi.exceptions.ObjectNotFoundException;
import com.guimassoqueto.storeapi.storeapi.repositories.CategoriaRepository;

@Service
public class CategoriaService {
  
  @Autowired
  private CategoriaRepository repository;

  public Categoria buscar(Integer id) {
    Optional<Categoria> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Not Found: " + id));
  }
}
