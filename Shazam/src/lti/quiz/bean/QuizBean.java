package lti.quiz.bean;

import java.util.ArrayList;

public class QuizBean {
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String question;
	private ArrayList<OptionBean> option = new ArrayList<>();
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<OptionBean> getOption() {
		return option;
	}
	public void setOption(ArrayList<OptionBean> option) {
		this.option = option;
	}
}
