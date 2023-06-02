package applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {
	
	// throws ParseException - excluída pq nao será mais propagada e sim tratada
	public static void main(String[] args)  {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		//method try-catch
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservation reserv = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			
			System.out.println();
			System.out.println("Entre como nova data para atualizar a reserva:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserv.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reserv);
		}	
		catch (ParseException e) {
			System.out.println("Formato de data inválido!");
		}
		catch (DomainException e) {
			//getMessage é a msg escrita na classe Reservation
			System.out.println("Erro na reserva: " + e.getMessage());
		}				
		sc.close();
	}	
}