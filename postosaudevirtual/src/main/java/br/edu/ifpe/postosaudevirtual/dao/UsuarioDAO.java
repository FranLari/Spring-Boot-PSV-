package br.edu.ifpe.postosaudevirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.postosaudevirtual.model.Usuario;

@Repository
public class UsuarioDAO {

	public void adiciona(Usuario usuario) throws ClassNotFoundException, SQLException {
		 //conectamos no banco 
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
       String sql = "INSERT INTO `aluno`"
       		+ "(`CÓDIGO_USUÁRIO`, `Nº DO CARTÃO DO SUS`, `CPF`, `NOME`, `DATA DE NASCIMENTO`, `E-MAIL`, `SENHA`, `TELEFONE`) "
       		+ "VALUES (  ? , ? , ? , ?, ?, ?, ?, ?)"; 	 
   	 //prepara��o da declara��o
       PreparedStatement stmt = connection.prepareStatement(sql);

      // stmt.setInt(1, usuario.getCodigo_usuario());
       stmt.setString(1, usuario.getNumeroCartaoSus());
       stmt.setString(2, usuario.getCpf());
       stmt.setString(3, usuario.getNome());
       stmt.setString(4, usuario.getDataNascimento());
       stmt.setString(5, usuario.getEmail());
       stmt.setString(6, usuario.getSenha());
       stmt.setString(7, usuario.getTelefone());

       stmt.execute();
       stmt.close();
       connection.close();
    }
	
	public List<Usuario> consultarTodosAlunos() throws ClassNotFoundException, SQLException{
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "SELECT `codigo_usuario`, `numeroCartaoSus`, `cpf`, `nome`, `dataNascimento`, `email`, `senha`, `telefone` FROM `usuario`"; 
	     PreparedStatement stmt = connection.prepareStatement(sql);

	     ResultSet resultSet = stmt.executeQuery();

	     List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();

	     while(resultSet.next()) {

	    	 Usuario usuario = new Usuario();  

	        int codigo_usuario = resultSet.getInt("codigo_usuario");
	        usuario.setCodigo_usuario(codigo_usuario);  	        
	        String numeroCartaoSus = resultSet.getString(2);
	        usuario.setNumeroCartaoSus(numeroCartaoSus);	        
	        usuario.setCpf(resultSet.getString(3));
	        usuario.setNome(resultSet.getString(4));
	        usuario.setDataNascimento(resultSet.getString(5));
	        usuario.setEmail(resultSet.getString(6));
	        usuario.setSenha(resultSet.getString(7));
	        usuario.setTelefone(resultSet.getString(8));

	        listaTodosUsuarios.add(usuario);
	     }	     
		 return listaTodosUsuarios;

	 }
	 
	public Usuario consultarAluno(int codigo_usuario) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "SELECT * FROM `usuario` WHERE codigo = ? ";

		 PreparedStatement stmt = connection.prepareStatement(sql);
		 stmt.setInt(1, codigo_usuario);

		 ResultSet resultSet = stmt.executeQuery();

		 Usuario usuario = new Usuario(); 
		 if(resultSet.next()) {

			 usuario.setCodigo_usuario(resultSet.getInt(1));
			 usuario.setNumeroCartaoSus(resultSet.getString(2));
			 usuario.setCpf(resultSet.getString(3));
			 usuario.setNome(resultSet.getString(4));
			 usuario.setDataNascimento(resultSet.getString(5));
			 usuario.setEmail(resultSet.getString(6));
			 usuario.setSenha(resultSet.getString(7));
			 usuario.setTelefone(resultSet.getString(8));
		 }		 
		 return usuario;		 
	 }
	
	public void alterarUsuarioDAO(Usuario usuario) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "UPDATE `usuario` SET `numeroCartaoSus`= ?,`cpf`= ?,"
		 		+ "`nome`= ?,`dataNascimento`= ?,`email`= ?,`senha`= ?,`telefone`= ? WHERE codigo_usuario = ?";

		 PreparedStatement stmt = connection.prepareStatement(sql);

	        stmt.setString(1, usuario.getNumeroCartaoSus());
	        stmt.setString(2, usuario.getCpf());
	        stmt.setString(3, usuario.getNome());
	        stmt.setString(4, usuario.getDataNascimento());
	        stmt.setString(5, usuario.getEmail());
	        stmt.setString(6, usuario.getSenha());
	        stmt.setString(7, usuario.getTelefone());
	        stmt.setInt(8, usuario.getCodigo_usuario());

	        stmt.executeUpdate();
	        stmt.close();
	        connection.close();

	 }
	
	public void deletarAlunoDAO(int codigo_usuario) throws ClassNotFoundException, SQLException {
		 Connection connection = ConexaoMySQL.getConexaoMySQL();
		 String sql = "DELETE FROM `usuario` WHERE codigo_usuario = ?";

		 PreparedStatement stmt = connection.prepareStatement(sql);

		 stmt.setInt(1, codigo_usuario);

		 stmt.execute();
		 stmt.close();
		 connection.close();

	 }
}
