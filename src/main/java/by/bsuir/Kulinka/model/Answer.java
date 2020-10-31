package by.bsuir.Kulinka.model;

public class Answer
{
    //----------------------------------------------------------------------------------------------
    String answerText;
    int isCorrect;
    //----------------------------------------------------------------------------------------------
    public Answer(String answerText, int isCorrect)
    {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }
    //----------------------------------------------------------------------------------------------
    public String getAnswerText()
    {
        return answerText;
    }

    public int getIsCorrect()
    {
        return isCorrect;
    }
    //----------------------------------------------------------------------------------------------
}
