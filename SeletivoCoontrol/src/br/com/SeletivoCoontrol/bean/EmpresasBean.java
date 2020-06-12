package br.com.SeletivoCoontrol.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import br.com.SeletivoCoontrol.DAO.EmpresasDAO;
import br.com.SeletivoCoontrol.domain.Empresas;


@ManagedBean(name = "MBEmpresas")
@ViewScoped
public class EmpresasBean {
	
	private ListDataModel<Empresas> Itens;
	private Empresas empresa;
	
	
	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}
	
	
	

	public ListDataModel<Empresas> getItens() {
		return Itens;
	}

	public void setItens(ListDataModel<Empresas> itens) {
		Itens = itens;
	}
	
	
	@PostConstruct
	public void buscarEmpresas() {
		
		try {
			EmpresasDAO dao = new EmpresasDAO();
			ArrayList<Empresas> list =  dao.buscaEmpresas();
			Itens = new ListDataModel<Empresas>(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	public void prepararNovo(){
		empresa = new  Empresas();
	}
	
	
	
	public void novaEmpresa() {

		EmpresasDAO dao = new EmpresasDAO();
		try {
			dao.salvar( empresa );
			
			ArrayList<Empresas> list =  dao.buscaEmpresas();
			Itens = new ListDataModel<Empresas>(list);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
