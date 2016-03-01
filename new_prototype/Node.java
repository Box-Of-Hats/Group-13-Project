public class Node{
    /*
    guid: the unique identifier of the node
    ip: the ip of the node
    Finger[]: an array of finger objects
    predecessor: the directly preceding node
    */

    private int guid;
    private String ip;
    private Finger[] fingerTable;
    private Node predecessor;

    public Node(){

    }

    public String getIp(){
        //Accessor for Node ip
        return ip;
    }

    public int getGuid(){
        //Accessor for Node guid
        return guid;
    }

    public Node predecessor(){
        //Accessor for Node predecessor
        return predecessor;
    }

    public Finger[] getFingerTable(){
        //Accessor for Node fingertable
        return finger;
    }
}
