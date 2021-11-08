package com.jun.tacos.data;

import org.springframework.data.repository.CrudRepository;

import com.jun.tacos.Taco;

public interface CrudTacoRepository extends CrudRepository<Taco, Long>{

}
