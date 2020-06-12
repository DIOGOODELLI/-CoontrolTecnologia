package br.com.SeletivoCoontrol.domain;

public class Regiao {
	
	private String cod_regiao;
	private String des_regiao;
	
	public String getCod_regiao() {
		return cod_regiao;
	}
	public void setCod_regiao(String cod_regiao) {
		this.cod_regiao = cod_regiao;
	}
	public String getDes_regiao() {
		return des_regiao;
	}
	public void setDes_regiao(String des_regiao) {
		this.des_regiao = des_regiao;
	}
	
	@Override
	public String toString() {
		return des_regiao;
	}
	
	
	
}
