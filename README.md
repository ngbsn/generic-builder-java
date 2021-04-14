# Description
Implementation of builder pattern for building complex objects containing nested objects. 

The GenericObjectBuilder.of() takes in 1 argument - the reference to constructor of the ComplexObject.

The GenericObjectBuilder.andThen() takes in 2 arguments:
  1. A Setter in ComplexObject, to set the NestedObject.
  2. Another GenericObjectBuilder for building the NestedObject

If instead of a NestedObject, there is a simple property to be set, GenericObjectBuilder has an overloaded method to accept the simple property as 2nd argument.

The builder uses a extended BiConsumer functional Interface that catches checked Exceptions and throws RuntimeExceptions.

# Usage

```
String value = "Hello world";
ComplexObject complexObject = GenericObjectBuilder.of(ComplexObject::new)
                             .andThen(ComplexObject::setNestedObjectA,
                                      GenericObjectBuilder.of(NestedObjectA::new).andThen(NestedObjectA::setA, value))
                             .andThen(ComplexObject::setNestedObjectB,
                                     GenericObjectBuilder.of(NestedObjectB::new).andThen(NestedObjectB::setB, value))
                             .build();
```                           
                           
                        
                
