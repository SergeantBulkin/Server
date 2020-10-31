package by.bsuir.Kulinka.model;

import java.util.List;

public class Question
{
    //----------------------------------------------------------------------------------------------
    String questionText;
    List<Answer> answers;
    //----------------------------------------------------------------------------------------------
    public Question(String questionText, List<Answer> answers)
    {
        this.questionText = questionText;
        this.answers = answers;
    }
    //----------------------------------------------------------------------------------------------
    public String getQuestionText()
    {
        return questionText;
    }

    public List<Answer> getAnswers()
    {
        return answers;
    }
    //----------------------------------------------------------------------------------------------
}
