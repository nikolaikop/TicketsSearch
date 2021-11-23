package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Search;
import ru.netology.repository.RepositorySearch;

import static org.junit.jupiter.api.Assertions.*;

class ManagerSearchTest {

    RepositorySearch repository = new RepositorySearch();
    ManagerSearch search = new ManagerSearch(repository);

    Search search1 = new Search(1, 4000, "LED", "KUF", 240);
    Search search2 = new Search(2, 3000, "SVO", "LAX", 180);
    Search search3 = new Search(3, 2000, "LED", "KHV", 120);
    Search search4 = new Search(4, 1000, "LED", "SVO", 60);

    @BeforeEach
    public void setUp() {
        search.add(search1);
        search.add(search2);
        search.add(search3);
        search.add(search4);
    }

    @Test
    void sortIfFlightIsFound() {
        Search[] expected = {search3};
        Search[] actual = search.findAll("LED", "KHV");
        Assertions.assertArrayEquals(expected, actual);
    }

}