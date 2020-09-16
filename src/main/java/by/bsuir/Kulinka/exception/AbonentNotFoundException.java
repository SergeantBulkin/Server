package by.bsuir.Kulinka.exception;

import java.util.function.Supplier;

public class AbonentNotFoundException extends Exception
{
    private int id;

    public AbonentNotFoundException(int id)
    {
        super(String.format("TestAbonent not found with id : %s", id));
    }
}
