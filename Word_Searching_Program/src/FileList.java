
class FileList

{
    wordNode head = new wordNode("");

    public void add(String w) {
        if (head.word == "") {
            head.word = w;
            return;
        }
        wordNode walk = head;
        wordNode before = head;
        while (walk != null) {
            if (walk.word.equals(w)) {
                walk.count++;
                return;
            }
            if (walk.word.compareTo(w) > 0 & before != walk) {
                wordNode a = new wordNode(w);
                before.next = a;
                a.next = walk;
                return;
            } else if (walk.word.compareTo(w) > 0 & before == walk) {
                wordNode a = new wordNode(w);
                a.next = before;
                head = a;
                return;
            }
            before = walk;
            walk = walk.next;
        }

        before.next = new wordNode(w);
    }

}