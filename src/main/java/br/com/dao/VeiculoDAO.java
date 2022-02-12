package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.conexao.Conexao;

public class VeiculoDAO {

	public VeiculoDAO() {
		super();
	}
	
	public void inserirVeiculo(Veiculo veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into veiculos (modelo, ano) values (?, ?)");
			p.setString(1, veiculo.getModelo());
			p.setString(2, veiculo.getAno());

			System.out.println(p);
			p.executeUpdate();
			System.out.println("Inserção Concluída");
			p.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Veiculo> consultarListaVeiculos(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			PreparedStatement p = con.prepareStatement("select * from veiculos");
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				Integer id = r.getInt("id");
				String modelo = r.getString("modelo");
				String ano = r.getString("ano");

				Veiculo veiculo = new Veiculo(modelo, ano);
				veiculo.setId(id);
				veiculos.add(veiculo);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return veiculos;
	}
	
	public Veiculo consultarVeiculo(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Veiculo veiculo = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from veiculos where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();	
			
			while (r.next()) {
				Integer id2 = r.getInt("id");
				String modelo = r.getString("modelo");
				String ano = r.getString("ano");

				veiculo = new Veiculo(modelo, ano);
				veiculo.setId(id2);
			}
			r.close();
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return veiculo;
	}
	
	public void deletarVeiculo(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from veiculos where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Remoção Concluída");
			p.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarVeiculo(Integer id, String modelo, String ano) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update veiculos set modelo = ?, ano = ? where id = ?");
			p.setString(1, modelo);
			p.setString(2, ano);

			p.setInt(3, id);
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Alteração Concluída");
			p.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//	public void compararAnosIPVA() {
//		Conexao c = Conexao.getInstance();
//		Connection con = c.getConnection();
//		
//		try {
//			PreparedStatement p = con.prepareStatement("select ano from (select ano from veiculos union all select ano from IPVA) veiculos group by ano having count(*) = 1");
//			
//			String ano = null;
//			
//			p.setString(1, "%" + ano + "%");  
//			p.executeQuery();
//			
//			System.out.println(p);
//			System.out.println("Informação carregada");
//			p.close();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public String buscarIPVA(String ano) throws Exception{
//		
//		Conexao c = Conexao.getInstance();
//		Connection con = c.getConnection();
//		
//		try {
//			PreparedStatement p = con.prepareStatement("SELECT ano FROM (SELECT ano FROM veiculos UNION ALL SELECT ano FROM IPVA) veiculos GROUP BY ano HAVING COUNT(*) = 1\"");
//			
//			p.setString(1, "%" + ano + "%");
//			
//			ResultSet r = p.executeQuery();
//			
//			if (!r.next()) {
//                throw new Exception("Não foi encontrado nenhuma pagamento previsto para o ano referente.");
//            }
//			
//			
//            while (r.next()) {
//              String ipvaVeiculo = "Não Paga";
//            }
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ano;
//			
//	}



}