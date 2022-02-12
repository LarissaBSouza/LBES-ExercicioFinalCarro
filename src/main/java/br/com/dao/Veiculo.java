package br.com.dao;

public class Veiculo {
	
	private Integer id;
	private String modelo;
	private String ano;
	private String ipvaVeiculo;
	
	
	public Veiculo(Integer id, String modelo, String ano) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
	}


	public Veiculo(String modelo, String ano) {
		super();
		this.modelo = modelo;
		this.ano = ano;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", modelo=" + modelo + ", ano=" + ano +  "]";
	}


	
	
	
	
}
