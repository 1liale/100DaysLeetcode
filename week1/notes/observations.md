# First Week

## _Arrays_

**In-place operations**
> In order to minimize time and space complexity of our implementation,  
oftentimes in-place operations are used (IE Time: O(n), Space: O(1) )

![hash table](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7AwiYZ0nT75en_D2P3Nb2bJVYN6Be3ROeeQ&usqp=CAU)


For example, if we were asked to find the number of missing values from a range of numbers from [1, N], where N is the size of our array, we might feel inclined to use a HashMap to store all the unique values and loop through each to determine which elements within the range have yet to be visited.


Here's my implementation in Java:
```
    HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();

    for (int i = 0; i < nums.length; i++) { 
        seen.put(nums[i] - 1, true);
    }

    List<Integer> output = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (!seen.containsKey(i)) {
            output.add(i + 1);
        }
    }
```

Surely, this works. However a better solution in this case would be to use in-place operation as it is more space efficient. 
> We use the property that all values fall between **[1, N]** and use the input values themselves as the index to keep track of the values **uniquely**. 

We can describe this process using the following algorithm provided by Leetcode:

1. Iterate over the input array one element at a time.
2. For each element nums[i], mark the element at the corresponding location negative if it's not already marked so i.e. _nums[nums[i]-1] * -1_
3. Now, loop over numbers from 1 . . . N and fro each number check if nums[j] is negative. (- means already visited)
4. Count all the indexes at which the values are positive. These are the unvisited values. 

Here's a sample Java solution I wrote:

```
     for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] > 0) {
                output.add(i + 1);
            }
        }
```
<br><hr>



