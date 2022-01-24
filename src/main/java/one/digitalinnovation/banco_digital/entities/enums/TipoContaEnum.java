package one.digitalinnovation.banco_digital.entities.enums;


public enum TipoContaEnum {
	
	CONTACORRENTE(1, "Conta Corrente"),
	CONTAPOUPANÇA(2, "Conta Poupança");
	
	private int cod;
	private String descricao;
	
	private TipoContaEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoContaEnum toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (TipoContaEnum x : TipoContaEnum.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}

}
