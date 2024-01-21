package ch.laeub.week9.annotations;

public class Company {
    String name;
    Member CEO;

    public Company(String name, Member CEO) {
        this.name = name;
        this.CEO = CEO;
    }

    public String getName() { return this.name; }
    public Member getCEO() { return this.CEO; }

    public void setName(String name) { this.name = name; }
    public void setCEO(Member CEO) { this.CEO = CEO; }
}
