package br.com.SeletivoCoontrol.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import br.com.SeletivoCoontrol.DAO.SegmentosDAO;
import br.com.SeletivoCoontrol.domain.Segmentos;

@ManagedBean(name = "MBSegmentoCombo")
@RequestScoped

public class ComboBoxSegView {
	
    private String segmento;  
    private Map<String,String> segmentos = new HashMap<String, String>();
    private ListDataModel<Segmentos> Itens;
    
    @PostConstruct
    public void init1() {
    	
		try {
			SegmentosDAO dao = new SegmentosDAO();
			ArrayList<Segmentos> list =  dao.buscaSetor();
			Itens = new ListDataModel<Segmentos>(list);
			
			segmentos = new HashMap<String, String>();
			for (Segmentos seg : Itens){			
				segmentos.put( seg.getDes_setor() , seg.getCod_setor() );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public Map<String, String> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(Map<String, String> segmentos) {
		this.segmentos = segmentos;
	}

	public ListDataModel<Segmentos> getItens() {
		return Itens;
	}

	public void setItens(ListDataModel<Segmentos> itens) {
		Itens = itens;
	}
    
}
