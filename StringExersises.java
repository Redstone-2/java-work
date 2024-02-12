public class StringExersises{
    public static void main(String[] args){
        System.out.println(ToPigLatin("Pig"));
        System.out.println(compareTo("Hello","hello"));
        System.out.println(getFileName("public class hello {run"));
        System.out.println(scrubTags("pre","<pre>This is a program to put a turtle on the screen</pre>"));
    }
    public static String ToPigLatin(String word){
        String temp = word.substring(0,1);
        word = word.substring(1, word.length());
        word += temp + "ay";
        return word;
    }
    public static String compareTo(String word1, String word2){
        int temp = word1.compareTo(word2);
        String ret = "";
        if(temp == 0){
            ret = word1 +"=="+word2;
        }else if(temp == Math.abs(temp)){
            ret = word1 + ">" + word2;
        }else{
            ret = word1 + "<" + word2;
        }
        return ret;
    }
    public static String getFileName(String code){
        return code.substring(code.indexOf("public class ")+13, code.indexOf(" ", code.indexOf("public class ")+13));
    }
    public static String scrubTags(String tag, String code){
        return code.substring(code.indexOf("<"+tag+">")+tag.length()+2, code.indexOf("</"+tag+">", code.indexOf("<"+tag+">")+tag.length()+1));
    }
}