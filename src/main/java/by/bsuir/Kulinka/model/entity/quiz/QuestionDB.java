package by.bsuir.Kulinka.model.entity.quiz;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionDB
{
    //------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String question_text;
    private int category_id;
    //------------------------------------------------------------------------------------------------------------------
    public QuestionDB()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //Геттеры
    public Integer getId()
    {
        return id;
    }

    public String getQuestion_text()
    {
        return question_text;
    }

    public int getCategory_id()
    {
        return category_id;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Сеттеры
    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setQuestion_text(String question_text)
    {
        this.question_text = question_text;
    }

    public void setCategory_id(int category_id)
    {
        this.category_id = category_id;
    }
    //------------------------------------------------------------------------------------------------------------------
}
