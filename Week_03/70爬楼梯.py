# 找最近重复子问题

# if else
# for while, recursion

# 数学归纳法
# 1: 1
# 2: 2
# 3: f(1) + f(2), mutual exclusive, complete exhaustive
# 4: f(2) + f(3)
# n: f(n) = f(n-1) + f(n-2) : Fibonacci
class Solution(object):

    def climbStairs(self, n):
        # recursion terminator
        if(n <= 2):
            return n;
        
        # process logic in current level
        f1, f2, f3 = 1, 2, 3

        // drill down
        for i in range(3, n+1):
            f3 = f1 + f2
            f1 = f2
            f2 = f3
        return f3

                     