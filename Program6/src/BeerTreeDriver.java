import javax.swing.*;

public class BeerTreeDriver {

    public static void main(String[] args) {

        //Adding 15 Beers to a new tree
        BeerTree tree = new BeerTree();
        tree.add(new Beer(1, "BUDWEISER", "BUDWEISER"));
        tree.add(new Beer(2, "SAM ADAMS", "SAM ADAMS BOSTON LAGER"));
        tree.add(new Beer(3, "MILLER", "MILLER LITE"));
        tree.add(new Beer(4, "COORS BANQUET", "COORS BANQUET"));
        tree.add(new Beer(5, "PBR", "PBR"));
        tree.add(new Beer(6, "BLUE MOON BELGIAN WHITE", "BLUE MOON BELGIAN WHITE"));
        tree.add(new Beer(7, "OLD STYLE", "OLD STYLE"));
        tree.add(new Beer(8, "SCHLITZ", "SCHLITZ"));
        tree.add(new Beer(9, "SIERRA", "SIERRA NEVADA PALE ALE"));
        tree.add(new Beer(10, "STROH’S", "STROH’S"));
        tree.add(new Beer(11, "FAT TIRE", "FAT TIRE AMBER ALE"));
        tree.add(new Beer(12, "MICHELOB", "MICHELOB ULTRA"));
        tree.add(new Beer(13, "COLT", "COLT 45"));
        tree.add(new Beer(14, "YUENGLING", "YUENGLING TRADITIONAL LAGER"));
        tree.add(new Beer(15, "CORONA", "CORONA LIGHT"));

        //Calling the preOrder method on the tree.
        System.out.println("\nPre Order:");
        tree.preOrder();
        System.out.println("\nPost Order:");
        tree.postOrder();
        System.out.println("\nIn Order:");
        tree.inOrder();

//        System.out.println(tree.depth());
//        System.out.println(tree.count());
        Beer exampleBeer = new Beer(15, "CORONA", "CORONA LIGHT");
        Beer beer = new Beer(15, "CORONA", "CORONA LIGHT");

        System.out.printf("Search for %s\n\tResult is: %s\n", beer.getName(), tree.search(beer));
        System.out.printf("Tree depth: %s\n", tree.depth());

        System.out.println("BUDWEISER".compareToIgnoreCase("BUDWEISER"));
        System.out.println("BUDWEISER".compareToIgnoreCase("MILLER LITE"));
        System.out.println("BUDWEISER".compareToIgnoreCase("SAM ADAMS BOSTON LAGER"));
        System.out.println("BUDWEISER".compareToIgnoreCase("Appalachian"));
        System.out.printf("Are exampleBeer and beer equal: %s", exampleBeer.equals(beer));


    }


}
