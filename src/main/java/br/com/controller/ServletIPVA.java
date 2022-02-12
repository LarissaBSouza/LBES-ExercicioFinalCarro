package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.Veiculo;
import br.com.dao.VeiculoDAO;

/**
 * Servlet implementation class ServletIPVA
 */
@WebServlet("/ServletIPVA")
public class ServletIPVA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static VeiculoDAO veiculoD = new VeiculoDAO();
//	private static IpvaDAO ipvaD = new IpvaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIPVA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String alterar = request.getParameter("alterar");
		
		if(id != null) {
			
			if(alterar.equals("0")) {
				veiculoD.deletarVeiculo(Integer.parseInt(id));
			}else if(alterar.equals("1")) {
				Veiculo veiculo = veiculoD.consultarVeiculo(Integer.parseInt(id));
				
				request.setAttribute("id", veiculo.getId());
				request.setAttribute("modelo", veiculo.getModelo());
				request.setAttribute("ano", veiculo.getAno());
				
				request.getRequestDispatcher("form.jsp").forward(request, response);
			}
		}
		
		request.setAttribute("veiculos", veiculoD.consultarListaVeiculos());
		request.getRequestDispatcher("/").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if(request.getParameter("modelo") != null && request.getParameter("ano") != null) {
			
			String modelo = request.getParameter("modelo");
			String ano = request.getParameter("ano");
			
			String id = request.getParameter("id");
			
			
			if(id != null && !id.isEmpty()) {
				veiculoD.alterarVeiculo(Integer.parseInt(id), modelo, ano);
			}else {
				Veiculo veiculo = new Veiculo(modelo, ano);
				veiculoD.inserirVeiculo(veiculo);
			}
			
			
			
			request.setAttribute("veiculos", veiculoD.consultarListaVeiculos());
			
		}
		
		request.getRequestDispatcher("/").forward(request, response);
	}

}
