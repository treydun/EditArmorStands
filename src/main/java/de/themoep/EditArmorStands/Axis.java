package de.themoep.EditArmorStands;

import java.util.Arrays;

/**
 * Created by Phoenix616 on 19.03.2015.
 */
public enum Axis {
    YAW     (new String[]{"y, heading, h"}),
    PITCH   (new String[]{"p, elevation, e"}),
    ROLL    (new String[]{"r, bank, b"});

    private String[] alias;

    private static String valuestring = Arrays.toString(Axis.values());
    
    Axis(String[] alias) {
        this.alias = alias;
    }

    public static Axis fromString(String name) throws IllegalArgumentException {
        if (name == null)
            throw new NullPointerException("Name is null");
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            for(Axis x : values())
                for(String a : x.alias)
                    if(a.equalsIgnoreCase(name))
                        return x;
        }
        throw new IllegalArgumentException(name + " is not an axis! Available axis are " + valuestring.toLowerCase().substring(1, valuestring.length() - 1));
    }
}
