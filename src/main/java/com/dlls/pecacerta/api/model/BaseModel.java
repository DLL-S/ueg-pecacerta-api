package com.dlls.pecacerta.api.model;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class BaseModel {
	protected final Boolean ativo = null;
	public abstract Long getCodigo();
	public abstract void setAtivo(Boolean ativo);
}
