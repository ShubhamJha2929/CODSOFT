
    import java.util.Scanner;

    public class StudentGradeCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter marks obtained in each subject (out of 100):");
            int totalMarks = 0,i;
            int numberofSubjects;

            System.out.print("Enter the number of subjects: ");
            numberofSubjects = scanner.nextInt();


            for (i = 1; i <= numberofSubjects; i++) {
                System.out.print("Enter marks for subject " + i + ": ");
                int marks = scanner.nextInt();
                totalMarks += marks;
            }


            System.out.println("Total Marks: " + totalMarks);

            double avgPercentage = (double) totalMarks / numberofSubjects;
            System.out.println("Average Percentage: " + avgPercentage);

            String Grade;
            if (avgPercentage >= 90) {
                Grade = "A";
            } else if (avgPercentage >= 80) {
                Grade = "B";
            } else if (avgPercentage >= 70) {
                Grade = "C";
            } else if (avgPercentage >= 60) {
                Grade = "D";
            } else {
                Grade = "F";
            }

            System.out.println("Grade: " + Grade);

            scanner.close();
}
    }


