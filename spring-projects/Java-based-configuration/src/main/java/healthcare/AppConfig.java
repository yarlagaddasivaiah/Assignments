package healthcare;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DoctorRepository doctorRepository() {
        return new DoctorRepository();
    }

    @Bean
    public AppointmentService appointmentService() {
        AppointmentService service = new AppointmentService();
        service.setDoctorRepository(doctorRepository()); // Setter injection
        return service;
    }
}
