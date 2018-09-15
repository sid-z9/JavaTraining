package lti.quiz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lti.quiz.bean.OptionBean;
import lti.quiz.bean.QuizBean;
import oracle.jdbc.OracleDriver;

public class QuizDaoImpl implements QuizDao {

	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "sid", "sid123");
		return conn;
	}



	@Override
	public List<QuizBean> loadQuiz() {

		String sql = "select quiz.qid,question,options,ans_op from quiz,answer where quiz.qid=answer.qid order by quiz.qid";		Connection conn = null;

		try {
			conn = getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			List<QuizBean> questions = new ArrayList<>();
			QuizBean quiz = null;
			ArrayList<OptionBean> options = null;

			while (rs.next()) {
				if(quiz != null && quiz.getId() != rs.getInt(1)) {
					quiz.setOption(options);
					questions.add(quiz);
					quiz = null;
				}
				if (rs.getInt(1) > questions.size() && quiz == null) {
					quiz = new QuizBean();
					quiz.setId(rs.getInt(1));
					quiz.setQuestion(rs.getString(2));
					options = new ArrayList<>();
				}
				options.add(new OptionBean(rs.getString(3), rs.getString(4)));
			}

			return questions;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return null;
	}

	@Override
	public String getResult(String code) {
		String sql = "select hero from result where code = ?";
		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, code);

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
				return rs.getString("hero");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return null;
	}

}
