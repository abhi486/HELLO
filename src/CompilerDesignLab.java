import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CompilerDesignLab {
    final static Scanner sc = new Scanner(System.in);
    static int single = 0;
    static int multiple = 0;
    static String singleCommentStart = "//";
    static String multiCommentStart = "/*";
    static String multiCommentStop = "*/";

    public static String toLower(String s){
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(Character.toLowerCase(s.charAt(i)));
        }
        return ans.toString();
    }

    public static void program1() {
        System.out.println("Enter 1 for consecutive zeros");
        System.out.println("Enter 2 for 1st character 'a' 4th character 'b");
        int c = sc.nextInt();
        if (c == 1) {
            System.out.println("Enter the string containing 0 and 1 : ");
            String s = sc.next();
            int n = s.length();
            if (n == 1){
                if (s.charAt(0) == '1' || s.charAt(0) == '0'){
                    System.out.println("String accepted");
                }
                else{
                    System.out.println("Invalid");
                }
                return;
            }
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) != '1' || s.charAt(i) != '0'){
                    System.out.println("String not accepted");
                    return;
                }
                if (s.charAt(i) == '0' && s.charAt(i + 1) == '0') {
                    System.out.println("String not accepted");
                    return;
                }
            }
            System.out.println("String accepted");
        }
        else if (c == 2) {
            System.out.println("Enter the string : ");
            String s = sc.next();
            s = toLower(s);
            int n = s.length();
            if (n < 4) {
                System.out.println("Invalid");
                return;
            }
            if (s.charAt(0) == 'a' && s.charAt(3) == 'b') {
                System.out.println("String accepted");
            } else {
                System.out.println("String not accepted");
            }
        }
        System.out.println();
    }

    public static void program2(){
        String s = sc.next();
        s = toLower(s);
        int n = s.length();
        if (n < 3){
            System.out.println("Invalid");
            return;
        }
        if (s.charAt(n-1) == 'g' && s.charAt(n-2) == 'n' && s.charAt(n-3) == 'i'){
            System.out.println("String accepted");
            return;
        }
        System.out.println("String not accepted");
    }

    public static void program3() throws Exception {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println("String : " + line);
            if (isAValidComment(line)) {
                System.out.println("Valid");
            } else {
                System.out.println("Not Valid");
            }
            System.out.println();
        }
        System.out.println("Single Comments: " + single);
        System.out.println("Multiple Comments: " + multiple);
    }


    public static boolean isAValidComment(String str) {
        if (str.length() < 2) {
            return false;
        }
        if(str.substring(0,2).equals(singleCommentStart)){
            single++;
            return true;
        }
        if(str.length() < 4) {
            return false;
        }
        if(str.substring(0,2).equals(multiCommentStart) && str.substring(str.length()-2).equals(multiCommentStop)){
            multiple++;
            return true;
        }
        return false;
    }

    public static boolean isAValidIdentifier(String str) {
        if (!((str.charAt(0) >= 'a' && str.charAt(0) <= 'z')
                || (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')
                || str.charAt(0) == '_'))
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                    || (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                    || str.charAt(i) == '_'))
                return false;
        }
        return true;
    }

    public static boolean isValidKeyWord(String str){
        Set<String> keyWords = new HashSet<>();
        keyWords.add("auto"); keyWords.add("break");
        keyWords.add("case"); keyWords.add("char");
        keyWords.add("const"); keyWords.add("continue");
        keyWords.add("default"); keyWords.add("do");
        keyWords.add("double"); keyWords.add("else");
        keyWords.add("enum"); keyWords.add("extern");
        keyWords.add("float"); keyWords.add("for");
        keyWords.add("goto"); keyWords.add("if");
        keyWords.add("int"); keyWords.add("long");
        keyWords.add("register"); keyWords.add("return");
        keyWords.add("short"); keyWords.add("sizeof");
        keyWords.add("static"); keyWords.add("struct");
        keyWords.add("switch"); keyWords.add("typedef");
        keyWords.add("union"); keyWords.add("signed");
        keyWords.add("unsigned"); keyWords.add("void");
        keyWords.add("volatile"); keyWords.add("while");
        return keyWords.contains(str);
    }

    public static String getOperator(String symbol) {
        String temp = "";
        if (symbol.equals("+")){
            temp = "Addition";
        }
        else if (symbol.equals("-")){
            temp = "Subtraction";
        }
        else if (symbol.equals("*")){
            temp = "Multiplication";
        }
        else if (symbol.equals("/")){
            temp = "Division";
        }
        else if (symbol.equals("%")){
            temp = "Mod";
        }
        else if (symbol.equals("=")){
            temp = "Assignment";
        }
        return temp.equals("") ? temp : temp + " operator";
    }

    public static void program4(){

        /*
20
_cse
2K18/CO/017
AbhishekKumar
2K18/CO/017+ABHISHEK
2K18/CO/017_ABHISHEK
2K18/CO/017 ABHISHEK
signed
void
default
goto
sizeof
volatile
signed
siged
vod
defau
gotoo
sizeto
123void
void123
        */
        int test = sc.nextInt();
        while (test-- > 0){
            String string = sc.next();
            System.out.print(string + ": ");
            if (isValidKeyWord(string)){
                System.out.print("Keyword");
            }
            else if (isAValidIdentifier(string)){
                System.out.print("Identifier");
            }
            else
                System.out.print("Not a identifier");
            System.out.println();
        }
    }

    public static class Pair<T1,T2>{
        T1 first;
        T2 second;
        Pair(T1 a,T2 b){
            this.first = a;
            this.second = b;
        }

        @Override
        public String toString() {
            return "[" + first + ", " + second + "]";
        }
    }

    public static class Program5 {
        //3 2

        /*
[0,1] [0]
[null] [2]
[null] [null]
        */

        /*
[0] [1]
[1,2] [1]
[2] [1,2]
         */
        public static void run(){
            nfaToDfaConversion();
        }
        private static void nfaToDfaConversion() {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[][] nfaTable = new String[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nfaTable[i][j] = sc.next();
                }
            }
            Map<String,ArrayList<String>> totalStates = new LinkedHashMap<>();
            Queue<String> queue = new LinkedList<>();
            queue.add("[0]");
            while (!queue.isEmpty()){
                //System.out.println(queue);
                String state = queue.poll();
                ArrayList<String> goToStates = new ArrayList<>();
                totalStates.put(state,goToStates);
                //System.out.println(totalStates);
                String[] statesInCurrState = state.substring(1,state.length()-1).trim().split(",");
                for (int i = 0; i < m; i++){
                    ArrayList<String> newState = new ArrayList<>();
                    for (int j = 0; j < statesInCurrState.length; j++) {
                        //System.out.println(statesInCurrState[j]);
                        String s = statesInCurrState[j].trim();
                        if (s.equals("null")){
                            continue;
                        }
                        String t = nfaTable[Integer.parseInt(s)][i];
                        String[] temp = t.substring(1,t.length()-1).split(",");
                        for (int k=0;k<temp.length;k++){
                            //System.out.println("#" + c +  " " + temp[k]);
                            if (temp[k].equals("null")){
                                continue;
                            }
                            if (newState.contains(temp[k]))
                                continue;
                            newState.add(temp[k]);
                            //System.out.println("newState : " + newState.toString());
                        }
                    }
                    Collections.sort(newState);
                    String tempAns = newState.toString().trim();
                    if (!tempAns.equals("") && !totalStates.containsKey(tempAns))
                        queue.add(tempAns);
                    ArrayList<String> tempArrayList = totalStates.get(state);
                    tempArrayList.add(tempAns);
                    totalStates.replace(state,tempArrayList);
                }
            }
            printDfa(totalStates);
        }
        public static void printDfa(Map<String,ArrayList<String>> map) {
            System.out.println("=========DFA Table=========");
            for (String key : map.keySet()){
                if (key.substring(1,key.length()-1).equals("0")){
                    System.out.print("-> ");
                }
                System.out.print(key + " : ");
                for (int i=0;i<map.get(key).size();i++){
                    if (i == map.get(key).size() - 1){
                        System.out.print(map.get(key).get(i));
                    }
                    else{
                        System.out.print(map.get(key).get(i) + ", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static class Program6 {
        public static void run() throws FileNotFoundException {
            displayTokens();
        }
        public static void displayTokens() throws FileNotFoundException {
            File file = new File("input.txt");
            List<String> tokens = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                StringBuilder temp = new StringBuilder();
                for (int i=0;i<s.length();i++){
                    char ch = s.charAt(i);
                    if (Character.isLetter(ch)){
                        temp.append(ch);
                    }
                    else{
                        tokens.add(temp.toString());
                        if (ch != ' ') {
                            tokens.add(String.valueOf(ch));
                        }
                        temp.delete(0,temp.length());
                    }
                }
                tokens.add(temp.toString());
            }
            System.out.println("Tokens from file");
            for (String x : tokens){
                System.out.print(x + " ");
                if (isValidKeyWord(x)){
                    System.out.print("(keyword)");
                }
                else if (isAValidIdentifier(x)){
                    System.out.print("(Identifier)");
                }
                else if (!getOperator(x).equals("")){
                    System.out.print("(" + getOperator(x) + ")");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception{
//       program1();
//       program2();
//        program3();
//        program4();
//        Program5.run();
        Program6.run();
    }
}
