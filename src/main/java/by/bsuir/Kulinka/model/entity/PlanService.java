package by.bsuir.Kulinka.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "plan_service")
public class PlanService
{
    //------------------------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int plan_id;
    private int service_id;
    //------------------------------------------------------------------------------------------------------------------
    public PlanService()
    {

    }

    public PlanService(int plan_id, int service_id)
    {
        this.plan_id = plan_id;
        this.service_id = service_id;
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

    public int getPlan_id()
    {
        return plan_id;
    }

    public void setPlan_id(int plan_id)
    {
        this.plan_id = plan_id;
    }

    public int getService_id()
    {
        return service_id;
    }

    public void setService_id(int service_id)
    {
        this.service_id = service_id;
    }
    //------------------------------------------------------------------------------------------------------------------
}
