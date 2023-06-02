package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	//static para não haver alteração no tipo
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		//como calcular a diferença entre duas datas?
		//user the method milliseconds
		long diff = checkOut.getTime() - checkIn.getTime();
		//como transformar para dias?
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	//vai lançar uma exception caso ocorra, assim vai voltar a ser void
	public void updateDates(Date checkIn, Date checkOut) {
		//como testar se as datas de atualização são posterior as datas atuais?
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			// uma classe que diz q os argumentos da função são inválidos
			throw new IllegalArgumentException("Erro na reserva: as datas para atualização devem ser futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Erro na reserva: a data checkOut deve ser depois da data checkIn");
		}
		//nao havendo erro as datas sao atualizadas
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}