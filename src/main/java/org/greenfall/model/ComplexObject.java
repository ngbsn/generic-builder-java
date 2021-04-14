package org.greenfall.model;

import org.greenfall.exception.GenericBuilderException;

public class ComplexObject {

    private NestedObjectA nestedObjectA;
    private NestedObjectB nestedObjectB;

    public NestedObjectA getNestedObjectA() {
        return nestedObjectA;
    }

    public void setNestedObjectA(NestedObjectA nestedObjectA) throws GenericBuilderException {
        if (nestedObjectA == null) {
            throw new GenericBuilderException("input arg is null");
        }
        this.nestedObjectA = nestedObjectA;
    }

    public NestedObjectB getNestedObjectB() {
        return nestedObjectB;
    }

    public void setNestedObjectB(NestedObjectB nestedObjectB) throws GenericBuilderException {
        if (nestedObjectB == null) {
            throw new GenericBuilderException("input arg is null");
        }
        this.nestedObjectB = nestedObjectB;
    }
}
