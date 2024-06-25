package src.DesignPattern;

public class BuilderDesignPattern {
    private final String name;
    private final String age;
    private final String add;

    public BuilderDesignPattern(Builder obj) {
        this.name = obj.name;
        this.age = obj.age;
        this.add = obj.age;
    }

    @Override
    public String toString() {
        return "BuilderDesignPattern{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", add='" + add + '\'' +
                '}';
    }

    public static void main(String[] args) {
        BuilderDesignPattern obj = new Builder().setName("Anivesh").setAge("12").setAdd("XYZ").build();
        System.out.println(obj.toString());
    }
}

class Builder {
    public String name;
    public String age;
    public String add;

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setAge(String age) {
        this.age = age;
        return this;
    }

    public Builder setAdd(String add) {
        this.add = add;
        return this;
    }

    public BuilderDesignPattern build() {
        return new BuilderDesignPattern(this);
    }
}
