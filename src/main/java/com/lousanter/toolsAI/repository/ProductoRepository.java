package com.lousanter.toolsAI.repository;

import com.lousanter.toolsAI.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "select max (id) from producto", nativeQuery = true)
    Long getLastId();
}
