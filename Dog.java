public class Dog {
    private String name ="", breed="";
    private boolean isSitting = false;
    public Dog(String name){this.name = name;}
    public Dog(String name, String breed){this.name=name;this.breed=breed;}
    public void setName(String name){this.name = name;}
    public void setBreed(String breed){this.breed=breed;}
    public String getName(){return name;}
    public String getBreed(){return breed;}
    public String toString(){return getName()+" is a "+getBreed()+" dog";}
    public String toggleSit(){
        if(isSitting){ isSitting=false; return name+" is no longer sitting";}
        isSitting = true; return name+" is sitting";
    }
    public String speak(){return "Wolf!";}
    public boolean equals(Dog that){
        if(this.toString().equals(that.toString())){
            String sittingResp1 = this.toggleSit();
            this.toggleSit();
            String sittingResp2 = that.toggleSit();
            that.toggleSit();
            if(sittingResp1.equals(sittingResp2)){
                return true;
            }
        }
        return false;
    }
}

