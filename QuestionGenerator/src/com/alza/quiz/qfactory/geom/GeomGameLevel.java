package com.alza.quiz.qfactory.geom;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.alza.quiz.model.GameLevel;
import com.alza.quiz.qfactory.geom.rectangle.RectangleBasicProperties;
import com.alza.quiz.qfactory.geom.rectangle.RectangleFindAreaKnownLengthWidth;
import com.alza.quiz.qfactory.geom.rectangle.RectangleFindDiagonalKnownLengthWidth;
import com.alza.quiz.qfactory.geom.rectangle.RectangleFindLengthKnownArea;
import com.alza.quiz.qfactory.geom.rectangle.RectangleFindLengthKnownPerimeter;
import com.alza.quiz.qfactory.geom.rectangle.RectangleFindPerimeterKnownLengthWidth;
import com.alza.quiz.qfactory.geom.square.SquareBasicProperties;
import com.alza.quiz.qfactory.geom.square.SquareFindAreaKnownLength;
import com.alza.quiz.qfactory.geom.square.SquareFindLengthKnownArea;
import com.alza.quiz.qfactory.geom.square.SquareFindLengthKnownPerimeter;
import com.alza.quiz.qfactory.geom.square.SquareFindPerimeterKnownLength;

/**
 * 
 * @author ewien Game level factory for geometry problems
 *
 */
public class GeomGameLevel {
	public static List<GameLevel> createGameLevels(Locale loc) {
		ResourceBundle bundle = ResourceBundle.getBundle("lang.langbundle", loc);

		List<GameLevel> lgl = new ArrayList<GameLevel>();
		String name, desc;
		GameLevel g;

		// identify 2d shapes
		name = bundle.getString("geom.shape2d.level.identify.title");
		desc = bundle.getString("geom.shape2d.level.identify.desc");
		g = GameLevel.createSingleQF(0, name, desc, new WhichGeom2DShapeQuestionFactory(loc), 7);
		lgl.add(g);

		// square
		name = bundle.getString("geom.shape2d.level.square.title");
		desc = bundle.getString("geom.shape2d.level.square.desc");
		g = GameLevel.createSingleQF(0, name, desc, new SquareBasicProperties(loc), 4);
		g.addQuestionFactory(new SquareFindAreaKnownLength(loc), 2);
		g.addQuestionFactory(new SquareFindPerimeterKnownLength(loc), 2);
		g.addQuestionFactory(new SquareFindLengthKnownArea(loc), 2);
		g.addQuestionFactory(new SquareFindLengthKnownPerimeter(loc), 2);
		lgl.add(g);

		// rectangle
		name = bundle.getString("geom.shape2d.level.rectangle.title");
		desc = bundle.getString("geom.shape2d.level.rectangle.desc");
		g = GameLevel.createSingleQF(0, name, desc, new RectangleBasicProperties(loc), 4);
		g.addQuestionFactory(new RectangleFindAreaKnownLengthWidth(loc), 2);
		g.addQuestionFactory(new RectangleFindPerimeterKnownLengthWidth(loc), 2);
		g.addQuestionFactory(new RectangleFindLengthKnownArea(loc), 2);
		g.addQuestionFactory(new RectangleFindLengthKnownPerimeter(loc), 2);
		g.addQuestionFactory(new RectangleFindDiagonalKnownLengthWidth(loc), 2);
		lgl.add(g);

		return lgl;
	}

}
