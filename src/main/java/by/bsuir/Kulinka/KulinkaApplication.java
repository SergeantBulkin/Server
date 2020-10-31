package by.bsuir.Kulinka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
@RestController
public class KulinkaApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(KulinkaApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return String.format("Hello %s!", name);
	}

	@GetMapping("/db")
	public String helloDB(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		String url = "jdbc:mysql://localhost/abonents?serverTimezone=Europe/Minsk";
		String username = "root";
		String password = "root";
		String query = "SELECT user_profile.user_name,abonent.mobile_number,abonent.balance,user_profile.age FROM user_profile INNER JOIN abonent ON user_profile.id = abonent.user_id";
		StringBuilder response = new StringBuilder();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next())
			{
				response.append(resultSet.getString(1)).append(" ").append(resultSet.getString(2)).append("\n");
				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
			}
		}
		catch (ClassNotFoundException notFoundException)
		{
			notFoundException.printStackTrace();
		}
		catch(Exception ex){
			System.out.println("Connection failed...");

			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return response.toString();
	}
}