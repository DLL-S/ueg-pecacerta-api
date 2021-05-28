package com.dlls.pecacerta.api.errors;

import com.dlls.pecacerta.api.model.*;
import com.dlls.pecacerta.api.exceptions.*;

public class Error {
	private String userMessage;
	private String developerMessage;

	public Error(String userMessage, String developerMessage) {
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}
	
	public static <TModel extends BaseModel> RuntimeException ObjectNoneExistent(TModel obj) {
		switch (obj.getClass().toString())
		{
			case "Categoria":
				return new CategoriaNoneExistentException();
			case "Cliente":
				return new ClienteNoneExistentException();
			case "Funcionario":
				return new FuncionarioNoneExistentException();
			case "Marca":
				return new MarcaNoneExistentException();
			case "Produto":
				return new ProdutoNoneExistentException();
			default:
				return null;
		}
	}
}