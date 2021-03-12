package com.dlls.pecacerta.api.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlls.pecacerta.api.model.BaseModel;
import com.dlls.pecacerta.api.repositories.BaseRepository;

@Service
public abstract class BaseService<TModel extends BaseModel, TRepository extends BaseRepository<TModel>> {
	@Autowired
	protected TRepository repository;

	public TModel find(Long codigo) {
		TModel modelError = null;
		var saved = repository.findById(codigo).orElseThrow(() -> com.dlls.pecacerta.api.utils.Error.ObjectNoneExistent(modelError));
		return saved;
	}
	
	public TModel save(@Valid TModel model) {
		return repository.save(model);
	}
	
	public List<TModel> findAll()
	{
		return repository.findAll();
	}

	public TModel update(Long codigo, TModel updatedModel) {
		var savedModel = find(codigo);

		BeanUtils.copyProperties(updatedModel, savedModel, "codigo");
		return this.save(savedModel);
	}
	
	public TModel alteraStatus(Long id, Boolean ativo){
		var model = find(id);
		model.setAtivo(ativo);
		return repository.save(model);
	}

	public List<TModel> findAtivo() {
		return repository.findByAtivo(true);
	}
}
