package com.dlls.pecacerta.api.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dlls.pecacerta.api.events.ResourceCreatedEvent;
import com.dlls.pecacerta.api.model.BaseModel;
import com.dlls.pecacerta.api.repositories.BaseRepository;
import com.dlls.pecacerta.api.services.BaseService;

@CrossOrigin(origins="*", methods= {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
public abstract class BaseController<TModel extends BaseModel, TRepository extends BaseRepository<TModel>, TService extends BaseService<TModel, TRepository>>
{
	@Autowired
	protected TService servico;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("")
	public ResponseEntity<?> incluir(@Validated @RequestBody TModel model,
			HttpServletResponse response) {
		var savedModel = servico.save(model);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedModel.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedModel);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable(value = "id") Long id,
			@Validated @RequestBody TModel param)
	{
		return ResponseEntity.ok(servico.update(id, param));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultar(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(servico.find(id));
	}

	@GetMapping
	public ResponseEntity<?> listar() {
		var models = servico.findAll();
		return models.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(models);
	}
	
	@GetMapping("/ativos")
	public ResponseEntity<?> listarModelsAtivos() {
		var models = servico.findAtivo();
		return models.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(models);
	}

	@PutMapping("/{id}/ativo")
	public ResponseEntity<?> ativarModel(@PathVariable(value = "id") Long id,
			@Validated @RequestBody Boolean booleano) {

		return ResponseEntity.ok(servico.alteraStatus(id, booleano));
	}
}
