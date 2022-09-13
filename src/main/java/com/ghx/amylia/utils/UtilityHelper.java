package com.ghx.amylia.utils;

import com.ghx.amylia.models.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class UtilityHelper {

    public static List<Record> generateRecords() {
        List<Record> records = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            records.add(createSampleRecord());
        }
        return records;
    }

    public static Record createSampleRecord() {
        Procedure procedure = generateProcedure();
        return Record.builder()
                .id(UUID.randomUUID())
                .hospital(generateHospital().getName())
                .physician(generatePhysician().getName())
                .category(procedure.getCategory().getName())
                .procedureName(procedure.getName())
                .procedureCost(generateRandomBigDecimal())
                //.procedureDate()
                .build();
    }

    public static List<Hospital> listAllHospitals() {
        return Arrays.asList(
                Hospital.builder().id(1).name("Parker Adventist").build(),
                Hospital.builder().id(2).name("Anschultz Medical").build(),
                Hospital.builder().id(3).name("Northrop Medical").build(),
                Hospital.builder().id(4).name("Wellington Medical").build(),
                Hospital.builder().id(5).name("Aurora Medical").build(),
                Hospital.builder().id(6).name("Fargo Clinical").build()
        );
        //return Arrays.asList("Parker Adventist", "Anschultz Medical", "Northrop Medical", "Wellington Medical", "Aurora Medical", "Fargo Clinical");
    }

    public static List<Procedure> listAllProcedures() {
        return Arrays.asList(
                Procedure.builder()
                        .id(1).name("Appendectomy")
                        .category(Category.builder().name("Appendix").build())
                        .build(),
                Procedure.builder()
                        .id(2)
                        .name("Coronary Artery Bypass")
                        .category(Category.builder().name("Cardiac").build())
                        .build(),
                Procedure.builder()
                        .id(3).name("Carotid Endarterectomy")
                        .category(Category.builder().name("Appendix").build())
                        .build(),
                Procedure.builder()
                        .id(4).name("Cataract Surgery")
                        .category(Category.builder().name("Vision").build())
                        .build(),
                Procedure.builder()
                        .id(5).name("Hysteroscopy")
                        .category(Category.builder().name("Appendix").build())
                        .build(),
                Procedure.builder()
                        .id(6).name("Prostatectomy")
                        .category(Category.builder().name("Prostrate").build())
                        .build()
        );
        //return Arrays.asList("Appendectomy", "Coronary Artery Bypass", "Carotid Endarterectomy", "Cataract Surgery", "Hysteroscopy", "Prostatectomy");
    }



    public static List<Physician> listAllPhysicians() {
        return Arrays.asList(
                Physician.builder()
                        .id(1)
                        .name("Adam Weinstein")
                        .build(),
                Physician.builder()
                        .id(2)
                        .name("Michelle Baxter")
                        .build(),
                Physician.builder()
                        .id(3)
                        .name("Kabir Roy")
                        .build(),
                Physician.builder()
                        .id(4)
                        .name("Davis Graham")
                        .build(),
                Physician.builder()
                        .id(5)
                        .name("Brian Temple")
                        .build()
        );
    }

    private static BigDecimal generateRandomBigDecimal() {
        double min = 10000.00;
        double max = 100000.00;
        Random r = new Random();
        double d = min + (max - min) * r.nextDouble();
        return new BigDecimal(d).setScale(2, RoundingMode.UP);
    }

    private static Physician generatePhysician() {
        List<Physician> physicians = listAllPhysicians();
        Random rand = new Random();
        return physicians.get(rand.nextInt(physicians.size()));
    }


    private static Hospital generateHospital() {
        List<Hospital> hospitalNames = listAllHospitals();
        Random rand = new Random();
        return hospitalNames.get(rand.nextInt(hospitalNames.size()));
    }

    private static Procedure generateProcedure() {
        List<Procedure> procedureNames = listAllProcedures();
        Random rand = new Random();
        return procedureNames.get(rand.nextInt(procedureNames.size()));
    }


    /*private static String generateDate() {
        long aDay = TimeUnit.DAYS.toMillis(1);
        long now = new Date().getTime();
        Date hundredYearsAgo = new Date(now - aDay * 365 * 100);
        Date tenDaysAgo = new Date(now - aDay * 10);
        Date random = LegacyRandomDateTimes.between(hundredYearsAgo, tenDaysAgo);
    }*/
}
