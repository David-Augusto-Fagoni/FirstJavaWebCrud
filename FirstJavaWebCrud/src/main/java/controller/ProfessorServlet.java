package controller;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Professor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProfessorServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String titulacao = request.getParameter("titulacao");
		
		//retorno
		String saida ="";
		String erro = "";
		Professor p = new Professor();
		List<Professor> professores = new ArrayList<>();
		
		if (!cmd.contains("Listar")) {
			p.setCodigo(Integer.parseInt(codigo));
		}
		if (cmd.contains("Cadastrar") || cmd.contains("Alterar")) {
			p.setTitulacao(titulacao);
			p.setNome(nome);
		}
		try {
			if (cmd.contains("Cadastrar")) {
				cadastrarProfessor(p);
				saida = "Professor cadastrado";
				p = null;
			}
			if (cmd.contains("Alterar")) {
				alterarProfessor(p);
				saida = "Professor alterado";
				p = null;
			}
			if (cmd.contains("Alterar")) {
				excluirProfessor(p);
				saida = "Professor excluido";
				p = null;
			}
			if (cmd.contains("Buscar")) {
				p = buscarProfessor(p);
			}
			if (cmd.contains("Listar")) {
				professores = listarProfessores();
			}
		}catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("professor", p);
			request.setAttribute("professores", professores);
			
			RequestDispatcher rd = request.getRequestDispatcher("professor.jsp");
			rd.forward(request, response);
		}
	}


	private void cadastrarProfessor(Professor p) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(p);
	}


	private void alterarProfessor(Professor p) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		System.out.println(p);

	}


	private void excluirProfessor(Professor p) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		System.out.println(p.getCodigo());

	}


	private Professor buscarProfessor(Professor p) throws SQLException, ClassNotFoundException{
		p.setNome("CHEGOU");
		p.setTitulacao("AQUI");
		return p;
	}


	private List<Professor> listarProfessores() throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		List<Professor> professores = new ArrayList<Professor>();
		
		Professor p1 = new Professor();
		p1.setCodigo(1);
		p1.setNome("EU");
		p1.setTitulacao("NADA");
		
		Professor p2 = new Professor();
		p2.setCodigo(2);
		p2.setNome("ELE");
		p2.setTitulacao("FALA");
		
		Professor p3 = new Professor();
		p3.setCodigo(3);	
		p3.setNome("NOS");
		p3.setTitulacao("FAZEMOS");
		
		professores.add(p1);
		professores.add(p2);
		professores.add(p3);
		return professores;
	}

}
