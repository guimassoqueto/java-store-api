package com.guimassoqueto.storeapi.storeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guimassoqueto.storeapi.storeapi.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}