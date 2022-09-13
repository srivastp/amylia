package com.ghx.amylia.utils;

import com.ghx.amylia.models.Record;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class UtilityHelper {

    public static List<Record> generateRecords() {
        List<Record> records = new ArrayList<>();
        for (int i = 0; i<100; i++) {
            records.add(createSampleRecord());
        }
        return records;
    }

    public static Record createSampleRecord() {
        return Record.builder()
                .id(UUID.randomUUID())
                .hospitalName(generateHospitalName())
                .physicianFirstName(generateFirstName())
                .physicianLastName(generateLastName())
                .procedure(generateProcedureName())
                .cost(generateRandomDouble())
                //.procedureDate()
                .build();
    }

    private static BigDecimal generateRandomDouble() {
        double min = 10000.00;
        double max = 100000.00;
        Random r = new Random();
        double d = min + (max - min) * r.nextDouble();
        return new BigDecimal(d).setScale(2, RoundingMode.UP);
    }

    private static String generateFirstName() {
        List<String> firstNames = Arrays.asList("Adam", "John", "Michelle", "David", "Kabir", "Brian");
        Random rand = new Random();
        return firstNames.get(rand.nextInt(firstNames.size()));
    }

    private static String generateLastName() {
        List<String> lastNames = Arrays.asList("Weinstein", "Doe", "Parker", "Graham", "Roy", "Temple");
        Random rand = new Random();
        return lastNames.get(rand.nextInt(lastNames.size()));
    }

    private static String generateHospitalName() {
        List<String> hospitalNames = Arrays.asList("Parker Adventist", "Anschultz Medical", "Northrop Medical", "Wellington Medical", "Aurora Medical", "Fargo Clinical");
        Random rand = new Random();
        return hospitalNames.get(rand.nextInt(hospitalNames.size()));
    }

    private static String generateProcedureName() {
        List<String> procedureNames = Arrays.asList("Appendectomy", "Coronary Artery Bypass", "Carotid Endarterectomy", "Cataract Surgery", "Hysteroscopy", "Prostatectomy");
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
