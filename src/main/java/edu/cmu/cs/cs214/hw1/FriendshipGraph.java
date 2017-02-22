package edu.cmu.cs.cs214.hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class to represent friend network, people are nodes, edges are friendships.
 * 
 * @author Kathleen.
 *
 */
public class FriendshipGraph{
    /**
     * Inner class to track distance a node is from the source.
     * @author Kathleen
     *
     */
    class DistanceTracker {
        private Person person;
        private int distFromStart;
        /**
         * Constructor to initialize object and set person to currPerson.
         * 
         * @param currPerson Person that is being tracked.
         */
        DistanceTracker(Person currPerson) {
            person = currPerson;
            distFromStart = -1; /* assumes no path at initialization */
        }
        /**
         * Method for retrieval of private variable person's value.
         * 
         * @return Person that is associated with the object.
         */
        Person getPerson() {
            return this.person;
        }
        /**
         * Method for retrieval of private variable distFromStart's value.
         * 
         * @return Distance from starting person to current person.
         */
        int getDistFromStart() {
            return this.distFromStart;
        }
        /**
         * Method for client to set distance based on parent node's distance.
         * 
         * @param distance New distance from start associated with curr person.
         */
        void setDistFromStart(int distance) {
            this.distFromStart = distance;
        }
    }
    /*
     * implement graph as adjacency list mapping a name to a linked list of
     * direct friends
     */
    private HashMap<String, LinkedList<Person>> network;

    /**
     * Constructor to initialize underlying HashMap implementation of graph.
     */
    public FriendshipGraph() {
        network = new HashMap<String, LinkedList<Person>>();
    }

    /**
     * This method adds a vertex to the graph.
     * 
     * @param perNode Person object to be added as vertex to FriendshipGraph.
     * 
     */
    public void addVertex(Person perNode) {
        if(network.containsKey(perNode.getName())){
            System.out.println("Error. Adding existing person to graph");
        }
        else{
            LinkedList<Person> friends = new LinkedList<Person>();
            network.put(perNode.getName(), friends);    
        }
        
    }

    /**
     * This method creates a directed edge from node 1 to node 2.
     * 
     * @param perNode1 First person in the friendship (source of edge).
     * @param perNode2 Second person in the friendship (target of edge).
	 */
    public void addEdge(Person perNode1, Person perNode2) {
        String name1 = perNode1.getName();
        String name2 = perNode2.getName();
        /* Check that both nodes exist in graph */
        if(!(network.containsKey(name1) && network.containsKey(name2))){
            System.out.println("Error. Adding edge between nonexisting nodes");
        }
        /* Check if edge already exists from perNode1 to perNode2 */
        else if(network.get(name1).contains(perNode2)){
            System.out.println("Error. Adding existing edge");
        }
        /* Valid edge, add it */
        else{
            network.get(name1).add(perNode2);
        }
    }

    /**
     * Returns the distance of the shortest path between nodes in a graph.
     * 
     * @param person1 Person that represents the starting node.
     * @param person2 Person that represents the ending node.
     * @return Shortest path length, -1 if no path or invalid input.
     */
    public int getDistance(Person person1, Person person2) {
       /*
        * getDistance is implemented with BFS 
        */
        
        /* Error checking if the source and target exist in graph */ 
        String name1 = person1.getName();
        String name2 = person2.getName();
        if(!(network.containsKey(name1) && network.containsKey(name2))){
            System.out.println("Error. One or both nodes doesn't exist");
            return -1;
        }
        
        /* queue tracks who is left to visit
         * visited tracks who has already been visited, neighbors will be
         * initialized with the current node's friends, tracker will be used to
         * track how far a node is from the start
         */
        LinkedList<DistanceTracker> queue = new LinkedList<DistanceTracker>();
        ArrayList<Person> visited = new ArrayList<Person>();
        LinkedList<Person> neighbors;
        DistanceTracker tracker = new DistanceTracker(person1);

        tracker.setDistFromStart(0); /* first person 0 distance from start */
        queue.add(tracker);
        visited.add(person1);

       while (queue.size() != 0) {
            DistanceTracker currNode = queue.removeFirst();
            Person currPer = currNode.getPerson();
            int currDistance = currNode.getDistFromStart();
            /* p1 to p2 path found, return distance stored in current node */
            if (currPer.isEqual(person2)) {
                return currDistance;
            }
            /* find all neighboring friends, (people of path length 1 away) */
            neighbors = network.get(currPer.getName());
            /*
             * look through all neighbors, if we haven't visited this person
             * yet, put them in the queue and mark them as visited
             */
            for (Person p : neighbors) {
                if (!visited.contains(p)) {
                    DistanceTracker d = new DistanceTracker(p);
                    /*
                     * the distance this neighbor node is from the start will
                     * be one greater than the distance of it's parent
                     */
                    d.setDistFromStart(currDistance + 1);
                    queue.add(d);
                   visited.add(p);
                }
            }
        }
        return -1; /* no path exists between p1 and p2 */
    }
}
