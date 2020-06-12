package br.com.SeletivoCoontrol.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SeletivoCoontrol.DAO.EmpresasDAO;

@ManagedBean(name = "MBRadio")
@ViewScoped
public class RadioBean {
	
	private String retorno;
	private String radio;

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}	
	
	
	
	public void questoes(String a) {
		
		EmpresasDAO dao = new EmpresasDAO();
		try {
			String resposta = dao.retornoQuestao(radio);
			retorno = resposta;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
