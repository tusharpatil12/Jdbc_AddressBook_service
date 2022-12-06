package bridgeLabz.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_Update {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/addressbook";
		String username = "root";
		String password = "Aditya@120";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement("update from contacts where(?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("Enter id :");
				int id = Integer.parseInt(br.readLine());
				;

				System.out.println("Enter Name :");
				String name = br.readLine();

				System.out.println("Enter Age :");
				int age = Integer.parseInt(br.readLine());
				;

				System.out.println("Enter Gender :");
				String gender = br.readLine();

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, age);
				ps.setString(4, gender);

				int count = ps.executeUpdate();
				if (count > 0)
					System.out.println(count + " Record inserted");
				else
					System.out.println("Record Not inserted");

				System.out.println("Do you want to insert more records-[yes/No]");
				String ch = br.readLine();
				if (ch.equalsIgnoreCase("no"))
					break;
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
