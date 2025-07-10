package com.lousanter.toolsAI.entitiesController;

import com.lousanter.toolsAI.entities.Producto;
import com.lousanter.toolsAI.entitiesService.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    @Autowired
    ProductoService ps;


    public Optional<Producto> getProducto(Long id) {
        return ps.findById(id);
    }

    public Producto save(Producto producto) {
        return ps.save(producto);
    }

    public List<Producto> findAll() {
        return ps.findAll();
    }
}
