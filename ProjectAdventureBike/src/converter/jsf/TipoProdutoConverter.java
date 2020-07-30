package converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.TipoProduto;
import repository.TipoProdutoRepository;

@FacesConverter(forClass = TipoProduto.class)
public class TipoProdutoConverter implements Converter<TipoProduto>{

	@Override
	public TipoProduto getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty())
			return null;
		TipoProdutoRepository repo = new TipoProdutoRepository();
		return repo.findById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, TipoProduto value) {
		if (value == null || value.getId() == null)
			return null;
		
		return value.getId().toString();
	}

}
