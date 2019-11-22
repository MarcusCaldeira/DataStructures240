public class BeerTreeDriver {

    public static void main(String[] args) {
        BeerTree  Tree = new BeerTree();
        Tree.add(new Beer(3,"Corona", "Corona Light"));
        Tree.add(new Beer(3,"Alexa", "Corona Light"));
        Tree.add(new Beer(3,"BOBOBOB", "Corona Light"));
        Tree.add(new Beer(3,"FLOPS", "Corona Light"));

        System.out.println(Tree.inorde);

    }
}
