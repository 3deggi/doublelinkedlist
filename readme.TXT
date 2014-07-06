reverse()
method will reverse the direction of the whole list regardless of which node is calling it.
time complexity O(N) : traversing next and prev. 
space complexity O(1) : no new allocation required for reversing the list

delete()
should remove the node from the list and give us the new node of same index.
time complexity O(1) : only updating the prev and next information
space complexity O(1) : no new allocation 

append(...)
adds the node at the end of the list
time complexity O(1) : only updating the prev and next information
space complexity O(1) : allocating the new node

insertNext(...)
puts the new node just after the current node.
time complexity O(1) : only updating the prev and next information
space complexity O(1) : allocating the new node

===============================================================================

The runnable source code can be also accessed in the online compiler service (ideone): https://ideone.com/zHg9RF

GitHub address : https://github.com/3deggi/doublelinkedlist