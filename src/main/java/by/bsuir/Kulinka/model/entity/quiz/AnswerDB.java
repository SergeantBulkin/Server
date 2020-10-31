package by.bsuir.Kulinka.model.entity.quiz;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class AnswerDB
{
    //------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String answer_text;
    private int is_correct;
    private int question_id;
    private int category_id;
    //------------------------------------------------------------------------------------------------------------------
    public AnswerDB()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //Геттеры
    public int getId()
    {
        return id;
    }

    public String getAnswer_text()
    {
        return answer_text;
    }

    public int getIs_correct()
    {
        return is_correct;
    }

    public int getQuestion_id()
    {
        return question_id;
    }

    public int getCategory_id()
    {
        return category_id;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Сеттеры
    public void setId(int id)
    {
        this.id = id;
    }

    public void setAnswer_text(String answer_text)
    {
        this.answer_text = answer_text;
    }

    public void setIs_correct(int is_correct)
    {
        this.is_correct = is_correct;
    }

    public void setQuestion_id(int question_id)
    {
        this.question_id = question_id;
    }

    public void setCategory_id(int category_id)
    {
        this.category_id = category_id;
    }
    //------------------------------------------------------------------------------------------------------------------
}
