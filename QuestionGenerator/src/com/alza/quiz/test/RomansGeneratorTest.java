package com.alza.quiz.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alza.quiz.model.MultipleChoiceQuiz;
import com.alza.quiz.model.Quiz;
import com.alza.quiz.qfactory.IQuestionFactory;
import com.alza.quiz.qfactory.Util;

public class RomansGeneratorTest {
	public static void main(String[] args) {

		final long startTime = System.currentTimeMillis();
		int testCount = 1;
		for (int i = 0; i < testCount; i++) {
			allGenerator();
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total running time (ms) = " +(endTime-startTime));
	}

	
	private static void allGenerator(){
		List<IQuestionFactory> lqf = Util.getAllRomansQuestionFactory();
		List<Quiz> ql = new ArrayList<Quiz>();
		for (IQuestionFactory iQuestionFactory : lqf) {
			ql.addAll(iQuestionFactory.generateQuizList());
		}
		Collections.sort(ql);
		for (Quiz q : ql) {
			System.out.println("------------------------------");
			System.out.println("Grade : "+q.getLessonGrade());
			System.out.println("Subcategory :" +q.getLessonSubcategory());
			System.out.println("Question : " + q.getQuestion());
			MultipleChoiceQuiz mq = (MultipleChoiceQuiz) q;
			System.out.println("Choices : "+ String.join(" , ", mq.getChoices()));
			System.out.println("Answer : "+ q.getCorrectAnswer());
		}
		System.out.println("Jumlah soal : "+ql.size());
	}
}
