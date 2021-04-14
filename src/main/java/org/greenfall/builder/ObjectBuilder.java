package org.greenfall.builder;

import org.greenfall.model.ComplexObject;
import org.greenfall.model.NestedObjectA;
import org.greenfall.model.NestedObjectB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(org.greenfall.builder.ObjectBuilder.class);

    private ObjectBuilder() {

    }

    public static ComplexObject buildComplexObject(String value) {
        LOGGER.info("Building complex object with value {}", value);
        return GenericObjectBuilder.of(ComplexObject::new)
                .andThen(ComplexObject::setNestedObjectA,
                        GenericObjectBuilder.of(NestedObjectA::new).andThen(NestedObjectA::setA, value))
                .andThen(ComplexObject::setNestedObjectB,
                        GenericObjectBuilder.of(NestedObjectB::new).andThen(NestedObjectB::setB, value))
                .build();
    }
}
