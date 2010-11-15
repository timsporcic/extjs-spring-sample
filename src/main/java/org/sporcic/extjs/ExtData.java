package org.sporcic.extjs;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * An ExtResponse subclass which contains a list of data, along with
 * a total count. This is usefully for working with ExtJS Stores so that
 * you don't need to build your own Map to return. The fields will be
 * serialized by Jackson JSON in the JSON format as long as you annotate
 * the controller method return value as @ResponseBody.
 */
public class ExtData extends ExtResponse {

    @JsonProperty("data")
    private final List<Object> data = new ArrayList<Object>();

    @JsonProperty("total")
    private int total = 0;

    /**
     * Add a single Object to the data array
     * @param item the Object to add to the array
     */
    public void add(Object item) {

        if(item != null) {
            data.add(item);
            total++;
        }

    }

    /**
     * Convenience method to add a list of items to the returned data array
     * @param list the list to add to the array
     */
    public void add(List<Object> list) {

        for(Object item : list) {
            add(item);
        }
    }
}
