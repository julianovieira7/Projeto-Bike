package model;



import model.validation.Validation;

public class Boleto extends DefaultEntity<Boleto> {

	
	private static final long serialVersionUID = 3439139989573447798L;

	private String cpf;
	private String codigoBoleto;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodigoBoleto() {
		return codigoBoleto;
	}

	public void setCodigoBoleto(String codigoBoleto) {
		this.codigoBoleto = codigoBoleto;
	}

	@Override
	public Validation<Boleto> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
