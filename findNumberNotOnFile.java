// Range: -2^31 to 2^31 = 2^32 * 4  = 2^34 bytes


// 1 st round: iterate the file, put all of them in a hashset
// 2 nd round: iternate from the range in line 1, and see if the integer is in that set
// Complexity: time: O(n), space: O(N)
// 2G = 2^30 * 2 = 2^31 bytes

public ArrayList<Integer> parseFile(){
    // return a list which contains all the integers on the file
}

public long notOnFile(ArrayList<Integer> list, int start, int end) {
    HashSet<Integer> set = new HashSet<Integer>();
    
    for (int i = start; i <= end; i++) {
        set.add(list.get(i));
    }
    
    for (int i = -2^31 + 1; i < 2^31 - 1; i++) {
        if (!set.contains(i)) {
            return (int)i;
        }
    }
    
    return -2^31;    
}


// F1  F2 ......F8
// sizeof(file)/8
// 2GB for each chunk even with duplicates. 

// range? -10 to 10; say N intergers in that range
// F1: 1 5 7
// F2: -10 2 9 // say M intergers on the file
// Complextiy: brute-force: O(N*M)

public long notOnFileHelper(int round, ArrayList<Integer> list) {
   int size = list.size();
    int chunkSize = size/2;
    int startIndex = 0, endIndex = 0;
    
    for (int count = 1; count <= round; count++) {
        startIndex = count*startIndex;
        endIndex = startIndex +  chunkSize - 1;
        
        if (notOnFile(list,startIndex, endIndex) != -2^31) {
            return notOnFile(list);
        } 
    } 
    return -2^31;
}
