package com.example.bootstrap;

import com.example.entity.Account;
import com.example.repository.*;
import com.example.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public DataGenerator(AccountRepository accountRepository, CinemaRepository cinemaRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();

        System.out.println(accountRepository.findAllByCountryOrState("United States", "New York"));

        System.out.println(accountRepository.getAllAdminAccounts());
        System.out.println(cinemaRepository.distinctBySponsorName("Kodak"));
        System.out.println(movieRepository.fetchAllMovieNames());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
        System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.fetchAllTicketsByUserAccount(4L));
//        System.out.println(ticketRepository.fetchAllTicketsWithRangeOfDates());
//        System.out.println(ticketRepository.f);

        System.out.println(userRepository.findAllByAccountAgeGreaterThan(18));
        System.out.println(userRepository.retrieveAllUsersInRangeOfAge(32,38));



    }
}
