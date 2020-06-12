package br.com.SeletivoCoontrol.domain;

public class Empresas {

	private long cnpj;
	private String descricao;
	private int funcionarios;
	private String data;
	private Segmentos setor;
	private Regiao regiao;
	private String cod_regiao;
	private String cod_setor;
	
	
	
	
	public String getCod_regiao() {
		return cod_regiao;
	}

	public void setCod_regiao(String cod_regiao) {
		this.cod_regiao = cod_regiao;
	}

	public String getCod_setor() {
		return cod_setor;
	}

	public void setCod_setor(String cod_setor) {
		this.cod_setor = cod_setor;
	}

	public Segmentos getSetor() {
		return setor;
	}
	
	public void setSetor(Segmentos setor) {
		this.setor = setor;
	}
	
	public Regiao getRegiao() {
		return regiao;
	}
	
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
	public long getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(int funcionarios) {
		this.funcionarios = funcionarios;
	}
	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return  descricao;
	}
	
	
	
}
