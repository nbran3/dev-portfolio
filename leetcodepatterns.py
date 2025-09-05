### Two Pointers often come up in Palindromes, Reversals, merging sorted data, "K" sized comparisons, there are directions, same and opposite directions. Checking pairs or scanning alot using equates to a two pointer. The name two pointers sounds like it is. 

def is_palindrome(s: str) -> bool: #Opposite Direction
    l,r=0, len(s) - 1
    while l < r:
        while l<r and not s[l].isalnum():
            l+=1
        while l < r and not s[r].isalnum():
            r -= 1
        if s[l].lower() != s[r].lower():
            return False
        l += 1
        r -= 1    
    return True


def middle_of_linked_list(head: Node) -> int: #Same direction
    slow = fast = head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
    return slow.val

def subarray_sum_fixed(nums: list[int], k:int) -> int:
    window_sum = 0
    for i in range(k):
        window_sum += nums[i]
    largest = window_sum
    for right in range(k, len(nums)):
         left = right - k
         window_sum -= nums[left]
         window_sum += nums[right]
         largest  = max(largest, window_sum)
    return largest

def maxArea(self, height: List[int]) -> int:
        result = 0
        l, r = 0, len(height) - 1

        while l < r:
            area = (r-l) * min(height[l], height[r])
            result = max(result, area)

            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return result

### Sliding Window - There are two window sizes: 1 - Fixed and 2. Dynamic. Fixed windows are used when finding the max average of any subarray of size k,return the sum of every k-length block, always has k elements, so the window is fixed. For example, a fixed window will
# always have a length of 3, it will never change. Dyanmic windows have windows that can change it can increase or decrease or stay the same. Some examples of using a dynamic array would include finding the longest substring at most K unique characters, what is the 
# smallest subarray with a sum greater than a target or returning the longest windows where a certain rule is valid

## Fixed Window
def fixed_sliding_window(arr, k):
    if k <= 0 or not arr or k > len(arr):
        return []

    result = []
    current_sum = sum(arr[:k])
    result.append(current_sum)

    for i in range(k, len(arr)):
        current_sum = current_sum - arr[i - k] + arr[i]
        result.append(current_sum)
    
    return result

## Dynamic Window 
def dynamic_sliding_window(arr, target):
    if not arr or target <= 0:
        return 0

    min_length = float('inf')
    window_sum = 0
    start = 0

    for end in range(len(arr)):
        window_sum += arr[end]

        while window_sum >= target:
            min_length = min(min_length, end - start + 1)
            window_sum -= arr[start]
            start += 1
    
    if min_length == float('inf'):
        return 0
    else:
        return min_length

### Binary Search
def binary_search(arr: list[int], target: int) -> int:
    low = 0
    high = len(nums) - 1
    while low <= high:
        m = low + (high-low)// 2
        if nums[m] > target:
            high = m - 1
        elif nums[m] < target:
            low = m + 1
        else:
            return m
    return - 1
