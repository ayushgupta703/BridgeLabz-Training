package lambda_expression;

import java.util.*;

public class PatientIDPrint {
    public static void main(String[] args) {
        List<Integer> patientIds = Arrays.asList(101, 102, 103, 104);
        patientIds.forEach(System.out::println);
    }
}