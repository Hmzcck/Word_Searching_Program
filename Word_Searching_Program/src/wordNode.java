public class wordNode {
    String word = "";
    int count = 0;
    public wordNode next;
    public wordNode(String a)
    {
        this.word = a;
        this.count++;
        this.next = null;
    }
}
