//
//  Name: Barrientos, Joshua
//  Project: 2
//  Due: 3/9/16
//  Course: cs-2400-02 
//
//  Description:
//      A class to use the Expression Class with different cases for the infix expressions.
//
public class ExpressionTest {
    public static void main(String[] args){
        System.out.println("J Barrientos's ExperssionCheck.");
        System.out.println("\nIf postfix is incorrect the evaluated will be 0 to make the code continue to run\n");
        BagInterface<Name> names = new ArrayBag<>();
        names.add(new Name("a", 4));
        names.add(new Name("b", 6)); 
        names.add(new Name("c", 2));
        names.add(new Name("var", 1));
        System.out.println("Variables being used: a = 4, b = 6, c = 2, var = 1");

        System.out.println("Case: All numbers");
        String infixExpression = "2 + 8 / 4 * 3";
        System.out.println("infix: " + infixExpression);
        String[] infix = infixExpression.split(" "); 
       
        String[] postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression :" );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        int evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);
        
        System.out.println("\nCase: Mix of correct variables and numbers");
        infixExpression = "var + 8 / 2 * 3";
        System.out.println("infix: " + infixExpression);
        infix = infixExpression.split(" "); 
       
        postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression: " );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);
        
        System.out.println("\nCase: all variables");
        infixExpression = "var + a / b ^ c";
        System.out.println("infix: " + infixExpression);
        infix = infixExpression.split(" "); 
       
        postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression: " );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);
        
        System.out.println("\nCase: correct amount of Parenthesis");
        infixExpression = "var + 8 / ( 2 * 3 )";
        System.out.println("infix: " + infixExpression);
        infix = infixExpression.split(" "); 
       
        postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression: " );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);
        
        System.out.println("\nCase:incorrect amount of parenthesis ");
        infixExpression = "var + 8 / ( 2 * 3";
        System.out.println("infix: " + infixExpression);
        infix = infixExpression.split(" "); 
       
        postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression: " );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);
        
        System.out.println("\nCase: incorrect infix expression");
        infixExpression = "var + 8 / 2 + + 3";
        System.out.println("infix: " + infixExpression);
        infix = infixExpression.split(" "); 
       
        postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression: " );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);
        
        System.out.println("\nCase: Incorrect parenthesis");
        infixExpression = "var + 8 / c )* b";
        System.out.println("infix: " + infixExpression);
        infix = infixExpression.split(" "); 
       
        postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression: " );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);
        
        System.out.println("\nCase: Invalid variable");
        infixExpression = "k + 8 / 2 * 3";
        System.out.println("infix: " + infixExpression);
        infix = infixExpression.split(" "); 
       
        postfix = Expression.convertToPostfix(infix); 
        System.out.print("PostfixExpression: " );
        for(int i = 0; i < postfix.length; i++){
            System.out.print(postfix[i]);
        }
        
        evaluated = Expression.evaluatePostfix(postfix, names);
        System.out.println("\nevaluated = " + evaluated);

    }
    
}
