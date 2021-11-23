package ru.netology.manager;

import ru.netology.domain.Search;
import ru.netology.repository.RepositorySearch;

import java.util.Arrays;

public class ManagerSearch {

    private RepositorySearch repositorySearch;

    public ManagerSearch(RepositorySearch repositorySearch) {
        this.repositorySearch = repositorySearch;
    }

    public void add(Search search) {
        repositorySearch.add(search);
    }

    public Search[] findAll(String from, String to) {
        Search[] result = new Search[0];
        for (Search ticket : repositorySearch.getAll()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                Search[] tmp = new Search[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
