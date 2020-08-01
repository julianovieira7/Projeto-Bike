package converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Fornecedor;
import repository.FornecedorRepository;

@FacesConverter(forClass = Fornecedor.class)
public class FornecedorConverter implements Converter<Fornecedor>{

	@Override
	public Fornecedor getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty())
			return null;
		FornecedorRepository repo = new FornecedorRepository();
		return repo.findById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Fornecedor value) {
		if (value == null || value.getId() == null)
			return null;
		
		return value.getId().toString();
	}

}
