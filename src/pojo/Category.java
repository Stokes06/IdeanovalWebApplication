package pojo;

public enum Category {

    SPORT("Sport"),NATURE("Nature"),MATHEMATIQUES("Maths"),AUTOMOBILE("Automobile"),MUSIQUE("Musique");
    private String name;
    Category(String _name)
    {
        name = _name;
    }

    @Override
    public String toString() {
        return name;
    }
}
