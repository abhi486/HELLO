import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PW {
/*
EATBF
+*()a
 */
    static char[] nonTerminal, terminal;
    static int nonTLen,terminalLen;
    static String[][] grammar;
    static String[] fst;
    static String[] flw;
    public static void main(String[] args) throws IOException {
        String nt,t;
        int i,j,n;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the non-terminals");
        nt=br.readLine();
        nonTLen=nt.length();
        nonTerminal=new char[nonTLen];
        nonTerminal=nt.toCharArray();
        System.out.println("Enter the terminals");
        t=br.readLine();
        terminalLen=t.length();
        terminal =new char[terminalLen];
        terminal =t.toCharArray();
        System.out.println("Specify the grammar(Enter 9 for epsilon production)");
        grammar =new String[nonTLen][];
        for(i=0;i<nonTLen;i++)
        {
            System.out.println("Enter the number of productions for "+nonTerminal[i]);
            n=Integer.parseInt(br.readLine());
            grammar[i]=new String[n];
            System.out.println("Enter the productions");
            for(j=0;j<n;j++) {
                grammar[i][j]=br.readLine();
            }
        }
        fst=new String[nonTLen];
        for(i=0;i<nonTLen;i++)
            fst[i]=first(i);

        System.out.println("First Set");
        for(i=0;i<nonTLen;i++)
            System.out.println(removeDuplicates(fst[i],nonTerminal[i]));

        flw=new String[nonTLen];
        for(i=0;i<nonTLen;i++)
            flw[i]=follow(i);

        System.out.println("Follow Set");
        for(i=0;i<nonTLen;i++)
            System.out.println(removeDuplicates(flw[i],nonTerminal[i]));
    }
    static String first(int i) {
        int j,k,l,found = 0;
        StringBuilder temp= new StringBuilder();
        String str = "";
        for(j = 0; j < grammar[i].length; j++) //number of productions
        {
            for(k = 0; k < grammar[i][j].length(); k++,found=0) { //when non-Terminal has epsilon production
                for(l=0;l<nonTLen;l++) { //finding non-Terminal
                    if(grammar[i][j].charAt(k) == nonTerminal[l]) { //for non-Terminal in first set
                        str=first(l);
                        if(!(str.length()==1 && str.charAt(0)=='9')) //when epsilon production is the only non-Terminal production
                        temp.append(str);
                        found=1;
                        break;
                    }
                }
                if(found==1) {
                    if(str.contains("9")) //here epsilon will lead to next non-Terminal’s first set
                        continue;
                }
                else { //if first set includes terminal
                    temp.append(grammar[i][j].charAt(k));
                }
                break;
            }
        }
        return temp.toString();
    }
    static String follow(int i) {
        char[] pro,chr;
        StringBuilder temp= new StringBuilder();
        int j,k,l,m,n,found=0;
        if(i==0)
            temp = new StringBuilder("$");
        for(j=0;j<nonTLen;j++)
        {
            for(k = 0; k < grammar[j].length; k++) { //entering grammar matrix
                pro = grammar[j][k].toCharArray();
                for(l = 0;l < pro.length; l++) { //entering each production
                    if(pro[l] == nonTerminal[i]) { //finding the non-Terminal whose follow set is to be found
                        if(l == pro.length-1) { //if it is the last terminal/non-terminal then follow of current non-terminal
                            if(j<i)
                                temp.append(flw[j]);
                        }
                        else {
                            for(m = 0; m < nonTLen; m++) {
                                if(pro[l+1] == nonTerminal[m]) { //first of next non-terminal otherwise (else later…)
                                    chr = fst[m].toCharArray();
                                    for(n = 0;n < chr.length; n++) {
                                        if(chr[n] == '9') //if first includes epsilon
                                        {
                                            if(l+1 == pro.length-1)
                                                temp.append(follow(j)); //when non-terminal is second last
                                            else
                                                temp.append(follow(m));
                                        }
                                        else {
                                            temp.append(chr[n]); //include whole first set except epsilon
                                        }
                                    }
                                    found=1;
                                }
                            }
                            if(found!=1)
                                temp.append(pro[l + 1]); //follow set will include terminal(else is here)
                        }
                    }
                }
            }
        }
        return temp.toString();
    }
    static String removeDuplicates(String str,char symbol)
    {
        int i;
        char ch;
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder(seen.length);
        for(i=0;i<str.length();i++) {
            ch=str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                sb.append(ch).append(" ");
            }
        }
        return symbol + ": " + "{ " + sb.toString() + "}";
    }
}