package br.com.SeletivoCoontrol.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import br.com.SeletivoCoontrol.DAO.RegiaoDAO;
import br.com.SeletivoCoontrol.domain.Regiao;


@ManagedBean(name = "MBRegioesCombo")
@RequestScoped
public class ComboBoxRegiaoView {
	
    private String regiao;  
    private Map<String,String> regioes = new HashMap<String, String>();
    private ListDataModel<Regiao> Itens;
    
    @PostConstruct
    public void init1() {
    	
		try {
			RegiaoDAO dao = new RegiaoDAO();
			ArrayList<Regiao> list =  dao.buscaRegiao();
			Itens = new ListDataModel<Regiao>(list);
			
			regioes = new HashMap<String, String>();
			for (Regiao reg : Itens){
				regioes.put(reg.getDes_regiao() , reg.getCod_regiao() );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Map<String, String> getRegioes() {
		return regioes;
	}

	public void setRegioes(Map<String, String> regioes) {
		this.regioes = regioes;
	}
   

}
