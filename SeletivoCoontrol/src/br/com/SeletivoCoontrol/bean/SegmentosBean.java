package br.com.SeletivoCoontrol.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import br.com.SeletivoCoontrol.DAO.SegmentosDAO;
import br.com.SeletivoCoontrol.domain.Segmentos;

@ManagedBean(name = "MBSegmentos")
@ViewScoped
public class SegmentosBean {
	
	private ListDataModel<Segmentos> Itens;

	public ListDataModel<Segmentos> getItens() {
		return Itens;
	}

	public void setItens(ListDataModel<Segmentos> itens) {
		Itens = itens;
	}
	
	
	@PostConstruct
	public void buscarSegmentos() {
		
		try {
			SegmentosDAO dao = new SegmentosDAO();
			ArrayList<Segmentos> list =  dao.buscaSetor();
			Itens = new ListDataModel<Segmentos>(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
