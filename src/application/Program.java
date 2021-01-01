package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date ckeckIn = sdf.parse(sc.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date ckeckOut = sdf.parse(sc.next());

		if (!ckeckOut.after(ckeckIn)) {
			System.out.println("Error in reservation: Ckeck-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, ckeckIn, ckeckOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			ckeckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			ckeckOut = sdf.parse(sc.next());

			Date now = new Date();
			if (ckeckIn.before(now) || ckeckOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!ckeckOut.after(ckeckIn)) {
				System.out.println("Error in reservation: Ckeck-out date must be after check-in date");
			} else {
				reservation.updateDates(ckeckIn, ckeckOut);
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();
	}

}
