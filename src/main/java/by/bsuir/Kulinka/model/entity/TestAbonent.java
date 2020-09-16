package by.bsuir.Kulinka.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "abonents")
public class TestAbonent
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    public TestAbonent()
    {

    }

    public TestAbonent(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
