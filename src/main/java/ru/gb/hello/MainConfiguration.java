package ru.gb.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("ru.gb.service")
public class MainConfiguration {
}
