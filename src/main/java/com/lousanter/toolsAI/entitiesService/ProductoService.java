package com.lousanter.toolsAI.entitiesService;

import com.lousanter.toolsAI.entities.Producto;
import com.lousanter.toolsAI.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    public ProductoRepository repo;

    public Producto save( Producto producto){
        return repo.save(producto);
    }

    public void deleteID(Long id){
        repo.deleteById(id);
    }

    public Optional<Producto> findById(Long id){
        return repo.findById(id);
    }

    public List<Producto> findAll(){
        return repo.findAll();
    }

    public Long getLastID(){
        return repo.getLastId();
    }

}
