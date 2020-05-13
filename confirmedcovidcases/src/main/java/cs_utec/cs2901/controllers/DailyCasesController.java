package cs_utec.cs2901.controllers;


import cs_utec.cs2901.business.DailyCasesBusiness;
import cs_utec.cs2901.data.DailyCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/DailyCases")
public class DailyCasesController {

    @Autowired
    private DailyCasesBusiness business;

    @PostMapping
    public DailyCases create(@RequestBody DailyCases dailyCases ){
        System.out.println("ejecutado");
        return business.create(dailyCases);
    }

    @GetMapping
    public List<DailyCases> read(){
        return business.findAll();
    }

    @PutMapping ("/{id}")
    public DailyCases update(@RequestBody DailyCases item,@PathVariable Long id){
        return business.update(item);
    }
    @DeleteMapping ("/{id}")
    public void delete(@PathVariable long id){
         business.delete(id);
    }
}
