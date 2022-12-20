package com.epam.mjc;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class CollectionService {

    public List<Integer> filterEvenNumbers(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public Optional<Integer> findMax(List<Integer> list) {
        OptionalInt maxInt = list.stream().mapToInt(Integer::intValue).max();
        if(maxInt.isPresent())
            return Optional.of(maxInt.getAsInt());
        return Optional.empty();
    }

    public Optional<Integer> findMin(List<List<Integer>> list) {
        OptionalInt minInt = list.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).min();
        if(minInt.isPresent())
            return Optional.of(minInt.getAsInt());
        return Optional.empty();
    }

    public Integer sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
