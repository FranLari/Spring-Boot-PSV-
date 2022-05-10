package br.edu.ifpe.postosaudevirtual.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifpe.postosaudevirtual.model.Usuario;

public class UsuarioDao {
	
	private Connection connection;
		
	 public UsuarioDao() {
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            String DATABASE_URL = "jdbc:mysql://localhost/ifpe_bd_cliente";
	            String usuario = "root";
	            String senha = "";
	            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	
	public List<Usuario> listar() {
        String sql = "SELECT * FROM cliente";
        List<Usuario> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Usuario cliente = new Usuario();
                cliente.setCodigo_usuario(resultado.getInt("codigo_usuario"));
                cliente.setNumeroCartaoSus(resultado.getString("numeroCartaoSus")); 
                cliente.setCpf(resultado.getString("cpf")); 
                cliente.setNome(resultado.getString("nome"));
                cliente.setDataNascimento(resultado.getString("dataNascimento"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setSenha(resultado.getString("senha"));
                cliente.setTelefone(resultado.getString("telefone"));
                retorno.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean inserir(Usuario cliente) {
        String sql = "INSERT INTO cliente(numeroCartaoSus, cpf, nome, dataNascimento, email, senha, telefone) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNumeroCartaoSus());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getDataNascimento());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getSenha());
            stmt.setString(7, cliente.getTelefone());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Usuario pessoa) {
        String sql = "UPDATE cliente SET numeroCartaoSus=?, cpf=?, nome=?, dataNascimento=?, email=?, senha=?, telefone=? WHERE codigo_usuario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNumeroCartaoSus());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getNome());
            stmt.setString(4, pessoa.getDataNascimento());
            stmt.setString(5, pessoa.getEmail());
            stmt.setString(6, pessoa.getSenha());
            stmt.setString(7, pessoa.getTelefone());
            stmt.setInt(8, pessoa.getCodigo_usuario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer codigo) {
        String sql = "DELETE FROM cliente WHERE codigo_usuario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}