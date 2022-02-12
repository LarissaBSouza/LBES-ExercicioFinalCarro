package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.conexao.Conexao;

public class IpvaDAO {
	
	public IpvaDAO() {
		super();
	}
	
	public void inserirIPVA(Ipva ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into IPVA (ano) values (?)");
			p.setString(1, ipva.getAno());
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("IPVA Adicionado");
			p.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ipva> mostrarIPVA() {
		
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		List<Ipva> ipva = new ArrayList<Ipva>();
		
		try {
			PreparedStatement p = con.prepareStatement("select * from IPVA");
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				Integer id = r.getInt("id");
				String ano = r.getString("ano");
			
				Ipva ipva2 = new Ipva(ano);
				ipva2.setId(id);
				ipva.add(ipva2);
			}
			r.close();
			p.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipva;
	}
	
	public void deletarIPVA(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from IPVA where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("IPVA Deletado");
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void alterarIPVA(Integer id, String ano) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update IPVA set ano = ? where id = ?");
			p.setString(1, ano);
			p.setInt(4, id);
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("IPVA Atualizado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarIPVA(Integer id) {
		
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		Ipva ipva = new Ipva();
		
		try {
			PreparedStatement p = con.prepareStatement("select * from IPVA where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				Integer id1 = r.getInt("id");
				String ano = r.getString("ano");
				
				ipva = new Ipva(ano);
				ipva.setId(id);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
