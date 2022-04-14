
//
//  Name: Barrientos, Joshua
//  Project: 2
//  Due: 3/9/16
//  Course: cs-2400-02 
//
//  Description:
//      A class Expression to convert infix to postfix and evaluate postfix expression.
//
import java.util.ArrayList;
public class Expression {
    
    /** Converts a infix expression to a postfixExpression
        * @param infixExpression An array of strings that resemble an infix expression.
        * @return converToPostfix An array of Strings that resembles a postfix expression.*/
    public static String[] convertToPostfix(String[] infixExpression){
        ArrayList<String> postfix = new ArrayList<>();
        StackInterface<String> operatorStack = new LinkedStack<>();
        for(String next : infixExpression){
            switch(next){
                case "+": case "-": 
                    while(!operatorStack.isEmpty() && (operatorStack.peek().equals("*") || 
                            operatorStack.peek().equals("/") || operatorStack.peek().equals("^") || 
                            operatorStack.peek().equals("+") || operatorStack.peek().equals("-")) && !operatorStack.peek().equals("(")){
                    postfix.add(operatorStack.pop());
                    }
                operatorStack.push(next);
                break;
                
                case "*" : case "/":     
                    while(!operatorStack.isEmpty() && (operatorStack.peek().equals("^") ||
                            operatorStack.peek().equals("/") || operatorStack.peek().equals("^")) 
                            && !operatorStack.peek().equals("(")){
                        postfix.add(operatorStack.pop());
                    }
                    operatorStack.push(next);
                    break;
                    
                case "^" :
                    operatorStack.push(next);
                    break;
                
                case "(":
                    operatorStack.push("(");
                    break;
                
                case ")":
                    try{
                        String top = operatorStack.pop();
                        while(!top.equals("(")){
                            postfix.add(top);
                            top = operatorStack.peek();
                        }
                        operatorStack.pop();
                    }
                    catch(RuntimeException e){
                        System.out.println("Infix not formed correctly: Parenthesis do not match up");
                    }
                    break;
             
                default:
                    postfix.add(next);
                    break;

            }
        }

        try{
            while(!operatorStack.isEmpty()){
                if (operatorStack.peek().equals("(")){
                    operatorStack.pop();
                    throw new RuntimeException();
                }
                postfix.add(operatorStack.pop());
            }
        }
        catch(RuntimeException e){
            System.out.print("\nInfix not formed correctly: Parenthesis don't match up.");
            
        }
        return postfix.toArray(new String[postfix.size()]);
    }
    
    /** Evaluates a postfixExpression with integers and variables that represent values.
        * @param postfixExpression An array of strings that resemble a postfix expression.
        * @param nameBag A arrayBag of names that can be used to determine what values are variables.
        * @return int A value that is taken from the evaluation of the postfixExpression.*/
    public static int evaluatePostfix(String[] postfixExpression, BagInterface<Name> nameBag){
        boolean isInteger;
        StackInterface<Integer> valueStack = new LinkedStack<>();
        Name[] bag = convert(nameBag);
        int operands = 0;
        for(String k: postfixExpression){
            if(k.equals("^") || k.equals("/") || k.equals("*") || k.equals("+") || k.equals("-")){
                operands--;
            }
            else{
                operands++;
            }
        }        
        try{
            if (operands != 1){
                throw new RuntimeException();
            }
        }
        catch(RuntimeException e){
            System.out.print("\nPostfix not formed correctly");
            return 0;
        }
                
            for(String data: postfixExpression){
                isInteger = true;
                try{
                    Integer.parseInt(data);
                }
                catch(RuntimeException e){
                    isInteger = false;
                }
                switch(data){
                    case "+":
                        int operand1 = valueStack.pop();
                        int operand2 = valueStack.pop();
                        valueStack.push(operand2 + operand1);
                        break;
                    case "-":
                        int operand3 = valueStack.pop();
                        int operand4 = valueStack.pop();
                        valueStack.push(operand4 - operand3);
                        break;
                        
                    case "*":
                        int oper1 = valueStack.pop();
                        int oper2 = valueStack.pop();
                        valueStack.push(oper2 * oper1);
                        break;
                        
                    case "/":
                        int oper3 = valueStack.pop();
                        int oper4 = valueStack.pop();
                        valueStack.push(oper4 / oper3);
                        break;
                    case "^":
                        int o1 = valueStack.pop();
                        int o2 = valueStack.pop();
                        valueStack.push(o2 ^ o1);
                        break;
                    default:
                        if(isInteger){
                            valueStack.push(Integer.parseInt(data));
                        }
                        else{
                            try{
                                valueStack.push(lookup(bag, data));
                            }
                            catch(RuntimeException e){
                                System.out.print("\nInvalid variable");
                                return 0;
                            }
                            
                        }
                    }
                }
            
        return valueStack.pop();
    }
    /** Converts an ArrayBag into an array of Names.
        * @param nameBag A arrayBag of names that can be used to determine what values are variables.
        * @return An array of names.*/
    public static Name[] convert(BagInterface<Name> nameBag){
        Object[] temp = nameBag.toArray();
        Name[] bag = new Name[temp.length];
        for(int i = 0; i < temp.length; i++){
            bag[i] = (Name)temp[i];
        }
        return bag;
    }
    
    /** Evaluates a postfixExpression with integers and variables that represent values.
        * @param bag An array of Names.
        * @param data A string which is desired to be found from an Array of names.
        * @return int A value that is taken from getting the desired Name's value.*/
    public static int lookup(Name[] bag, String data){
        int value = 0;
            boolean isFound = false;
                int counter = -1;
                while(!isFound && counter < bag.length - 1){
                    counter++;
                    if(data.equals(bag[counter].getName())){
                        value = bag[counter].getValue();
                        isFound = true;
                    }
                }
                if(isFound == false){
                    throw new RuntimeException();
                }
            
            
        return value;
    }

        
    
}
