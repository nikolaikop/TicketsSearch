package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Search implements Comparable<Search>{

    private int id;
    private int price;
    private String from;
    private String to;
    private int flightTime;

    @Override
    public int compareTo(Search o) {
        return price - o.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return id == search.id &&
                price == search.price &&
                flightTime == search.flightTime &&
                from.equals(search.from) &&
                to.equals(search.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, flightTime);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", flightTimeInMinutes=" + flightTime +
                '}';
    }
}
