package converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Marca;
import repository.MarcaRepository;

@FacesConverter(forClass = Marca.class)
public class MarcaConverter implements Converter<Marca>{

	@Override
	public Marca getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty())
			return null;
		MarcaRepository repo = new MarcaRepository();
		return repo.findById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Marca value) {
		if (value == null || value.getId() == null)
			return null;
		
		return value.getId().toString();
	}

}
