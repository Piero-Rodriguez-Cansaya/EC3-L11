package com.example.demo;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "isntrumento", path = "isntrumento")
public interface InstrumentoRepository extends CrudRepository<Instrumento, Integer>{
    
    //List<instrumento> findByNombre(@Param("nombre") String nombre);
}