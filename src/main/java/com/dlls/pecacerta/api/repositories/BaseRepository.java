package com.dlls.pecacerta.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dlls.pecacerta.api.model.BaseModel;

@Repository
public interface BaseRepository<TModel extends BaseModel>{
	Optional<TModel> findById(Long id);
	List<TModel> findByAtivo(Boolean ativo);
	List<TModel> findAll();
	TModel save(TModel model);
}
