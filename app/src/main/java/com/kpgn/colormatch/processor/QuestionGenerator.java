package com.kpgn.colormatch.processor;

import com.kpgn.colormatch.constant.ApplicationConstant;
import com.kpgn.colormatch.entity.QuestionEntity;
import com.kpgn.colormatch.utility.TextUtil;

public class QuestionGenerator {

    private static int arrayLength;

    static {
        arrayLength = ApplicationConstant.COLOR_TEXT.length - 1;
    }

    public static QuestionEntity getQuestion() {
        String tempTextA = ApplicationConstant.COLOR_TEXT[TextUtil.getRandomInt(0, arrayLength)];
        String tempTextBColor = tempTextA;
        if (TextUtil.getRandomInt(111, 999) % 2 == 0) {
            tempTextBColor = ApplicationConstant.COLOR_TEXT[TextUtil.getRandomInt(0, arrayLength)];
        }

        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setTextA(tempTextA);
        questionEntity.setTextAColor(ApplicationConstant.COLOR_TEXT[TextUtil.getRandomInt(0, arrayLength)]);
        questionEntity.setTextB(ApplicationConstant.COLOR_TEXT[TextUtil.getRandomInt(0, arrayLength)]);
        questionEntity.setTextBColor(tempTextBColor);
        questionEntity.setCorrect(tempTextA.equalsIgnoreCase(tempTextBColor));

        return questionEntity;
    }

}
