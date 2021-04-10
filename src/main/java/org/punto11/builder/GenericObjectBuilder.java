package org.punto11.builder;

import org.punto11.function.CustomFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericObjectBuilder<T, J> {

    private final Supplier<T> instantiator;
    private final J message;

    private final List<Consumer<T>> parseBuilders = new ArrayList<>();

    public GenericObjectBuilder(Supplier<T> instantiator, J message) {
        this.instantiator = instantiator;
        this.message = message;
    }

    public static <T, J> GenericObjectBuilder<T, J> of(Supplier<T> instantiator, J message) {
        return new GenericObjectBuilder<>(instantiator, message);
    }

    public <R, E extends Exception> GenericObjectBuilder<T, J> andThen(BiConsumer<T, R> biConsumer, CustomFunction<J, R, E> function) {
        Consumer<T> c = instance -> biConsumer.accept(instance, function.apply(message));
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
