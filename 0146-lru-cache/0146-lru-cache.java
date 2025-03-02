class Node
{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int k,int v)
    {
        this.key = k;
        this.value = v;
        this.next = null;
        this.prev = null;
    }

}


class LRUCache {

    HashMap<Integer, Node> map;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int capacity = 0;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public void insertAfterHead(Node temp)
    {
        Node afterHead = head.next;
        temp.next = afterHead;
        temp.prev = head;
        afterHead.prev = temp;
        head.next = temp;
    }

    public void deleteNode(Node temp)
    {
        Node prevNode = temp.prev;
        Node afterNode = temp.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            deleteNode(temp);
            insertAfterHead(temp);
            return map.get(key).value;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            temp.value = value;
            deleteNode(temp);
            insertAfterHead(temp);
            map.put(key,temp);
        }
        else
        {
            if(map.size() == capacity)
            {
                Node lastNode = tail.prev;
                int k = lastNode.key;
                map.remove(k);
                deleteNode(lastNode);
            }
            Node n = new Node(key,value);
            map.put(key,n);
            insertAfterHead(n);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */