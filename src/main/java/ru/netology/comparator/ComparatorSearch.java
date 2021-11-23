package ru.netology.comparator;

import ru.netology.domain.Search;

import java.util.Comparator;

public class ComparatorSearch implements Comparator<Search> {

    public int compare(Search o1, Search o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}
