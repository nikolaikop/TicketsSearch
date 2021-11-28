package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.ComparatorSearch;
import ru.netology.domain.Search;
import ru.netology.repository.RepositorySearch;

import static org.junit.jupiter.api.Assertions.*;

class ManagerSearchTest {

    RepositorySearch repository = new RepositorySearch();
    ManagerSearch search = new ManagerSearch(repository);
    ComparatorSearch comparator = new ComparatorSearch();

    Search search1 = new Search(1, 8000, "LED", "KUF", 420);
    Search search2 = new Search(2, 4000, "SVO", "LAX", 360);
    Search search3 = new Search(3, 2000, "LED", "KHV", 300);
    Search search4 = new Search(4, 1000, "LED", "SVO", 240);
    Search search5 = new Search(5, 500, "LED", "KHV", 180);
    Search search6 = new Search(6, 250, "SVO", "LED", 120);
    Search search7 = new Search(7, 125, "KUF", "SVO", 60);

    @BeforeEach
    public void setUp() {
        search.add(search2);
        search.add(search1);
        search.add(search4);
        search.add(search6);
        search.add(search7);
        search.add(search5);
        search.add(search3);
    }

    @Test
    void sortIfFlightIsFoundFew() {
        Search[] expected = {search5, search3};
        Search[] actual = search.findAll("LED", "KHV", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortIfFlightIstFoundOne() {
        Search[] expected = {search6};
        Search[] actual = search.findAll("SVO", "LED", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortIfFlightIsNotFound() {
        Search[] expected = {};
        Search[] actual = search.findAll("LED", "LAX", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortIfFlightIsEmpty() {
        Search[] expected = {};
        Search[] actual = search.findAll("", "", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}