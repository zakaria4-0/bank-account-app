package net.kerouad.customerservice;

import net.kerouad.customerservice.config.GlobalConfig;
import net.kerouad.customerservice.entities.Customer;
import net.kerouad.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList=List.of(
					Customer.builder()
							.firstName("Hassan")
							.lastName("Elhoumi")
							.email("hassan@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Mohamed")
							.lastName("Elhannaoui")
							.email("hassan@gmail.com")
							.build()

			);
			customerRepository.saveAll(customerList);
		};
	}

}
