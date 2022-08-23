package com.madhu.springframework.netflux.bootstrap;

import com.madhu.springframework.netflux.domain.Movie;
import com.madhu.springframework.netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(Flux.just("Silence of the lambs", "The Terminator")
                        .map(Movie::new)
                        .flatMap(movieRepository::save)
                )
                .subscribe(null,null,()->{
            movieRepository.findAll().subscribe(System.out::println);
        });
    }
}
