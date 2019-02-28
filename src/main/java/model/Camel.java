package model;

public class Camel {

    private long id;
    private String name;
    private int age;
    private Gender gender;
    private float weight;
    private float height;
    private String furColor;

    public static NeedId builder(){
        return new Builder();
    }

    public static class Builder implements NeedId, NeedName, NeedAge, NeedGender, AndNext, CanBeBuild{
        private long id;
        private String name;
        private int age;
        private Gender gender;
        private float weight;
        private float height;
        private String furColor;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder gender(Gender gender){
            this.gender = gender;
            return this;
        }

        public Builder weight(float weight){
            this.weight = weight;
            return this;
        }

        public Builder height(float height){
            this.height = height;
            return this;
        }

        public Builder furColor(String furColor){
            this.furColor = furColor;
            return this;
        }

        public Builder and(){
            return this;
        }

        public Camel build(){
            Camel camel = new Camel();
            camel.id = this.id;
            camel.name = this.name;
            camel.age = this.age;
            camel.gender = this.gender;
            camel.weight = this.weight;
            camel.height = this.height;
            camel.furColor = this.furColor;

            return camel;
        }
    }

    public interface NeedId{
        NeedName id(long id);
    }

    public interface NeedName{
        NeedAge name(String name);
    }

    public interface NeedAge{
        NeedGender age(int age);
    }

    public interface NeedGender{
        AndNext gender(Gender gender);
    }

    public interface AndNext{
        CanBeBuild and();
    }

    public interface CanBeBuild{
        CanBeBuild weight(float weight);
        CanBeBuild height(float height);
        CanBeBuild furColor(String furColor);

        Camel build();
    }

    @Override
    public String toString() {
        return "Camel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                ", furColor='" + furColor + '\'' +
                '}';
    }
}
