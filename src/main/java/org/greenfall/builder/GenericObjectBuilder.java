package org.greenfall.builder;

import org.greenfall.interfaces.CustomBiConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericObjectBuilder<T> {

    private final Supplier<T> instantiator;

    private final List<Consumer<T>> parseBuilders = new ArrayList<>();

    public GenericObjectBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T, E extends Exception> GenericObjectBuilder<T> of(Supplier<T> instantiator) {
        return new GenericObjectBuilder<>(instantiator);
    }

    public <U, E extends Exception> GenericObjectBuilder<T> andThen(CustomBiConsumer<T, U, E> biConsumer, GenericObjectBuilder<U> builder) {
        Consumer<T> c = instance -> biConsumer.accept(instance, builder.build());
        parseBuilders.add(c);
        return this;
    }

    public <R, E extends Exception> GenericObjectBuilder<T> andThen(CustomBiConsumer<T, R, E> biConsumer, R r) {
        Consumer<T> c = instance -> biConsumer.accept(instance, r);
        parseBuilders.add(c);
        return this;
    }


    public T build() {
        T object = instantiator.get();
        parseBuilders.forEach(modifier -> modifier.accept(object));
        parseBuilders.clear();
        return object;
    }
}
