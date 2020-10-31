package by.bsuir.Kulinka.model.entity.quiz;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryDB
{
    //------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    //------------------------------------------------------------------------------------------------------------------
    public CategoryDB()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //Геттеры
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Сеттеры
    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    //------------------------------------------------------------------------------------------------------------------
}