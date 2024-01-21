package ch.laeub.week9.annotations;

public class Driver {

    public static void main(String[] args) {
        Member member = new Member("John", "Doe", 42);
//        System.out.println(member);

        AnnotationParser.toString(member);

    }

}
