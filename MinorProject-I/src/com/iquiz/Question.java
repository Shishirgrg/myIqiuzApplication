package com.iquiz;


public class Question {

	public String qstn;
	public String choice1;
	public String choice2;
	public String choice3;
	public String choice4;
	public String answer;
	public Question(String qstn,String choice1,String choice2,String choice3,String choice4,String answer) {
		this.qstn = qstn;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.answer = answer;
		
	}
	
}
