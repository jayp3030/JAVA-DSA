private BinaryNode insertNode(BinaryNode node , int nodeValue){

    //     if (node == null) {
    //         BinaryNode newNode = new BinaryNode();
    //         newNode.value = nodeValue;
    //         newNode.height = 1;
    //         return newNode;
    //     }
    //     else if (nodeValue < node.value) {
    //         node.left =  insertNode(node.left, nodeValue);
    //     }
    //     else{
    //         node.right = insertNode(node.right, nodeValue);
    //     }

    //     node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    //     int balance = getBalance(node);

    //     if (balance > 1 && nodeValue < node.left.value) {             // left left condition
    //         return rotateRight(node);
    //     }

    //     if (balance > 1 && nodeValue > node.left.value) {           // left rigth condition
    //         node.left = rotateLeft(node.left);                      // first left rotate child of node
    //         return rotateRight(node);                                // then right rotate the node
    //     }

    //     if (balance < -1 && nodeValue > node.right.value) {          // right right condiion
    //         return rotateLeft(node);
    //     }

    //     if (balance < -1 && nodeValue < node.right.value) {          // right left condition
    //         node.right = rotateRight(node.right);                   // first right rotate child of node
    //         return rotateLeft(node);                                // then left rotate the node
    //     }

    //     return node;
    // }