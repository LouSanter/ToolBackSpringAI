package com.lousanter.toolsAI.AI.ToolsAI;

import com.lousanter.toolsAI.entities.Producto;
import com.lousanter.toolsAI.entitiesController.ProductoController;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class toolsOne {


    ChatClient chatClient;
    ProductoController productoController;

    @Autowired
    public toolsOne(ChatClient.Builder builder, ProductoController productoController) {
        this.chatClient = builder.build();
        this.productoController = productoController;
    }

    @Tool(description = "obtienes la fecha y hora actual de la timezone del usuario")
    String getDateTime(){
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

    @Tool(description = "establece una alarma para la hora proporcionada en formato ISO-8601")
    void setAlarm(String time){
        LocalDateTime alarma = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("Alarma: " + alarma);
    }


    @Tool(description = "CREAR 1 SOLO PRODUCTO", returnDirect = true)
    void createProduct(){
        BeanOutputConverter<Producto> lop = new BeanOutputConverter<>(Producto.class);


        Map<String,Object> map = (Map.of("format", lop.getFormat()));

        String sms = "CREA UN PRODUCTO (no generes el campo ID) {format}";
        PromptTemplate promptTemplate = new PromptTemplate(sms);
        Prompt pp = promptTemplate.create(map);

        Producto producto = lop.convert(chatClient.prompt(pp).call().content());
        System.out.println("producto creado: " +  producto);

        productoController.save(producto);

    }

    @Tool(description = "lista todos los productos", returnDirect = true)
    String listProducts(){
        return productoController.findAll()
                .stream()
                .map(Producto::getNombre)
                .collect(Collectors.joining(", "));
    }

    @Tool(description = "lista producto por ID, se requiere id", returnDirect = true)
    Optional<Producto> listarProductoId(Long id){
        Optional<Producto> producto = productoController.getProducto(id);
        if(producto.isPresent()){
            return producto;
        }
        return null;
    }





}
