package by.bsuir.Kulinka.model.entity.abonents;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan
{
    //------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String plan_name;
    //------------------------------------------------------------------------------------------------------------------
    public Plan()
    {

    }

    public Plan(String plan_name)
    {
        this.plan_name = plan_name;
    }

    //------------------------------------------------------------------------------------------------------------------
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPlan_name()
    {
        return plan_name;
    }

    public void setPlan_name(String plan_name)
    {
        this.plan_name = plan_name;
    }
    //------------------------------------------------------------------------------------------------------------------
}

