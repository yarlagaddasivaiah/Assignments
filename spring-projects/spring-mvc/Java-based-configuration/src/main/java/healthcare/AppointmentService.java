package healthcare;


import java.time.LocalDate;

public class AppointmentService {

    private DoctorRepository doctorRepository;

    // Setter injection
    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public String book(String doctorId, String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);

        if (doctorRepository.isDoctorAvailable(doctorId, date)) {
            return "Appointment confirmed";
        } else {
            return "Doctor not available";
        }
    }
}
