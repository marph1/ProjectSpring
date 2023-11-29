package com.capacitacao.aulas.springweb.config;

import com.capacitacao.aulas.springweb.entities.Category;
import com.capacitacao.aulas.springweb.entities.Order;
import com.capacitacao.aulas.springweb.entities.User;
import com.capacitacao.aulas.springweb.entities.enums.OrderStatus;
import com.capacitacao.aulas.springweb.repositories.CategoryRepository;
import com.capacitacao.aulas.springweb.repositories.OrderRepository;
import com.capacitacao.aulas.springweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category("Electronics");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.DELIVERED, u2);
        Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
