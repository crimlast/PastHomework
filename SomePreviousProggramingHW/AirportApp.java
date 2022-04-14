//
// Name: Barrientos, Joshua
// Project: 3
// Due: 5/15/20 Noon
// Course: cs-2400-02-sp19
//
// Description:
//  AirportApp. The main class which uses a graph to implement airports and their data
//

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class AirportApp {
    public static void main(String[] args) throws IOException{
        System.out.println("Airports by J. Barrientos\n");                
        String[] airportCodes = new String[200];
        String[] airportInfo = new String[200];
        int count = 0;
        File airportFile = new File("airports.csv");
        File distanceFile = new File("distances.csv"); 
        Scanner airportData = new Scanner(airportFile);
        String[] parameter;
        while(airportData.hasNext()){
            parameter = airportData.nextLine().split(",");
            airportCodes[count] = parameter[0];
            airportInfo[count] = parameter[1];
            count++;
            
        }
        
        GraphInterface<String> airportGraph = new DirectedGraph();

        Scanner keyboard = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        for(int i= 0; i < count; i++){
            airportGraph.addVertex(airportCodes[i]);
        }
        Scanner distances = new Scanner(distanceFile);
        
        while(distances.hasNext()){
            parameter = distances.nextLine().split(",");            
            airportGraph.addEdge(parameter[0], parameter[1], Double.parseDouble(parameter[2])); 
        } 
       
        String command = "";
        while(!command.equals("E")){
            System.out.print("Command: ");
            command = keyboard.nextLine();
            if(command.equals("H")){
                displayMessage();
            }
            if(command.equals("D")){
                System.out.print("Airport Code: ");
                String airportCode1 = in.next();
                String airportCode2 = in.next();
                double result = getShortestDistance(airportGraph, airportCode1, airportCode2);
                String airport1 = displayConnection(airportCode1, airportCodes, airportInfo);
                String airport2 = displayConnection(airportCode2, airportCodes, airportInfo);
                System.out.println("The minimum distance between "+ airport1 +" and "+airport2+" is "+ result+ " through the route: ");
            }
            if(command.equals("Q")){
                System.out.print("Airport Code: ");
                String find = in.next();
                String result = displayConnection(find, airportCodes, airportInfo);
                System.out.println(result);
            }
            if(command.equals("I")){
                System.out.print("Airport Codes and distance: ");
                String airportCode1 = in.next();
                String airportCode2 = in.next();
                double dist = in.nextDouble();
                try{
                    airportGraph.addEdge(airportCode1, airportCode2, dist); 
                    String airport1 = displayConnection(airportCode1, airportCodes, airportInfo);
                    String airport2 = displayConnection(airportCode2, airportCodes, airportInfo);
                    System.out.println("You have inserted a connection from "+airport1+" to "+airport2+" with a distance of " + dist+ ".");
                }
                catch (RuntimeException e){
                    System.out.println("Warning: Already existing edge");
                }
               
            }
            if(command.equals("R")){
                System.out.print("Airport Codes: ");
                String airportCode1 = in.next();
                String airportCode2 = in.next();
                boolean result;
                result = airportGraph.removeEdge(airportCode1, airportCode2);
                if(result == true){
                    String airport1 = displayConnection(airportCode1, airportCodes, airportInfo);
                    String airport2 = displayConnection(airportCode2, airportCodes, airportInfo);
                    System.out.println("You have removed a connection from "+airport1+" to "+airport2 + ".");
                }
                else{
                    System.out.println("Warning: No such connection exist");
                }
                
            }
            
        }
               
    }
    
    public static String displayConnection(String find,String[] arr1, String[] arr2){
        boolean done = false;
        String result = "";
        int counter = 0;
        while(!done){
            if(arr1[counter].equals(find)){
                result = arr2[counter];
                done = true;
            }
            else{
                counter++;
            }
            
        }
        return result;
    }
    
    public static void displayMessage(){
        System.out.println("Q Query the airport information by entering the airport code.");
        System.out.println("D Find the minimum distance between two airports.");
        System.out.println("I Insert a connection by entering two airport codes and distance.");
        System.out.println("R Remove an existing connection by entering two airport codes.");
        System.out.println("H Display this message.");
        System.out.println("E Exit.");
    }
    
    public static double getShortestDistance(GraphInterface<String> graph, String code, String code2){
        String begin = code;
        String end = code2;
        Stack<String> path = new Stack<>();        
        double distance = graph.getCheapestPath(begin, end, path);
        return distance;
    }

    
    
    
}
