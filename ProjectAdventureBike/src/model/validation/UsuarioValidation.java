package model.validation;

import java.time.LocalDate;

import application.ValidationException;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioValidation implements Validation<Usuario>{

	@Override
	public void validate(Usuario entity) throws ValidationException {
		validaDataAniversario(entity);
		
		validaEmail(entity);
		
	}

	private void validaEmail(Usuario entity) throws ValidationException {
		UsuarioRepository repo = new UsuarioRepository();
		if (repo.contains(entity.getId(), entity.getEmail())) {
			throw new ValidationException("Email Inválido. Este e-mail já está sendo utilizado por outro aluno.");
		}
	
	}
	
	private void validaDataAniversario(Usuario entity) throws ValidationException {
		LocalDate data = new java.sql.Date(entity.getDataAniversario().getTime()).toLocalDate(); 
		LocalDate dataLimite = 	LocalDate.now().minusYears(18);
		//data        = 12/05/2020
		//datalimite  = 12/05/2002
		if (data.isAfter(dataLimite)) {
			throw new ValidationException("Data Inválida. O aluno não pode ser menor de idade.");
		}
	}

}
