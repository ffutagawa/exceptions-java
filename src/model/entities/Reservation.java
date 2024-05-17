package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer rooNumber;
	private Date checkIn;
	private Date chekOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer rooNumber, Date checkIn, Date checkOut) {
		 if (!checkOut.after(checkIn)) {
			 throw new DomainException("Erro: data de checkout não poder anterior a data checkIn");
		}		
		
		this.rooNumber = rooNumber;
		this.checkIn = checkIn;
		this.chekOut = chekOut;
	}

	public Integer getRooNumber() {
		return rooNumber;
	}

	public void setRooNumber(Integer rooNumber) {
		this.rooNumber = rooNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getChekOut() {
		return chekOut;
	}

	public long duration() {
		long diff = chekOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

//	public String updateDates (Date checkIn, Date checkOut) {
	public void updateDates (Date checkIn, Date checkOut){

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
//				return "ERRO: datas nao aceitas para reserva";
////				throw new IllegalArgumentException("datas nao aceitas para reserva");
				throw new DomainException("datas nao aceitas para reserva");
			}	
			 if (!checkOut.after(now)) {
//				return "Erro: data de checkout não poder anterior a data checkIn ";
////				 throw new IllegalArgumentException("Erro: data de checkout não poder anterior a data checkIn");
				 throw new DomainException("Erro: data de checkout não poder anterior a data checkIn");
			}
		
		this.checkIn = checkIn;
		this.chekOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + rooNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(chekOut) + ", "
				+ duration() + " nights";

	}

}
