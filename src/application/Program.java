package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
//		public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		System.out.print("ROOM NUMBER: ");
		int number = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

//		if (!checkOut.after(checkIn)) {
//			System.out.println("Erro data de saida nao pode ser menor que a data de entrada");

//		}else {
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println(reservation);

		System.out.println();
		System.out.println("Entre com a atualização das datas");

		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());

		System.out.print("Check-Out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());

//			String error = reservation.updateDates(checkIn, checkOut);
		reservation.updateDates(checkIn, checkOut);
//			if (error != null) {
//				System.out.println("erro em reserva " + error);
//				}else {
		System.out.println(reservation);
//			}
//
//		}
//		
		}
		catch (ParseException e) {
			System.out.println("Data Invalida");
		}
//		catch (IllegalArgumentException e) {
		catch (DomainException e) {
			System.out.println("Erro em reserva: " + e.getMessage());
		}

		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();

	}

}
