package br.com.SeletivoCoontrol.domain;

public class Segmentos {
	
	private String cod_setor;
	private String des_setor;
	
	public String getCod_setor() {
		return cod_setor;
	}
	public void setCod_setor(String cod_setor) {
		this.cod_setor = cod_setor;
	}
	public String getDes_setor() {
		return des_setor;
	}
	public void setDes_setor(String des_setor) {
		this.des_setor = des_setor;
	}
	@Override
	public String toString() {
		return des_setor;
	}
	
	
	
}
