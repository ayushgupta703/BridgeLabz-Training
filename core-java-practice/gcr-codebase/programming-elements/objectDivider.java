public class ObjectDivider {
    public static void main(String[] args) {
        int pens = 14;
        int students = 3;
        int pensPerStudent = pens / students;
        int remainingPens = pens % students;
        System.out.println("The pen per student is " + pensPerStudent + " and the remaining pen not distributed is "
                + remainingPens);
    }
}
