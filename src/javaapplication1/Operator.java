/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;






/**
 *
 * @author Toshoba
 */
public class Operator {
    private final String[] history= new String[5];
    

   private String Input;
       public Operator() {
        
    }
    public String getInput() {
        return Input;
    }

    public void setInput(String Input) {
        this.Input = Input;
    }
        public static String[] his(String x,String[] y)
    {
       if(y[4].isEmpty() && y[3].isEmpty() && y[3].isEmpty() && y[2].isEmpty() && y[1].isEmpty()
               && y[1].isEmpty()) y[4]=x;
       else 
       {
           String z;
           for (int i=4;i>0;i--)
           {
               
               z=y[i];
               y[i]=x;
               x=z;
           }
               
       
       
       }
       return y;
            
                      
       
         
            
    }
    public String num(String x,String y)
    {
        
         
        if(y.isEmpty())
            y = x;
        
        else
            y= y.concat(x);
        return y ;
            
    }
 
    public  String operand(String x,String y)
    {
        if(y.isEmpty() )
            return "";
        else    
        {
            y=y.concat(x);
            return y;
        }  
    }
        public double eval(final String str) {
    return new Object() {
        int pos = -1, ch;

        void nextChar() {
            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
        }

        boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        double parse() {
            nextChar();
            double x = parseExpression();
            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }

        // Grammar:
        // expression = term | expression `+` term | expression `-` term
        // term = factor | term `*` factor | term `/` factor
        // factor = `+` factor | `-` factor | `(` expression `)`
        //        | number | functionName factor | factor `^` factor

        double parseExpression() {
            double x = parseTerm();
            for (;;) {
                if      (eat('+')) x += parseTerm(); // addition
                else if (eat('-')) x -= parseTerm(); // subtraction
                else return x;
            }
        }

        double parseTerm() {
            double x = parseFactor();
            for (;;) {
                if      (eat('*')) x *= parseFactor(); // multiplication
                else if (eat('/')) x /= parseFactor(); // division
                else return x;
            }
        }

        double parseFactor() {
            if (eat('+')) return parseFactor(); // unary plus
            if (eat('-')) return -parseFactor(); // unary minus

            double x;
            int startPos = this.pos;
            if (eat('(')) { // parentheses
                x = parseExpression();
                eat(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(str.substring(startPos, this.pos));
            } else if (ch >= 'a' && ch <= 'z') { // functions
                while (ch >= 'a' && ch <= 'z') nextChar();
                String func = str.substring(startPos, this.pos);
                x = parseFactor();
                if (func.equals("sqrt")) x = Math.sqrt(x);
                else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                else throw new RuntimeException("Unknown function: " + func);
            } else {
                throw new RuntimeException("Unexpected: " + (char)ch);
            }

            if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

            return x;
        }
    }.parse();
}
        
 public String clears(String x)
 {
     x= "";
     return x;
 }
 public String del(String x)
 {  String y;
     if(x.isEmpty())
         return x;
         
     
     
 y=x.substring(0, (x.length()-1));

 return y;
 
 
 
 
 }
    
    
    
   
            
    


    
    
}
