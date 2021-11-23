package ru.netology.repository;

import ru.netology.domain.Search;

public class RepositorySearch {

    private Search[] tickets = new Search[0];

    public void add(Search search) {
        Search[] tmp = new Search[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = search;
        tickets = tmp;
    }

    public Search[] getAll() {
        return tickets;
    }

}
