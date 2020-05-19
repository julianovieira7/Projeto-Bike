package model.validation;

import application.ValidationException;
import model.Telefone;
import repository.TelefoneRepository;

public class TelefoneValidation implements Validation<Telefone> {

	@Override
	public void validate(Telefone entity) throws ValidationException {
		TelefoneRepository repo = new TelefoneRepository();
		validaTelefone(entity);

	}

	private void validaTelefone(Telefone entity) throws ValidationException {
		TelefoneRepository repo = new TelefoneRepository();
		if (repo.containsTelefone(entity.getId(), entity.getCodigoArea(), entity.getNumero())) {
			throw new ValidationException("Email Invalido. Este e-mail ja esta sendo utilizado por outro usuario.");
		}

	}
}