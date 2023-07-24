package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.String;

@Controller // This means that this class is a Controller
@RequestMapping(path="/")

public class MainController {
    @Autowired
    private InstrumentoRepository Repository;

    @GetMapping(path="/")
    public @ResponseBody String Home() {return "A1807010 - Piero Rodriguez Cansaya";}

    @GetMapping(path="/codigo")
    public @ResponseBody String codigo() {return "A18007010";}

    @GetMapping(path="/nombre-completo")
    public @ResponseBody String nombre() {return "Piero Rodriguez Cansaya";}


    @PostMapping(path="/api/Instrumento/nuevo") // POST http://localhost:8080/demo/add
    public @ResponseBody String addNewUser (@RequestParam String nombre ) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Instrumento n = new Instrumento();
    n.setNombre(nombre);
    Repository.save(n);
    return "Instrumento Guardado";
  }

  @GetMapping(path="/api/Instrumento/listar") // GET http://localhost:8080/demo/all
  public @ResponseBody Iterable<Instrumento> getAllUsers() {
    // This returns a JSON or XML with the users
    return Repository.findAll();
  }

  @DeleteMapping(path="/api/Instrumento/eliminar")
  public @ResponseBody String deleteUser(@RequestParam Integer id) {
    Instrumento user = Repository.findById(id).orElse(null);
    if (user != null) {
      Repository.delete(user);
      return "Deleted";
    }
    return "Not found";
  }
}
