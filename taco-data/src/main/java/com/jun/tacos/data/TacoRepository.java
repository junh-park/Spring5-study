package com.jun.tacos.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jun.tacos.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long>{
}
