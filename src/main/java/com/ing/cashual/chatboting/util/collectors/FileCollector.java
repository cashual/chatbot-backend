package com.ing.cashual.chatboting.util.collectors;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class FileCollector implements Collector<String, FileCollectorBuilder, Map<String,List<String>>> {
    @Override
    public Supplier<FileCollectorBuilder> supplier() {
        return FileCollectorBuilder::new;
    }

    @Override
    public BiConsumer<FileCollectorBuilder, String> accumulator() {
        return FileCollectorBuilder::add;
    }

    @Override
    public BinaryOperator<FileCollectorBuilder> combiner() {
        return (left, right) -> left.addAll(right);
    }

    @Override
    public Function<FileCollectorBuilder, Map<String, List<String>>> finisher() {
        return FileCollectorBuilder::get;
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> characteristics = new HashSet<>();
        characteristics.add(Characteristics.UNORDERED);
        return characteristics;
    }

}


