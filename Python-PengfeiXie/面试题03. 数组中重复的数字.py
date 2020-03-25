class Solution(object):
    def findRepeatNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        dic = {}
        for i in nums:
            if i not in dic:
                dic[i] = 0
            else:
                return i