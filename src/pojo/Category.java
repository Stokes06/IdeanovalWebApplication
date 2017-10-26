package pojo;

public enum Category {

    SPORT(1,"Sport"),NATURE(2,"Nature"),MATHEMATIQUES(3,"Maths"),AUTOMOBILE(4,"Automobile"),MUSIQUE(5,"Musique");
    private int idCategory;
    private String name;
    Category(int id, String _name)
    {
        name = _name;
        idCategory = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
