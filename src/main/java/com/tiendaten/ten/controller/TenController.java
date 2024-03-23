package com.tiendaten.ten.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiendaten.ten.model.Ten;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/tenis")
public class TenController {
    private List<Ten> tenis;

    public TenController(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Ten[] tenisArrays = objectMapper.readValue(new ClassPathResource("tenis.json").getFile(), Ten[].class);
            tenis = new ArrayList<>(Arrays.asList(tenisArrays));
        }catch (IOException e){
            e.printStackTrace();
            tenis = new ArrayList<>();
        }
    }

    @GetMapping
    public List<Ten> getAllTenis() {
        return tenis;
    }
    
    @GetMapping("/{id}")
    public Ten getTenByid(@PathVariable Long id) {
        return tenis.stream().filter(ten -> ten.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Ten createTen(@RequestBody Ten ten) {
        tenis.add(ten);
        return ten;
    }

    @PutMapping("/{id}")
    public Ten updateTen(@RequestBody Long id, @RequestBody Ten updateTen) {
        Ten ten =getTenByid(id);
        if (ten != null){
            ten.setMarca(updateTen.getMarca());
            ten.setTalla(updateTen.getTalla());
            ten.setPrecio(updateTen.getPrecio());    
            return ten;
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delateTen(@PathVariable Long id){
        tenis.removeIf(ten -> ten.getId().equals(id)); 
    }
}
