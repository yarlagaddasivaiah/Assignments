
package healthcare;

import java.time.LocalDate;
import java.util.*;

public class DoctorRepository {

    private Map<String, List<LocalDate>> doctorSchedule = new HashMap<>();

    public DoctorRepository() {
        // Sample data: doctor DOC101 is available on 2025-04-10 and 2025-04-15
        doctorSchedule.put("DOC101", Arrays.asList(
            LocalDate.of(2025, 4, 10),
            LocalDate.of(2025, 4, 15)
        ));
    }

    public boolean isDoctorAvailable(String doctorId, LocalDate date) {
        List<LocalDate> availableDates = doctorSchedule.get(doctorId);
        return availableDates != null && availableDates.contains(date);
    }
}
