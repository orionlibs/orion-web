package io.github.orionlibs.orion_web.session;

import io.github.orionlibs.orion_enumeration.OrionEnumeration;

public enum OrionUserAuthority implements OrionEnumeration
{
    Administrator("ADMINISTRATOR"),
    User("USER"),
    Anonymous("ANONYMOUS");
    private String name;


    private OrionUserAuthority(String name)
    {
        setName(name);
    }


    @Override
    public String get()
    {
        return getName();
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof OrionUserAuthority && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof OrionUserAuthority && this != other;
    }


    public static boolean valueExists(String other)
    {
        OrionUserAuthority[] values = values();
        for(OrionUserAuthority value : values)
        {
            if(value.get().equals(other))
            {
                return true;
            }
        }
        return false;
    }


    public static OrionUserAuthority getEnumForValue(String other)
    {
        OrionUserAuthority[] values = values();
        for(OrionUserAuthority value : values)
        {
            if(value.get().equals(other))
            {
                return value;
            }
        }
        return null;
    }
}