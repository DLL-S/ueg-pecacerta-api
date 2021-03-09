package com.dlls.pecacerta.api.model;

public abstract class BaseModel {
	protected final Boolean ativo = null;
	public abstract Long getCodigo();
	public abstract void setAtivo(Boolean ativo);
}
