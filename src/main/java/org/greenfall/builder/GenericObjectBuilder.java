package org.greenfall.builder;

import org.greenfall.interfaces.CustomBiConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericObjectBuilder<T> {


    private final List<Consumer<T>> propSetters = new ArrayList<>();
    private final Supplier<T> constructor;

    public GenericObjectBuilder(Supplier<T> constructor) {
        this.constructor = constructor;
    }

    public static <T, E extends Exception> GenericObjectBuilder<T> of(Supplier<T> instantiator) {
        return new GenericObjectBuilder<>(instantiator);
    }

    public <U, E extends Exception> GenericObjectBuilder<T> andThen(CustomBiConsumer<T, U, E> biConsumer, GenericObjectBuilder<U> builder) {
        Consumer<T> c = instance -> biConsumer.accept(instance, builder.build());
        propSetters.add(c);
        return this;
    }

    public <R, E extends Exception> GenericObjectBuilder<T> andThen(CustomBiConsumer<T, R, E> biConsumer, R r) {
        Consumer<T> c = instance -> biConsumer.accept(instance, r);
        propSetters.add(c);
        return this;
    }

    public T build() {
        T object = constructor.get();
        propSetters.forEach(propSetter -> propSetter.accept(object));
        propSetters.clear();
        return object;
    }
}
