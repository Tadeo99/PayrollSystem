package pe.buildsoft.erp.core.domain.entidades.pago.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.buildsoft.erp.core.infra.transversal.entidades.BaseEntidad;

public class SunatDatosVO extends BaseEntidad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String num_ruc = "-";
	private String tip_docu = "-";
	private String num_docu = "-";
	private String fec_carg = "-";
	private String fec_gene = "-";
	private String fec_envi = "-";
	private String des_obse = "-";
	private String nom_arch = "-";
	private String ind_situ = "-";
	private String tip_arch = "-";
	private String firm_digital = "-";
	private List<String> listaResultado = new ArrayList<>();

	public SunatDatosVO() {
		super();
	}

	public SunatDatosVO(String num_ruc, String tip_docu, String num_docu, String fec_carg, String fec_gene,
			String fec_envi, String des_obse, String nom_arch, String ind_situ, String tip_arch, String firm_digital) {
		super();
		this.num_ruc = num_ruc;
		this.tip_docu = tip_docu;
		this.num_docu = num_docu;
		this.fec_carg = fec_carg;
		this.fec_gene = fec_gene;
		this.fec_envi = fec_envi;
		this.des_obse = des_obse;
		this.nom_arch = nom_arch;
		this.ind_situ = ind_situ;
		this.tip_arch = tip_arch;
		this.firm_digital = firm_digital;
	}

	public List<String> getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List<String> listaResultado) {
		this.listaResultado = listaResultado;
	}

	public String getNum_ruc() {
		return num_ruc;
	}

	public void setNum_ruc(String num_ruc) {
		this.num_ruc = num_ruc;
	}

	public String getTip_docu() {
		return tip_docu;
	}

	public void setTip_docu(String tip_docu) {
		this.tip_docu = tip_docu;
	}

	public String getNum_docu() {
		return num_docu;
	}

	public void setNum_docu(String num_docu) {
		this.num_docu = num_docu;
	}

	public String getFec_carg() {
		return fec_carg;
	}

	public void setFec_carg(String fec_carg) {
		this.fec_carg = fec_carg;
	}

	public String getFec_gene() {
		return fec_gene;
	}

	public void setFec_gene(String fec_gene) {
		this.fec_gene = fec_gene;
	}

	public String getFec_envi() {
		return fec_envi;
	}

	public void setFec_envi(String fec_envi) {
		this.fec_envi = fec_envi;
	}

	public String getDes_obse() {
		return des_obse;
	}

	public void setDes_obse(String des_obse) {
		this.des_obse = des_obse;
	}

	public String getNom_arch() {
		return nom_arch;
	}

	public void setNom_arch(String nom_arch) {
		this.nom_arch = nom_arch;
	}

	public String getInd_situ() {
		return ind_situ;
	}

	public void setInd_situ(String ind_situ) {
		this.ind_situ = ind_situ;
	}

	public String getTip_arch() {
		return tip_arch;
	}

	public void setTip_arch(String tip_arch) {
		this.tip_arch = tip_arch;
	}

	public String getFirm_digital() {
		return firm_digital;
	}

	public void setFirm_digital(String firm_digital) {
		this.firm_digital = firm_digital;
	}

}
