public class Pet {
    private String name;
    private int age;
    private  double weight;
    private String type;
    private String breed;

    public Pet(){
        name = "";
        age = 0;
        weight = 0.0;
        type = "";
        breed = "";
    }
    public Pet(String iname, int iage, double iweight, String itype, String ibreed){
        name = iname; age = iage; weight = iweight; type = itype; breed = ibreed;
    }
    public String getName(){return name;}
    public int getAge(){return age;}
    public double getWeight(){return weight;}
    public String getType(){return type;}
    public String getBreed(){return breed;}

    public void setName(String iname){name = iname;}
    public void setAge(int iage){age= iage;}
    public void setWeight(double iweight){weight=iweight;}
    public void setType(String itype){type= itype;}
    public void setBreed(String ibreed){breed= ibreed;}

    public String toString(){return getName() + ", "+getAge()+", "+getWeight()+", "+getType()+", "+getBreed();}
    
}
