package model.validation;

import application.ValidationException;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioValidation implements Validation<Usuario>{

	@Override
	public void validate(Usuario entity) throws ValidationException {
			
		validaEmail(entity);
		
		validaCPF(entity);
	}

	private void validaEmail(Usuario entity) throws ValidationException {
		UsuarioRepository repo = new UsuarioRepository();
		if (repo.containsEmail(entity.getId(), entity.getEmail())) {
			throw new ValidationException("Email Invalido. Este e-mail ja esta sendo utilizado por outro usuario.");
		}
	
	}
	
	private void validaCPF(Usuario entity) throws ValidationException {
		UsuarioRepository repo = new UsuarioRepository();
		if (repo.containsCpf(entity.getId(), entity.getCpf())) {
			throw new ValidationException("CPF Invalido. Este CPF ja esta sendo utilizado por outro usuario.");
		}
	
	}
	
}
