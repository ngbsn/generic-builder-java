package org.greenfall.model;

import org.apache.commons.lang3.StringUtils;
import org.greenfall.exception.GenericBuilderException;

public class NestedObjectB {
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) throws GenericBuilderException {
        if (StringUtils.isEmpty(b)) {
            throw new GenericBuilderException("empty input argument");
        }
        this.b = b;
    }
}
