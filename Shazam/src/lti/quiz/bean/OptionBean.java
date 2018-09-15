package lti.quiz.bean;

public class OptionBean {
	private String option, score;

	public OptionBean(String string, String string2) {
		this.option = string;
		this.score = string2;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
}
