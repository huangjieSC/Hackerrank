prime number rules
1. integer > 1
2. only div by self and 1

n    p
0    2
1    3
2    5   
3    7
4    11
5    13
6    17
7    19
...

int nthPrime(int n) {

    if (n  == 0) return 2;
    if (n == 1) return 3;
    
    int count = 1; 
    int number = 5;
    ArrayList<Boolean> notPrime = new ArrayList<Boolean>();
    notPrime
    
    while(true) {
        if (isPrime(number)) {
            count++;
            if (count == n) {
            return number;
        }
        number +=2;
    }
}

// 12 = 3*2*2
// count = 0 -> numnber == 2
// count = 1 -> number == 3
// count = 2 -> number == 5

//  Time complextiy: input: n; best case: we just need to check the first n numbers and see if they are prime numbers, O(n^2); 
//
Let p be the n-th prime number - what is complexity in terms of n and/or p?
// O(p^2)

// if the square root of number I is i, that means any number from i to I does not need to be checked.
// main logic:


// Let's put this concept into your isPrime function:
// you fell offline, try reconnection
// I'll restart the meeting -meeting restarted
// I can hear you - can you hear me?


boolean isPrime(int n) {
//    if (n <= 1) return false;
//    if (n == 2) return true;
//    if (n%2 == 0) return false;
    
    int sqrt = Math.sqrt(n);
    for (int i = 3; i <= sqrt; i++) {
        if (n%i == 0) return false;
    }
    
    return true;
}
