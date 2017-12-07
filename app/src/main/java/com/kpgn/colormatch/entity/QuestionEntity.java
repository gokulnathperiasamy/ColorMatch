package com.kpgn.colormatch.entity;


public class QuestionEntity {

    private String textA;
    private String textAColor;
    private String textB;
    private String textBColor;
    private boolean isCorrect;

    public String getTextA() {
        return textA;
    }

    public void setTextA(String textA) {
        this.textA = textA;
    }

    public String getTextAColor() {
        return textAColor;
    }

    public void setTextAColor(String textAColor) {
        this.textAColor = textAColor;
    }

    public String getTextB() {
        return textB;
    }

    public void setTextB(String textB) {
        this.textB = textB;
    }

    public String getTextBColor() {
        return textBColor;
    }

    public void setTextBColor(String textBColor) {
        this.textBColor = textBColor;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
