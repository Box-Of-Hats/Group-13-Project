import java.util.Scanner;

class Application{

    public void listCommands(){
        // Print help text for application
        System.out.println("Syntax: COMMAND Arg1 Arg2 ... ArgN");
        System.out.println("Enter a command:\n");
        System.out.println("\thelp - Display list of commands with options");
        System.out.println("\tquit - Exit the application and close all connections.");
        System.out.println("\tjoin [BootstrapIP] - Join a network via a bootstrap node IP.");
        System.out.println("\taddurl [URL to add] [IP to add] - Add a url to store in the system.");
        System.out.println("\tstart - Start a new network as the first node in the system.");
        System.out.println("\tlookup [URL] - Look up the IP address of a given URL.");
    }


    public static void main(String[] args){

        /*
        CMD line application that allows users to input arguments during runtime
        with the following commands as a basic package:
        -Initiate Node: Creates a Node system using Node Factory
        -Start Network: Creates a new Network from the node
        -Join Network: Joins a network from an inputted IP address
        -Add URL: gives the URL to the node to hash and assign to the correct node in the network
        -Look up URL: looks up the IP for the given URL from the node network
        */

        //Output introduction text:
        System.out.println("\nChord DNS Client ver 0.1\n");
        Application app = new Application();
        app.listCommands();

        String commandIn;
        String[] commandList;
        
        //Initialise node, server and client on this application.
        NodeFactory factory = new NodeFactory();
        Node node = factory.makeNode();


        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            commandIn = scanner.nextLine();
            commandList = commandIn.split("\\s");
            String command = commandList[0];

            switch(command){
                case "help":
                    app.listCommands();
                    break;

                case "join":
                    if (commandList.length != 2){
                        System.out.println("Error:\tBad arguements passed to 'join'.");
                        System.out.println("\t1 argument required: Bootstrap IP");
                        break;
                    }
                    else{
                        System.out.println("Joining network via Bootstrap IP: " + commandList[1]);
                        break;
                    }
        
                case "start":
                    System.out.println("Starting...");
                    break;

                case "addurl":
                    System.out.println("Adding url...");
                    break;

                case "lookup":
                    System.out.println("Looking up url...");
                    break;

                case "quit":
                    System.exit(0);
                    break;
                
                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Command not found: '" + command + "'");
                    System.out.println("Type 'help' for a list of commands.");
                    break;
            }    
        }
    }
}