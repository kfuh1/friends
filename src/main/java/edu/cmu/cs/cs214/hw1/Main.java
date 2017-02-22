package edu.cmu.cs.cs214.hw1;

/**
 * Class to help you test your graph implementation.
 */
public class Main {
	/**
	 * Main method to help you test your graph implementation.
	 * 
	 * @param args Arguments to the program.
	 */
	public static void main(String[] args) {
		// Un-comment the following code (CTRL + /).
		// graph 1 tests
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		Person bob = new Person("bob");
		Person bill = new Person("bill");
		Person bo = new Person("bo");
		Person bea = new Person("bea");

		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addVertex(bob);
		graph.addVertex(bill);
		graph.addVertex(bo);
		graph.addVertex(bea);

		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		graph.addEdge(rachel, bo);
		graph.addEdge(bo, rachel);
		graph.addEdge(rachel, bill);
		graph.addEdge(bill, rachel);
		graph.addEdge(bill, bea);
		graph.addEdge(bea, bill);
		graph.addEdge(rachel, bob);
		graph.addEdge(bob, rachel);
		graph.addEdge(bo, ben);
		graph.addEdge(ben, bo);

		System.out.println(graph.getDistance(rachel, ross)); // should print 1
		System.out.println(graph.getDistance(rachel, ben)); // should print 2
		System.out.println(graph.getDistance(rachel, rachel)); // should print 0
		System.out.println(graph.getDistance(rachel, kramer)); // should print -1
		
		graph.addVertex(rachel); //Error check											
		
		System.out.println(graph.getDistance(bea, bob)); // should print 3
		System.out.println(graph.getDistance(bo, bob)); // should print 2
		System.out.println(graph.getDistance(bea, kramer)); // should print -1
		System.out.println(graph.getDistance(bea, ben)); // should print 4
		System.out.println(graph.getDistance(bo, bill)); // should print 2
		System.out.println(graph.getDistance(rachel, bo)); // should print 1
		System.out.println(graph.getDistance(bo, rachel)); // should print 1

		System.out.println("\n");
		// graph 2 tests
		FriendshipGraph graph2 = new FriendshipGraph();
		Person a = new Person("a");
		Person b = new Person("b");
		Person c = new Person("c");
		Person d = new Person("d");
		Person e = new Person("e");
		Person f = new Person("f");
		Person g = new Person("g");
		Person h = new Person("h");
		Person i = new Person("i");
		Person j = new Person("j");
		Person k = new Person("k");
		Person l = new Person("l");
		Person m = new Person("m");
		Person n = new Person("n");
		Person o = new Person("o");
		Person p = new Person("p");

		graph2.addVertex(a);
		graph2.addVertex(b);
		graph2.addVertex(c);
		graph2.addVertex(d);
		graph2.addVertex(e);
		graph2.addVertex(f);
		graph2.addVertex(g);
		graph2.addVertex(h);
		graph2.addVertex(i);
		graph2.addVertex(j);
		graph2.addVertex(k);
		graph2.addVertex(l);
		graph2.addVertex(m);
		graph2.addVertex(n);
		graph2.addVertex(o);
		graph2.addVertex(p);

		graph2.addEdge(a, l);
		graph2.addEdge(l, a);
		graph2.addEdge(a, i);
		graph2.addEdge(i, a);
		graph2.addEdge(a, e);
		graph2.addEdge(e, a);
		graph2.addEdge(e, f);
		graph2.addEdge(e, g);
		graph2.addEdge(g, e);
		graph2.addEdge(f, e);
		graph2.addEdge(g, o);
		graph2.addEdge(o, g);
		graph2.addEdge(f, d);
		graph2.addEdge(d, f);
		graph2.addEdge(d, l);
		graph2.addEdge(l, d);
		graph2.addEdge(d, n);
		graph2.addEdge(n, d);
		graph2.addEdge(c, m);
		graph2.addEdge(m, c);
		graph2.addEdge(h, m);
		graph2.addEdge(m, h);
		graph2.addEdge(b, k);
		graph2.addEdge(k, b);
		graph2.addEdge(j, b);
		graph2.addEdge(b, j);
		graph2.addEdge(k, h);
		graph2.addEdge(h, k);
		graph2.addEdge(c, l);
		graph2.addEdge(l, c);
		
		System.out.println(graph2.getDistance(a, a));
		System.out.println(graph2.getDistance(i, o));
		System.out.println(graph2.getDistance(l, h));
		System.out.println(graph2.getDistance(f, e));
		System.out.println(graph2.getDistance(p, j));
		System.out.println(graph2.getDistance(o, n));
		System.out.println(graph2.getDistance(n, o));
		System.out.println(graph2.getDistance(o, j));

		System.out.println("\n");
		
		//graph3 Tests - checking error handling
		FriendshipGraph graph3 = new FriendshipGraph();
		Person x = new Person("x");
		Person y = new Person("y");
		//One or both nodes doesnt exist, return -1
		System.out.println(graph3.getDistance(x,y)); 
		graph3.addVertex(x);
		//Adding edge between nonexisting nodes
		graph3.addEdge(x,y);
		graph3.addVertex(y);
		//Adding existing person to graph
		graph3.addVertex(y);
		graph3.addEdge(x, y);
		graph3.addEdge(y, x);
		//Adding existing edge
		graph3.addEdge(x,y);
		
		System.out.println(graph3.getDistance(x,y)); //print 1
		System.out.println(graph3.getDistance(y,x)); //print 1
		// You should write more samples to be confident in the
		// correctness of your solution.
	}
}
