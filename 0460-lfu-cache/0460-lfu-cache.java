class Node{
    int key;
    int val;
    int frequency;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key= key;
        this.val= value;
        this.frequency=1;
    }
}

class LRUCache {
    Node head;   //Doubly Linked List
    Node tail;
    int cap=0;
    public LRUCache() {
        cap=0;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next=tail; 
        tail.prev=head;
    }
    
    public void addNode(Node node) {
        node.next=head.next;
        node.next.prev= node;
        head.next=node;
        node.prev=head;
        cap++;
    }  

    public void removeNode(Node node){
        cap--;
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

}

class LFUCache {
    Map<Integer, Node> map;
    Map<Integer, LRUCache> freq;
    int capacity=0;
    int minFreq=0;
    public LFUCache(int capacity) {
        map= new HashMap<>();
        freq= new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            update(node);
            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            node.val= value;
            update(node);
        } 
        else if(map.size()>=capacity){
            LRUCache list = freq.get(minFreq);
            map.remove(list.tail.prev.key);
            list.removeNode(list.tail.prev);

            minFreq=1;
            Node node= new Node(key,value);
            map.put(key,node);

            LRUCache list2= freq.getOrDefault(minFreq, new LRUCache());
            list2.addNode(node);
            freq.put(minFreq, list2);

        }  
        else{
            minFreq=1;
            Node node= new Node(key,value);
            map.put(key,node);

            LRUCache list2= freq.getOrDefault(minFreq, new LRUCache());
            list2.addNode(node);
            freq.put(minFreq, list2);
        } 
    }

    private void update(Node node){
        int currFreq = node.frequency;
        LRUCache list= freq.get(currFreq);
        list.removeNode(node);
        if(list.cap==0 && minFreq==currFreq) minFreq++;

        node.frequency++;

        LRUCache list4= freq.getOrDefault(currFreq+1, new LRUCache());
        list4.addNode(node);
        freq.put(currFreq+1, list4);     

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


//  class Node {
//     Node prev;
//     int key, value, frequency;
//     Node next;

//     Node(int key, int value) {
//         this.key = key;
//         this.value = value;
//         this.frequency = 1;
//     }
// }

// class DLL {
//     Node head, tail;
//     int length;

//     DLL() {
//         head = new Node(-1, -1);
//         tail = new Node(-1, -1);
//         length = 0;
//         head.next = tail;
//         tail.prev = head;
//     }

//     void addNode(Node node) {
//         length++;
//         Node headnext = head.next;
//         node.next = headnext;
//         node.prev = head;
//         head.next = node;
//         headnext.prev = node;
//     }

//     void removeNode(Node node) {
//         length--;
//         Node nodenext = node.next;
//         Node nodeprev = node.prev;
//         nodenext.prev = nodeprev;
//         nodeprev.next = nodenext;
//     }
// }

// class LFUCache {

//     Map<Integer, Node> h;
//     Map<Integer, DLL> hDLL;
//     int capacity, minfreq;

//     public LFUCache(int capacity) {
//         this.h = new HashMap<>();
//         this.hDLL = new HashMap<>();
//         this.capacity = capacity;
//         this.minfreq = minfreq;
//     }

//     public int get(int key) {
//         if (h.containsKey(key)) {
//             Node node = h.get(key);
//             update(node);
//             return h.get(key).value;
//         }
//         else return -1;
//     }

//     public void put(int key, int value) {
        
//         // if(capacity == 0) return;
//         if(h.containsKey(key)) {
//             h.get(key).value = value;
//             update(h.get(key));
//         }
//         else if(h.size() >= capacity)
//         {
//             DLL dllobj = hDLL.get(minfreq);
//             h.remove(dllobj.tail.prev.key);
//             dllobj.removeNode(dllobj.tail.prev);

//             minfreq = 1;
//             Node node = new Node(key, value);
//             h.put(key, node);

//             DLL dllnode = hDLL.getOrDefault(minfreq, new DLL());
//             dllnode.addNode(node);
//             hDLL.put(minfreq, dllnode); 
//         }
//         else {
//             minfreq = 1;
//             Node node = new Node(key, value);
//             h.put(key, node);

//             DLL dllnode = hDLL.getOrDefault(minfreq, new DLL());
//             dllnode.addNode(node);
//             hDLL.put(minfreq, dllnode); 
//         }
//     }

//     void update(Node node) {

//         int currfreq = node.frequency;
//         DLL dllobj = hDLL.get(currfreq);

//         dllobj.removeNode(node);
//         int length = dllobj.length;
        
//         if(length == 0 && minfreq == currfreq) {
//             minfreq = minfreq + 1;
//         }

//         int nfreq = currfreq + 1;
//         node.frequency++;

//         DLL dllnode = hDLL.getOrDefault(nfreq, new DLL());
//         dllnode.addNode(node);
//         hDLL.put(nfreq, dllnode); 
//     }
// }