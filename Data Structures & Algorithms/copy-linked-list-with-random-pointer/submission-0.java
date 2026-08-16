/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //create a hashmap to set the relation 

        if(head==null){
            return null ; 
        }

        Node temp = head ; 
        HashMap<Node,Node> map = new HashMap<>() ; 
        while(temp!=null)
        {
            Node newnode  = new Node(temp.val) ; 
            map.put(temp,newnode);
            temp = temp.next ; 
        }

        //create a new linked list using hashmap 

        temp = head ; 
        while(temp!=null){
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next ; 
        }

return map.get(head);
    }
}
