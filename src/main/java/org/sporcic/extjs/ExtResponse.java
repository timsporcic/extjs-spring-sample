package org.sporcic.extjs;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Base class which represents a minimal payload to be returned
 * to an ExtJS AJAX request, containing the success flag and an optional
 * message.
 * These fields will be serialized by Jackson JSON in the JSON format as
 * long as you annotate the controller method return value as @ResponseBody.
 */
public class ExtResponse {

    /**
     * Simple Success response which can be used for custom ajax calls
     */
    public final static ExtResponse SUCCESS = new ExtResponse(true, null);

    protected String message = null;

    protected boolean success = false;

    public ExtResponse() {
        //no-op constructor
    }

    public ExtResponse(boolean success) {
        this(success,null);
    }

    public ExtResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
