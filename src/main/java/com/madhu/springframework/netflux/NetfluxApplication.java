package com.madhu.springframework.netflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class NetfluxApplication {

    public static void main(String[] args) {
        System.setProperty("os.arch", "x86_64");
        SpringApplication.run(NetfluxApplication.class, args);
    }

}
