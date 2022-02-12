package br.com.controller;

import br.com.conexao.Conexao;
import br.com.dao.Ipva;
import br.com.dao.IpvaDAO;
import br.com.dao.VeiculoDAO;

public class Aplicacao_IPVA {
	public static void main(String[] args) {
		
		IpvaDAO ipvaD = new IpvaDAO();
		VeiculoDAO veic = new VeiculoDAO();
		
		Conexao c = new Conexao();
		c.getConnection();
		
		Ipva ipva = new Ipva("2022");
		
		ipvaD.inserirIPVA(ipva);
		
		
		System.out.println(ipvaD.mostrarIPVA());
		
		

	}
}
