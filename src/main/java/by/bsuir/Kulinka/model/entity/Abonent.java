package by.bsuir.Kulinka.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "abonent")
public class Abonent
{
    //------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String lastname;
    private String name;
    private int age;
    private String mobile_number;
    private int plan_id;
    private float balance;
    private String address;
    private Date create_date;
    //------------------------------------------------------------------------------------------------------------------
    public Abonent()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getMobile_number()
    {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number)
    {
        this.mobile_number = mobile_number;
    }

    public int getPlan_id()
    {
        return plan_id;
    }

    public void setPlan_id(int plan_id)
    {
        this.plan_id = plan_id;
    }

    public float getBalance()
    {
        return balance;
    }

    public void setBalance(float balance)
    {
        this.balance = balance;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Date getCreate_date()
    {
        return create_date;
    }

    public void setCreate_date(Date create_date)
    {
        this.create_date = create_date;
    }
    //------------------------------------------------------------------------------------------------------------------
}
