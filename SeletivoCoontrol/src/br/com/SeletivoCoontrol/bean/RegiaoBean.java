package br.com.SeletivoCoontrol.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import br.com.SeletivoCoontrol.DAO.RegiaoDAO;
import br.com.SeletivoCoontrol.domain.Regiao;

@ManagedBean(name = "MBRegioes")
@RequestScoped

public class RegiaoBean {
	
	private ListDataModel<Regiao> Itens;

	public ListDataModel<Regiao> getItens() {
		return Itens;
	}

	public void setItens(ListDataModel<Regiao> itens) {
		Itens = itens;
	}
	
	
	@PostConstruct
	public void buscarEmpresas() {
		
		try {
			RegiaoDAO dao = new RegiaoDAO();
			ArrayList<Regiao> list =  dao.buscaRegiao();
			Itens = new ListDataModel<Regiao>(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
