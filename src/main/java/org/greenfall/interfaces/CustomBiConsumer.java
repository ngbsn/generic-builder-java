package org.greenfall.interfaces;

import org.greenfall.exception.GenericBuilderRuntimeException;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface CustomBiConsumer<T, U, E extends Exception> extends BiConsumer<T, U> {

    void call(T t, U u) throws E;

    @Override
    default void accept(T t, U u) {
        try {
            call(t, u);
        } catch (Exception e) {
            throw new GenericBuilderRuntimeException("Error occurred");
        }
    }
}
