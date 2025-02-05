public class Persona {

    //Constructor
    public Persona(int age, String name, String genre) {
        this.age = age;
        this.name = name;
        this.genre = genre;
    }

    //Atributes
    private String name;
    private int age;
    private String genre;

    //Getters
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Methods
    public boolean isAdult(Persona p1){
        if (p1.getAge() > 18) return true;

        return false;
    }
}
