import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main 
{

   // Input commands
    static String str;
    static String letters, first, second, third;
    // Class instance
    static Currency usd = new Currency("USD");
    static Currency rur = new Currency("RUR");
    static Currency uah = new Currency("UAH");
    // Input stream instance
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // Output stream instance
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);

    public static void main(String[] args) 
    {
        // Start
        Action();
    }

    public static void Action() 
    {
        try 
        {
            // Input command
            str = br.readLine();

            if (str.length() != 0) 
            {
                // Add notes
                if (str.charAt(0) == '+') 
                {
                    // currency
                    letters = str.substring(2, 5);
                    
                    // value
                    first = str.substring(6, str.indexOf(' ', 6));
                                        
                    // number
                    second = str.substring(str.lastIndexOf(' ') + 1, str.length());
                                        
                    if (letters.equals("USD"))
                    pw.println(usd.AddNotes(Integer.parseInt(first), Integer.parseInt(second)));
                    
                    else if (letters.equals("RUR"))
                    pw.println(rur.AddNotes(Integer.parseInt(first), Integer.parseInt(second)));
                    
                    else if (letters.equals("UAH"))
                    pw.println(uah.AddNotes(Integer.parseInt(first), Integer.parseInt(second)));
                }
                
                // Get cash
                else if (str.charAt(0) == '-') 
                {
                    // currency
                    letters = str.substring(2, 5);
                    
                    // sum
                    third = str.substring(6, str.length());
                    
                    if (letters.equals("USD"))
                    pw.println(usd.GetCash(Integer.parseInt(third)));
                    
                    else if (letters.equals("RUR"))
                    pw.println(rur.GetCash(Integer.parseInt(third)));
                    
                    else if (letters.equals("UAH"))
                    pw.println(uah.GetCash(Integer.parseInt(third)));
                }
                
                // Print cash
                else if (str.charAt(0) == '?') 
                {
                    usd.PrintCash();
                    rur.PrintCash();
                    uah.PrintCash();
                    pw.println("OK");
                }

            }
            
        } 
        
        catch (Exception e) 
        {
            //pw.println("ERROR");
        }

        // Continue
        Action();
    }

}
