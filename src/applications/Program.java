package applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		//a data de checkOut tem q ser posterior a data de checkIn
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data checkOut deve ser depois da data checkIn");
		}
		else {
			Reservation reserv = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			
			System.out.println();
			System.out.println("Entre como nova data para atualizar a reserva:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//como testar se as datas de atualização são posterior as datas atuais?
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.print("Erro na reserva: as datas para atualização devem ser futuras");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data checkOut deve ser depois da data checkIn");
			}
			else {
				reserv.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reserv);
			}		
		}		
		sc.close();
	}
}