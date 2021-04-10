package org.punto11.builder;

import org.punto11.model.ComplexObject;
import org.punto11.model.NestedObjectA;
import org.punto11.model.NestedObjectB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NestedObjectBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(NestedObjectBuilder.class);

    private NestedObjectBuilder() {

    }

    public static ComplexObject buildComplexObject(String value) {
        LOGGER.info("Building complex object with value {}", value);
        return GenericObjectBuilder.of(ComplexObject::new, value)
                .andThen(ComplexObject::setNestedObjectA, ObjectBuilder::buildNestedObjectA)
                .andThen(ComplexObject::setNestedObjectB, ObjectBuilder::buildNestedObjectB)
                .build();
    }

    private static class ObjectBuilder {
        private static NestedObjectA buildNestedObjectA(String value) throws Exception {
            NestedObjectA nestedObjectA = new NestedObjectA();
            nestedObjectA.setPropertyA(value);
            return nestedObjectA;
        }

        private static NestedObjectB buildNestedObjectB(String value) throws Exception {
            NestedObjectB nestedObjectB = new NestedObjectB();
            nestedObjectB.setPropertyB(value);
            return nestedObjectB;
        }
    }
}
