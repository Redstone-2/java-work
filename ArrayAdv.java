public class ArrayAdv {
    private Object[] stored;
    
    public ArrayAdv(Object[] in){
        Object[] duplicate = new Object[in.length];
        for(int i = 0; i<in.length; i++)
            duplicate[i] = in[i];
        stored = duplicate;
    }
    public ArrayAdv(int length){
        stored = new Object[length];
    }
    public Object[] ArrayValue(){
        Object[] out = new Object[stored.length];
        for(int i = 0; i< stored.length; i++)
            out[i] = stored[i];
        return out;
    }
    public void setArray(Object[] in){
        Object[] duplicate = new Object[in.length];
        for(int i = 0; i<in.length; i++)
            duplicate[i] = in[i];
        stored = duplicate;
    }
    public Object getValue(int index){
        return stored[index];
    }
    public void setValue(int index, Object value){
        stored[index] = value;
    }
    public int indexOf(Object in){
        for(int i = 0; i<stored.length; i++)
            if(stored[i].equals(in))
                return i;
        return -1;
    }
    public void append(Object in){
        Object[] temp = new Object[stored.length+1];
        for(int i = 0; i<stored.length; i++)
            temp[i] = stored[i];
        temp[temp.length-1] = in;
        stored = temp;
    }
    public void insert(int index, Object in){
        Object[] temp = new Object[(index<stored.length)?stored.length+1:index+1];
        int j = 0;
        if(index == 0){temp[0 ] = in; j=1;}
        for(int i = 0; i<stored.length; i++){
            temp[i+j] = stored[i];
            if(i+1 == index){j = 1; temp[i+1]=in;}
        }if(index > stored.length){
            temp[temp.length-1] = in;
        }
        stored = temp;
    }
    public void delete(int index){
        if(index >=stored.length)return;
        Object[] temp = new Object[stored.length-1];
        int j = 0;
        for(int i = 0; i<temp.length; i++){
            temp[i] = stored[i+j];
            if(i+1 == index){j+=1;}
        }
        stored = temp;
    }
    public Object[] subArray(int startIndex){
        Object[] temp = new Object[stored.length-startIndex];
        for(int i = 0; i<temp.length; i++)
            temp[i] = stored[startIndex+i];
        return temp;
    }
    public Object[] subArray(int startIndex, int endIndex){
        if(endIndex>=stored.length) return subArray(startIndex);

        Object[] temp = new Object[endIndex-startIndex];
        for(int i = 0; i<temp.length; i++)
            temp[i] = stored[startIndex+i];
        return temp;
    }
    public String toString(){
        String out ="{";
        for(Object i : stored)
            out += ((i!=null)?i.toString():"null") + ", ";
        out = out.substring(0, out.length()-2)+"}";
        return out;
    }
    public int length(){return stored.length;}
}

