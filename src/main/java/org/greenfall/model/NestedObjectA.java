package org.greenfall.model;

import org.apache.commons.lang3.StringUtils;
import org.greenfall.exception.GenericBuilderException;

public class NestedObjectA {
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) throws GenericBuilderException {
        if (StringUtils.isEmpty(a)) {
            throw new GenericBuilderException("empty input argument");
        }
        this.a = a;
    }
}
