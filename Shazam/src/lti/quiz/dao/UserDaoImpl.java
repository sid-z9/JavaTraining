package lti.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;
//import oracle.jdbc.OracleDriver;

public class UserDaoImpl implements UserDao {

	private Connection getConnection() throws SQLException {
		/*DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "sid", "sid123");*/
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			throw new SQLException(e.getMessage());
		}
		
	}
	

	@Override
	public RegisterBean authenticate(LoginBean login) {
		String sql = "select * from users where email=? and password=?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());

			ResultSet rs = stmt.executeQuery();
			
			RegisterBean rb_user = null;
			
			// to check whether row selected
			if (rs.next()) {
				rb_user = new RegisterBean();
				// rb_user.setEmail(login.getEmail());
				rb_user.setEmail(rs.getString(1));
				// rb_user.setPassword(login.getPassword());
				// rb_user.setAnswer(rs.getString(3));
				rb_user.setProfile(rs.getString(4));				
			} 
			return rb_user;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// complete the code

	}


	@Override
	public boolean register(RegisterBean register) {
		String sql = "insert into users values(?,?,?,?)";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, register.getEmail());
			stmt.setString(2, register.getPassword());
			stmt.setString(3, register.getAnswer());
			stmt.setString(4, register.getProfile());

			stmt.executeUpdate();
			System.out.println("Records successfully inserted");
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean validate(ForgetBean forget) {
		String sql = "select * from users where email=? and answer=?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, forget.getEmail());
			stmt.setString(2, forget.getAnswer());

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		return false;

		
	}

	
	@Override
	public boolean update(LoginBean change) {
		String sql = "update users set password=? where email=?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, change.getPassword());
			stmt.setString(2, change.getEmail());

			stmt.executeUpdate();
			
			System.out.println("Record Updated");
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}

		
	}

	@Override
	public boolean updateProfilePic(String email, String code) {
		// TODO Auto-generated method stub
		return false;
	}

}
