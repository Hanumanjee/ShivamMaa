package codingpractice;

public class Test1 {
    public static void main(String[] args) {

        String str = "12345";
        System.out.println(str);
        // convert String to intiger
        int num = Integer.valueOf(str);
        System.out.println( num
        );







        //------------------------------------------------------------------------------//

        // reverse words in a String without using StringBuilder

        // reverse words in a String
        // remove digits from the string

        // liner sort of a String

        // first norepeated character should be c

        // total number of occurance of a given character

       // occuranceOfGivenChar(str, 'b');

        // remove duplicate from a String

       // removeDulicateFromString(str);
        // print duplicate character from a String
       // printDuplicateCaracter(str);

    }
    public static void revWithourStringBuilder(String str){
        String[] a = str.split("\\s");
        // without StringBuilder
        String result = "";

        for(int i =0; i<a.length; i++){
            String revString="";
            for(int j=a[i].length()-1; j>=0; j--){
                revString += a[i].charAt(j);

            }
            System.out.print( revString + " ");

        }
    }
    public static void reversWordsInString(String str){
        String[] a = str.split("\\s");
        StringBuilder sb = new StringBuilder();
        String result = "";
        for(String s : a){
            sb = new StringBuilder(s).reverse();
            result += sb.toString() + " ";
        }
        System.out.println(result);


    }
    public static void removeDigitFromString(String str){
        char[] a= str.toCharArray();
        String withoutDisit="";
        String digitOnly ="";
        for(int i =0; i<a.length; i++){
            if(!Character.isDigit(a[i])){
                withoutDisit +=a[i];
            }else{
                digitOnly += a[i];
            }

        }
        System.out.println("Without digits: " + withoutDisit);
        System.out.println("disit only : " + digitOnly);

    }
    public static void linearSort(String str){

        char[] a = str.toCharArray();

        for(int i =0; i<a.length; i++){
            for(int j =i+1; j<a.length; j++){
                if(a[i]>a[j]){
                    char temp = a[i];
                    a[i]= a[j];
                    a[j]=  temp;
                }

            }
        }
        System.out.println(String.valueOf(a));
    }
    public static void getFirstRepeatedChar(String str){
        char[] a = str.toCharArray();
        char nonrep = 0;
        for(int i =0; i<a.length; i++){
            boolean status=true;
            for(int j =0; j<a.length; j++){
                if(i!=j && a[i]==a[j]){
                    status =false;
                    break;
                }
            }
            if(!status){
                System.out.println(a[i]);
                break;
            }
        }
    }
    public static void getFirstNonrepeatedChar(String str){
        char[] a = str.toCharArray();
        char nonrep = 0;
        for(int i =0; i<a.length; i++){
            boolean status=true;
            for(int j =0; j<a.length; j++){
                if(i!=j && a[i]==a[j]){
                    status =false;
                    break;
                }
            }
            if(status){
                System.out.println(a[i]);
                break;
            }
        }
    }
    public static void getOccurance(String str, char c){
       int count = (int) str.chars().filter(ch-> ch==c).count();
        System.out.println(count);

    }

    public static void occuranceOfGivenChar(String str, char c) {
        char[] a = str.toCharArray();
        char givenChar = c;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == givenChar) {
                count++;
            }
        }

        System.out.println("The occurance of given char " + givenChar + " is " + count);

    }

    public static void printDuplicateCaracter(String str) {
        char[] a = str.toCharArray();
        char[] b = new char[a.length];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                boolean status = true;
                if (i != j && a[i] == a[j]) {
                    System.out.print(a[i] + " ");
                    break;
                }
            }

        }
    }

    public static void removeDulicateFromString(String str) {

        char[] a = str.toCharArray();
        char[] b = new char[a.length];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            boolean status = true;
            for (int j = 0; j < k; j++) {
                if (a[i] == b[j]) {
                    status = false;
                    break;
                }
            }
            if (status) {
                b[k] = a[i];
                k++;
            }
        }
        System.out.println(String.valueOf(b));
    }
}
