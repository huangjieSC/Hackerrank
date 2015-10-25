/*
 * Complete the function below.
 */
    static class Gear {
        int radius;
        int cost;
         int index;
        
        Gear(int radius, int cost, int index) {
            this.radius = radius;
            this.cost = cost;
            this.index = index;
        }
    }

     static int[] Circles(int distance, int[] radius, int[] cost) {
         
        int len = radius.length;
        Gear[] gear = new Gear[len];
        
        for (int i = 0; i < len; i++){
            Gear item = new Gear(radius[i], cost[i], i);
            gear[i] = item;
        }
        
        Arrays.sort(gear, new Comparator<Gear>(){
            public int compare(Gear a, Gear b){
                return a.radius-b.radius;
            }
        });
         
        int[] output = new int[len];
        
        for (int i = 0; i < len; i++) {
            int target = distance - gear[i].radius;
            
            if (target <= 0) {
                output[gear[i].index] = 0;
                continue;
            }
            
            //int startIndex = binarySearch(gear, target);
            // bs for start index
            int front = 0, back = len-1;
            int startIndex = -1;
            while(front<=back){
                int mid = (back-front)/2+front;
                if(gear[mid].radius<target){
                    front = mid+1;
                }else if(gear[mid].radius>target) {
                    startIndex = mid;
                    back=mid-1;
                }else{
                    //while(mid>0 && gear[mid-1].radius==gear[mid].radius){
                    //    mid--;
                    //} 
                    startIndex = mid;
                    break;
                }
            }
             if (startIndex != -1) {
                int minCostIndex = findMinCostIndex(gear, startIndex);
                output[gear[i].index] = gear[minCostIndex].index + 1;
            } else {
                output[gear[i].index] = 0;
            }
        }
        
        return output;
    }

    static int binarySearch(Gear[] A, int val) {
        int start = 0, end = A.length-1;
        int mid = 0;
        while (start +  1 < end) {
            mid = start + (end - start)/2;
            
            if(A[mid].radius == val) {
                end = mid;
            } else if (A[mid].radius < val) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start].radius == val) {
            return start;
        } else if (A[end].radius == val) {
            return end;
        }
        return -1;
    }

    static int findMinCostIndex(Gear[] A, int start) {
        int ans = start;
        for (int j = start + 1; j < A.length; j++) {
            if (A[j].cost <= A[ans].cost) {
                ans = j;
            }
        }
               
        return ans;
    }
