package karate;

import com.intuit.karate.junit5.Karate;

class ScheduledPaymentsTest {

    @Karate.Test
    Karate testAll() {
        // Ejecucuta todos los tests alojados con los correspondientes tags y rutas
        return Karate.run().relativeTo(getClass());
    }    
}
