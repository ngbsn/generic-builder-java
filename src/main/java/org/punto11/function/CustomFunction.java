package org.punto11.function;

import org.punto11.exception.GenericBuilderException;
import java.util.function.Function;

@FunctionalInterface
public interface CustomFunction<T, R, E extends Exception> extends Function<T, R> {

    R call(T t) throws E;

    @Override
    default R apply(T t) {
        try{
            return call(t);
        }catch (Exception e){
            throw new GenericBuilderException("");
        }
    }
}
