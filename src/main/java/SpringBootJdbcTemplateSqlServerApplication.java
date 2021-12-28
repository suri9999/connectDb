import java.util.List;

import com.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateSqlServerApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcTemplateSqlServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello....");
        String sql = "SELECT * FROM customers";
        List<Customer> customers = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Customer.class));

        customers.forEach(System.out :: println);
    }

}