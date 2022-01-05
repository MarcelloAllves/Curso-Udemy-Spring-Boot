package Principal.Main;

import Principal.Entity.Cliente;
import Principal.Repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando clientes");
            clientes.salvar(new Cliente("Marcelo"));
            clientes.salvar(new Cliente("Alice"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}