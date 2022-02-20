package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {
    Repository repositoryM = new Repository();

    public void save(Ticket ticket) {
        repositoryM.add(ticket);
    }

    public Ticket[] searchBy(String from, String of) {
        Ticket[] result = new Ticket[0];
        for (Ticket tik : repositoryM.findAll()) {
            Ticket[] temp = new Ticket[result.length + 1];
            if (of == tik.getAirportTo() || from == tik.getAirportFrom()) {
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = tik;
                result = temp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}